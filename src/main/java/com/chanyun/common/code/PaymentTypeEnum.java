
package com.chanyun.common.code;

/**
 * 支付渠道类型Enum
 *
 * @author hao.li
 */
public enum PaymentTypeEnum {

    APP("app", "手机app支付"),
    NATIVE("native", "从电脑端发起支付"),
    JSAPI("jsapi", "微信公众号支付"),
    WAP("wap", "手机网页支付");

    private final String code;

    private final String desc;

    /**
     * 构造函数
     *
     * @param code
     * @param desc
     */
    private PaymentTypeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 获取code
     *
     * @return code
     */
    public String code() {

        return this.code;
    }

    /**
     * 获取desc
     *
     * @return desc
     */
    public String desc() {

        return this.desc;
    }

    /**
     * 判断code是否相等
     *
     * @param code
     * @return true-相等, false-不等
     */
    public boolean equals(String code) {

        return this.code.equals(code);
    }

}
