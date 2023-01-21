package leetcode.range0_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        RestoreIPAddresses obj = new RestoreIPAddresses();
        obj.restoreIpAddresses("25525511135");
        obj.restoreIpAddresses("101023");
        obj.restoreIpAddresses("12345");
    }

    public List<String> restoreIpAddresses(String s) {
        if (s.length() <= 3) return Collections.emptyList();
        if (s.length() == 4)
            return List.of(getIp(s.substring(0, 1), s.substring(1, 2), s.substring(2, 3), s.substring(3, 4)));
        if (s.length() > 12) return Collections.emptyList();

        List<String> res = new ArrayList<>();
        for (int i = 0; i < 3 && i < s.length() - 3; i++) {
            for (int j = i + 1; j < i + 4 && j < s.length() - 2; j++) {
                for (int k = j + 1; k < j + 4 && k < s.length() - 1; k++) {

                    String a = s.substring(0, i + 1);
                    String b = s.substring(i + 1, j + 1);
                    String c = s.substring(j + 1, k + 1);
                    String d = s.substring(k + 1);

                    if (canFormValidIP(a, b, c, d)) res.add(getIp(a, b, c, d));
                }
            }
        }

        return res;
    }

    private boolean canFormValidIP(String a, String b, String c, String d) {
        return isNumberOk(d) && isNumberOk(c) && isNumberOk(b) && isNumberOk(a);
    }

    private static boolean isNumberOk(String num) {
        int n = Integer.parseInt(num);
        return n >= 0 && n <= 255 && num.length() == String.valueOf(n).length();
    }

    private static String getIp(String a, String b, String c, String d) {
        return a + "." + b + "." + c + "." + d;
    }
}
