package com.chanyun.controller;


import com.alibaba.fastjson.JSONObject;
import com.chanyun.bean.ApplyPayReturn;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.constants.WechatKeyConstants;
import com.chanyun.common.constants.WeChatPayConstants.TradeType;
import com.chanyun.common.util.QRCodeKitUtils;
import com.chanyun.common.util.WeChatPayUtil;
import com.chanyun.entity.Merits;
import com.chanyun.entity.MeritsProduct;
import com.chanyun.entity.PaymentApply;
import com.chanyun.entity.User;
import com.chanyun.service.MeritsProductService;
import com.chanyun.service.MeritsService;
import com.chanyun.service.OrderPayService;
import com.chanyun.service.UserService;
import com.chanyun.service.channel.ChannelPaymentFactory;
import com.chanyun.service.channel.weixin.WeixinReturnService;
import com.chanyun.service.impl.PaymentApplyService;
import com.chanyun.vo.CreateOrderVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Api(tags = "支付接口控制类")
@RestController
@RequestMapping("/pay")
@Slf4j
public class PaymentController extends BaseController{
	@Autowired
	private OrderPayService orderPayService;
	@Autowired
	private MeritsProductService meritsProductService;
	@Autowired
	private MeritsService meritsSerivce;
    @Autowired
    private ChannelPaymentFactory channelPaymentFactory;
    @Autowired
    private WeixinReturnService weixinReturnService;
    @Autowired
    private PaymentApplyService paymentApplyService;
    @Autowired
    private UserService userService;
    @Autowired
    private Environment env;

    /**
     * 创建支付订单
     *
     * @param createOrderVo 订单创建输入参数
     * @param response
     * @return
     * @author hao.li
     */
    @SuppressWarnings("unchecked")
	@ApiOperation(value = "支付接口")
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public BaseResult<ApplyPayReturn> orderPay(@RequestBody Merits request, HttpServletResponse response) {
    	Merits merits = meritsSerivce.queryById(request.getId());
    	if(null == merits){
    		log.info("订单参数错误，订单id:"+request.getId());
    		return result(Constants.RESULT_CODE_CHECK_FAIL, "订单参数错误", merits);
    	}
    	
    	if (StringUtils.isEmpty(request.getPayType())){
    		log.info("订单参数错误，未选择支付类型:"+request.getPayType());
    		return result(Constants.RESULT_CODE_CHECK_FAIL, "订单参数错误,支付方式错误", merits);
    	}
    	
    	if (!"weixin".equals(request.getPayType())){
    		log.info("支付类型不包括:"+request.getPayType());
    		return result(Constants.RESULT_CODE_CHECK_FAIL, "订单参数错误,支付方式错误", merits);
    	}
    	
    	MeritsProduct meritsProduct = meritsProductService.queryById(merits.getMeritsProductId());
    	String payAmount = String.valueOf(meritsProduct.getSalePrice());
    	CreateOrderVo orderVo = new CreateOrderVo();
    	orderVo.setChannelType(request.getPayType());
    	orderVo.setPayAmount(payAmount);
    	orderVo.setOrderNo(merits.getMeritsNumber());
    	orderVo.setPaymentType(TradeType.NATIVE.toString());
    	orderVo.setOrderDesc(merits.getTempleName()+" - "+merits.getMeritsName());
    	orderVo.setWeixinSpbillCreateIp(env.getProperty("pay.server.ip"));
    	orderVo.setWeixinProductId(String.valueOf(merits.getMeritsProductId()));
    	BaseResult<String> resultPay = orderPayService.orderPay(orderVo);
    	if(!Constants.RESULT_CODE_SUCCESS.equals(resultPay.getCode())){//支付接口调用失败
    		return result(resultPay.getCode(), resultPay.getMessage(), null);
    	}
    	
    	String resultMsg = resultPay.getData();
    	log.info("支付返回结果："+resultMsg);
    	JSONObject resultJson = JSONObject.parseObject(resultMsg);
    	if( !resultJson.containsKey("code_url") || "".equals(resultJson.getString("code_url"))){
    		return result(Constants.RESULT_CODE_FAIL, "支付错误", merits);
    	}
    	
    	ApplyPayReturn result = new ApplyPayReturn();
    	//将支付url生成二维码
    	String base64Payurl = QRCodeKitUtils.generateQRCode(resultJson.getString("code_url"));
    	result.setPayUrl(base64Payurl);
    	//订单状态更改
    	merits.setPayType(request.getPayType());
    	merits.setMeritsStatus(Constants.MERITS_STATUS_APPLY_PAY);
    	merits = meritsSerivce.updateMerits(merits);
    	if(null == merits) {
    		log.info("支付申请，订单状态更新失败，订单id: "+merits.getId());
    		result(Constants.RESULT_CODE_FAIL, "支付申请失败", merits);
    	}
    	result.setMerits(merits);
        return result(Constants.RESULT_CODE_SUCCESS, "支付申请成功", result);
    }

    /**
     * APP端微信支付回调方法
     *
     * @return
     */
    @ApiIgnore
    @ApiOperation(value = "微信支付回调方法", httpMethod = "POST", notes = "微信支付回调方法")
    @RequestMapping(value = "/weixinReturnNotify", method = RequestMethod.POST)
    public void weixinReturnNotify(HttpServletRequest request, HttpServletResponse response) {
        log.info("进入微信回调方法......");
        String inputLine;
        String notityXml = "";
        try {
            while ((inputLine = request.getReader().readLine()) != null) {
                notityXml += inputLine;
            }
            request.getReader().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("解析出来的xml格式文件：" + notityXml);
        Map<String, String> params = null;
        try {
            params = WeChatPayUtil.xmlToMap(notityXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String backString = weixinReturnService.backReturn(params);
        updateMerits(params);
        try {
            // 告诉微信服务器，我收到信息了，不要在调用回调
            response.getWriter().write(backString);
        } catch (IOException e) {
            log.info("异常信息：" + e);
        }
    }
    
    /**
     * 订单状态更新----后期还需要完善
     * @param params
     */
    public void updateMerits(Map<String, String> params){
    	String payOrderNumber = params.get(WechatKeyConstants.OUT_TRADE_NO);
    	PaymentApply paymentApply = paymentApplyService.queryByPayOrderNo(payOrderNumber);
    	if(null == paymentApply) {
    		log.info("支付记录订单号不存在： "+payOrderNumber);
    		return ;
    	}
    	String meritsNumber = paymentApply.getOrderNo();
    	String payNumber = params.get(WechatKeyConstants.TRANSACTION_ID);
    	BigDecimal meritsAccount = new BigDecimal(params.get(WechatKeyConstants.TOTAL_FEE)).divide(new BigDecimal(100));
    	Merits merits = meritsSerivce.queryMeritsByMeritsNumber(meritsNumber);
    	if(null == merits){
    		log.info("订单编号不存在： "+meritsNumber);
    		return ;
    	}
    	
    	
    	if(merits.getMeritsAccount().compareTo(meritsAccount) != 0){
    		log.info("回调通知金额与支付金额不匹配=======回调金额"+meritsAccount+"============支付金额"+merits.getMeritsAccount() +"==============订单编号 ："+meritsNumber);
    		return ;
    	}
    	merits.setMeritsStatus(Constants.MERITS_STATUS_PAY);
    	merits.setPayNumber(payNumber);
    	merits.setCompletionTime(new Date());
    	Merits result= meritsSerivce.updateMerits(merits);
    	if(null == result ) {
    		log.info("订单状态与payNumber更新失败：订单编号 ："+meritsNumber +"===============payNumber"+payNumber);
    		return ;
    	}
    	log.info("============订单状态修改成功===========");
    	User user = userService.queryUser(merits.getUserId());
    	if(null == user) {
    		log.info("====================订单用户查询失败=================订单编号 ："+meritsNumber);
    		return ;
    	}
    	BigDecimal userAccount = user.getMeritsAccount();
    	userAccount = userAccount.add(meritsAccount);
    	user.setMeritsAccount(userAccount);
    	boolean flag = userService.edit(user);
    	if(!flag) log.info("更新用户功德数失败：用户Id: "+user.getId()+"==================用户功德数量"+meritsAccount);
    }
}
