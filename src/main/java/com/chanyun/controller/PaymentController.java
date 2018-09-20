package com.chanyun.controller;


import com.alibaba.fastjson.JSON;
import com.chanyun.common.BaseResult;
import com.chanyun.common.Constants;
import com.chanyun.common.util.WeChatPayUtil;
import com.chanyun.entity.PaymentApply;
import com.chanyun.service.channel.ChannelPaymentFactory;
import com.chanyun.service.channel.IChannelCreateOrderService;
import com.chanyun.service.channel.weixin.WeixinReturnService;
import com.chanyun.service.impl.PaymentApplyService;
import com.chanyun.vo.CreateOrderVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Api(description = "支付接口控制类")
@RestController
@RequestMapping("/pay")
public class PaymentController {


    @Autowired
    private ChannelPaymentFactory channelPaymentFactory;
    @Autowired
    private WeixinReturnService weixinReturnService;
    @Autowired
    private PaymentApplyService paymentApplyService;

    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    /**
     * 创建支付订单
     *
     * @param createOrderVo 订单创建输入参数
     * @param response
     * @return
     * @author hao.li
     */
    @ApiOperation(value = "支付接口")
    @ApiImplicitParams({@ApiImplicitParam(dataType = "CreateOrderVo", name
            = "createOrderVo", value = "统一下单请求参数")})
    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    public BaseResult<String> createOrder(@RequestBody CreateOrderVo createOrderVo, HttpServletResponse response) {

        logger.info("统一下单");
        BaseResult<String> baseResult = new BaseResult<String>();

        // 幂等处理(如果订单已经申请支付，则返回预支付字符串，如果为空，则发起支付)
        PaymentApply paymentApply = paymentApplyService.initApply(createOrderVo.getOrderNo(),createOrderVo.getChannelType(),createOrderVo.getPaymentType());
        if(paymentApply != null){
            baseResult.setCode(Constants.RESULT_CODE_SUCCESS);
            baseResult.setMessage("SUCCESS");
            baseResult.setData(JSON.toJSONString(paymentApply.getPrepayData()));
        }else{
            // 发起支付
            IChannelCreateOrderService channelCreateOrderService = channelPaymentFactory
                    .getCreateOrderService(createOrderVo.getChannelType(), createOrderVo.getPaymentType());
            baseResult = channelCreateOrderService.createOrder(createOrderVo);
        }
        return baseResult;
    }

    /**
     * APP端微信支付回调方法
     *
     * @return
     */
    @ApiOperation(value = "微信支付回调方法", httpMethod = "POST", notes = "微信支付回调方法")
    @RequestMapping(value = "/weixinReturnNotify", method = RequestMethod.POST)
    public void weixinReturnNotify(HttpServletRequest request, HttpServletResponse response) {
        logger.info("进入微信回调方法......");
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
        logger.info("解析出来的xml格式文件：" + notityXml);
        Map<String, String> params = null;
        try {
            params = WeChatPayUtil.xmlToMap(notityXml);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String backString = weixinReturnService.backReturn(params);
        try {
            // 告诉微信服务器，我收到信息了，不要在调用回调
            response.getWriter().write(backString);
        } catch (IOException e) {
            logger.info("异常信息：" + e);
        }
    }
}
