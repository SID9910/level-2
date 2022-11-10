class Solution {
    public String makeGood(String s) {
         
         StringBuilder sb = new StringBuilder();
               char[] ch =s.toCharArray();
        int i=0, j=0;
        while(i<s.length())
        {
            if(sb.length()==0)
            {
                sb.append(ch[i]);
                i++;
                j=0;  
                 
            }else if(Math.abs(ch[i]-sb.charAt(j))==32)
            {
                sb.deleteCharAt(j);
                i++;
                j--;
            }else{
                sb.append(ch[i]);
                j++;
                i++;
            }
        }
        return sb.toString();
    }

//  public String makeGood(String s) {  
// StringBuilder newS = new StringBuilder(s);
        
//         // if s has less than 2 characters, we just return itself.
//         while (newS.length() > 1) {
//             // 'find' records if we find any pair to remove.
//             boolean find = false;
            
//             // Check every two adjacent characters, currChar and nextChar.
//             for (int i = 0; i < newS.length() - 1; ++i) {
//                 char currChar = newS.charAt(i), nextChar = newS.charAt(i + 1);
                
//                 // If they make a pair, remove them from 's' and let 'find = true'.
//                 if (Math.abs(currChar - nextChar) == 32) {
//                     newS.deleteCharAt(i);
//                     newS.deleteCharAt(i);
//                     find = true;
//                     break;
//                 }
//             }
            
//             // If we cannot find any pair to remove, break the loop. 
//             if (!find)
//                 break;
//         }
//         return newS.toString();

// }
//  public String makeGood(String s) {
//         // Use stack to store the visited characters.
//         Stack<Character> stack = new Stack<>();
        
//         // Iterate over 's'.
//         for (char currChar : s.toCharArray()) {
//             // If the current character make a pair with the last character in the stack,
//             // remove both of them. Otherwise, we the add current character to stack.
//             if (!stack.isEmpty() && Math.abs(stack.lastElement() - currChar) == 32) 
//                 stack.pop();
//             else
//                 stack.add(currChar);
//         }
        
//         // Returns the string concatenated by all characters left in the stack.
//         StringBuilder ans = new StringBuilder();
//         for (char currChar : stack) 
//             ans.append(currChar);
//         return ans.toString();
//     }
// }
