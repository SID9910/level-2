//{ Driver Code Starts
    import java.util.*;
    import java.lang.*;
    import java.io.*;
    
    class comp implements Comparator<ArrayList<String>> {
        // override the compare() method
        public int compare(ArrayList<String> a, ArrayList<String> b)
        {
            String x = "";
            String y = "";
            for(int i=0; i<a.size(); i++)
                x += a.get(i);
            for(int i=0; i<b.size(); i++)
                y += b.get(i);
            return x.compareTo(y);
        }
    }
    
    public class GFG
    {
        public static void main(String[] args) throws IOException
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T = Integer.parseInt(br.readLine().trim());
            while(T-->0)
            {
                int n = Integer.parseInt(br.readLine().trim());
                String[] wordList = new String[n];
                for(int i = 0; i < n; i++){
                    wordList[i] = br.readLine().trim();
                }
                String startWord, targetWord;
                startWord = br.readLine().trim();
                targetWord = br.readLine().trim();
                Solution obj = new Solution();
                ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
                if(ans.size()==0)
                    System.out.println(-1);
                else
                {
                    Collections.sort(ans, new comp());
                    for(int i=0; i<ans.size(); i++)
                    {
                        for(int j=0; j<ans.get(i).size(); j++)
                        {
                            System.out.print(ans.get(i).get(j) + " ");
                        }
                        System.out.println();
                    }
                }
            }
        }
    }
    // } Driver Code Ends
    
    
    //User function Template for Java
    
    class Solution
    {
        public ArrayList<ArrayList<String>> findSequences(String startword, String targetword, String[] wordlist)
        {
            Set<String> st = new HashSet<String> ();
            int len =wordlist.length;
            
            for(int i=0;i<len;i++){
                st.add(wordlist[i]);
            }
            
            Queue<ArrayList<String>> q = new LinkedList<>(); //list store karenge
            ArrayList<String> ls = new ArrayList<>();
            ls.add(startword);
            q.add(ls);
            
            ArrayList<String> usedOnlist = new ArrayList<>();//jo use ho gai hongi same level per dubara nhi lenge
            
            usedOnlist.add(startword);
            ArrayList<ArrayList<String>> ans = new ArrayList<>();
            
            int level=0;//start level
            while(!q.isEmpty()){
            
                ArrayList<String> vec =q.peek(); //is string pe operation chalenge
                q.remove();
                
                //agle level per jaane ke ley
                if(vec.size()>level){
                    level++; //level badai agle pe jaane ke ley
                    for(String it:usedOnlist){
                        st.remove(it); //ye used ho gay aab nhi lena agle level per
                    }
                    
                }
        
                //list ke akri word per he operation lagenge
                String word = vec.get(vec.size()-1);
                if(word.equals(targetword)){
                    //pehli bar vali list mille
                    if(ans.size()==0){
                        ans.add(vec);
                    }else if(ans.get(0).size()==vec.size()){
                    
                        ans.add(vec); //baaki ki list ke ley
                    }
                    
                }
       
                
                for(int i=0;i<word.length();i++){
                    for(char c='a' ;c<='z';c++){
                        char[] replacearray =word.toCharArray();
                        replacearray[i]=c;
                        String replaceword= new String(replacearray);
                        if(st.contains(replaceword)==true){
                            vec.add(replaceword); //vec ki list baadi kar di
                            ArrayList<String> temp = new ArrayList<>(vec);
                            q.add(temp); //list store kar di
                            
                            usedOnlist.add(replaceword);
                            vec.remove(vec.size()-1); //ye word jo le lea hai usse agli sequence main nhi lena isley
                        }
                        
                        
                    }
                }
                
            }
          
            return ans;
          
        }
    }