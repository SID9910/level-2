class Solution {
    //     public int strStr(String haystack, String needle) {
          
    //   for (int i = 0; ; i++) {
    //     for (int j = 0; ; j++) {
    //       if (j == needle.length()) return i;
    //       if (i + j == haystack.length()) return -1;
    //       if (needle.charAt(j) != haystack.charAt(i + j)) break;
    //     }
    //   }
            
    //     }
        //o(n)
         public int strStr(String haystack, String needle) {
            int start = 0;
            for (int end = 0; end < haystack.length(); end++) {
                int needleIdx = end - start;
                if (haystack.charAt(end) != needle.charAt(needleIdx)) {
                    end = start;
                    start++;
                    continue;
                }
                if (needleIdx == needle.length() - 1) return start;
            }
            return -1;
        }
    }
    