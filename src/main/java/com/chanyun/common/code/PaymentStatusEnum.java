package com.chanyun.common.code;

/**
 * 支付状态enum
 *
 * @author hao.li
 */
public enum PaymentStatusEnum implements IChanEnum<PaymentStatusEnum>{

    PAY_SUCCESS(0,"支付成功"), PAY_FAIL(1,"支付失败"), ORDER_CLOESE(2,"订单关闭");

    private final int code;

    private final String desc;

    /*
     * @param code
     * @param desc
     */
    private PaymentStatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 获取code
     *
     * @return code
     */
    @Override
    public int code() {

        return this.code;
    }

    /**
     * 获取desc
     *
     * @return desc
     */
    @Override
    public String desc() {

        return this.desc;
    }

    /**
     * 判断code是否相等
     * 
     * @param code
     * @return true-相等, false-不等
     */
    @Override
    public boolean equals(int code) {

        return this.code == code;
    }

}
