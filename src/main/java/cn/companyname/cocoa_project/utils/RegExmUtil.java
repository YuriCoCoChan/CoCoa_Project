package cn.companyname.cocoa_project.utils;

import java.util.regex.Pattern;

/**
 * 检查正则表达式
 *
 * @author CoCo
 */
public class RegExmUtil {
    public static Boolean checkMobile(String checkStr) {
        final String mobilePattern = ".*^1(3([0-35-9]\\d|4[1-8])|4[14-9]\\d|5([0-35689]\\d|7[1-79])|66\\d|7[2-35-8]\\d|8\\d{2}|9[13589]\\d)\\d{7}$.*";
        boolean isMatch = Pattern.matches(mobilePattern, checkStr);
        return isMatch;
    }

    public static void checkEmail(String checkStr) {
        final String emailPattern = ".*^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$.*";
        boolean isMatch = Pattern.matches(emailPattern, checkStr);

    }
}
