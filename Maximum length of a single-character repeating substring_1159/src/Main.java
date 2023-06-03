class Solution {
    public static int maxRepOpt1(String text) {
        int res = 0;
        char[] chars = text.toCharArray();

        int[] letter = new int[26];
        for (char aChar : chars) {
            System.out.println(aChar - 'a');
            letter[aChar - 'a']++;
        }

        int left = 0;
        char tmp = '0';
        while(left < chars.length) {
            if (tmp == chars[left])
            {
                left++;
                continue;
            } else {
                tmp = chars[left];
            }

            int max = 1;
            int count = 0;
            int right = left + 1;
            while(right < chars.length) {
                if (chars[right] == tmp) {
                    max++;
                } else {
                    if (count == 1) {
                        break;
                    }
                    count++;
                }
                right++;
            }
            if (max < letter[tmp - 'a']) {
                max++;
            }

            res = Math.max(res, max);
        }

        return res;
    }
}