package com.chanyun.common.code;

public interface IChanEnum<E extends Enum<?>> {
    int code();

    String desc();

    boolean equals(int var1);
}
