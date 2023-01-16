package leetcode.range200_300;

import javax.swing.plaf.synth.SynthLookAndFeel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SummaryRanges {
    public static void main(String[] args) {
        SummaryRanges obj = new SummaryRanges();

        System.out.println(obj.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(obj.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        int start = nums[0];
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last == 1) {
                last = nums[i];
            } else {
                if (start == last) {
                    list.add(String.valueOf(start));
                    start = nums[i];
                    last = start;
                } else {
                    list.add(start + "->" + last);
                    start = nums[i];
                    last = start;
                }
            }
        }
        if (start == last) list.add(String.valueOf(start));
        else list.add(start + "->" + last);
        return list;
    }
}
