package lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class a {
    public static String minNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
////                return  ? 1 : -1;
//                return (o1 + o2).compareTo(o2 + o1);
//            }
//        });
        list.sort((o1, o2) -> (o1 + o2).compareTo(o2 + o2));
//        return list.toString();
        return String.join("", list);
    }


    public static boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length <= 1) return true;
        int i = 0, j = postorder.length - 1;
        return verify(postorder, i, j);
    }

    private static boolean verify(int[] postorder, int i, int j) {
        if (i > j) return true;
        int root = postorder[j];
        int start = i;
//         while (start < j) {
//            if (postorder[start] > root) break;
//            else start++;
//        }
        while (postorder[start] < root) {
            start++;
        }
        for (int k = start; k < j; k++) {
            if (postorder[k] < root) return false;
        }
        return verify(postorder, i, start - 1) && verify(postorder, start, j - 1);
    }

    public int lengthOfLongestSubstring(String s) {
//        int left = 0;
//        int res = 0;
//        for (int i = 0; i < s.length(); i++) {
//            left = Math.max(left, s.lastIndexOf(s.charAt(i)));
//            res = Math.max(res, i - left);
//        }
//        return res;
        int res = 0;
        int[] cnt = new int[128];
        for (int i = 0, j = 0; j < s.length(); j++) {
            cnt[s.charAt(j)]++;
            while (cnt[s.charAt(j)] > 1) {
                cnt[s.charAt(i)]--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10, 2};
        int[] nums1 = {3,30,34,5,9};
        System.out.println(minNumber(nums));
        System.out.println(minNumber(nums1));

    }
}
