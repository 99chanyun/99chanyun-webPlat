package com.chanyun.common.util;

import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public final class StringUtil {
    public static final String EMPTY = "";
    public static final String DEFAULT_SPLIT = ",";

    public StringUtil() {
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static boolean isEmpty(String str) {
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String list2String(List<String> strList, String splitMark) {
        if (strList == null) {
            return "";
        } else {
            String result = "";

            String s;
            for(Iterator var3 = strList.iterator(); var3.hasNext(); result = result + s + splitMark) {
                s = (String)var3.next();
            }

            return result.substring(0, result.length() - splitMark.length());
        }
    }

    public static String list2String(List<String> strList) {
        return list2String(strList, ",");
    }

    public static boolean contains(String source, String s) {
        return source != null && s != null ? source.contains(s) : false;
    }

    public static void main(String[] args) {
    }
}
