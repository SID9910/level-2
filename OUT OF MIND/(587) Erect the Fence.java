class Solution {
    //very very difficult pure geometry hai
    //out of mind question nhi hoga 
    public class point{
        int x ;
        int y;
        point(int x ,int y){
            this.x =x;
            this.y =y;
        }
    }
    public int[][] outerTrees(int[][] trees) {
        List<point> points =new ArrayList<>();
        for(int[] point:trees){
            points.add(new point(point[0],point[1]));
        }
        List<point> res = new ArrayList<>();
        if(points.size()==1){
            return trees;
        }
        int n=points.size();
      
        Collections.sort(points ,(a,b)-> a.y==b.y ?a.x -b.x:a.y-b.y);
       
        HashSet<ArrayList<Integer>> dup = new HashSet();
        
        Stack<point> hull =new Stack<>();
       hull.push(points.get(0));
       hull.push(points.get(1));
       
       for(int i=2;i<n;i++){
           point top =hull.pop();
           while(!hull.isEmpty() && ccw(hull.peek() ,top ,points.get(i))<0){
               top =hull.pop();
           }
           hull.push(top);
           hull.push(points.get(i));

       }
       for(int i=n-2;i>=0;i--){
           point top =hull.pop();
           while(!hull.isEmpty() && ccw(hull.peek() ,top ,points.get(i))<0){
               top =hull.pop();
           }
           hull.push(top);
           hull.push(points.get(i));
           
       }


       for(point x:hull){
           ArrayList<Integer> tmp = new ArrayList<>();
           tmp.add(x.x);
           tmp.add(x.y);
           if(dup.contains(tmp)) continue;
           dup.add(tmp);
           res.add(x);
       }
       int[][] ans = new int[res.size()][2];
       int i=0;
       for(point p:res){
           ans[i][0]=p.x;
           ans[i][1]=p.y;
            i++;
       }
       return ans;
       }
       public int ccw(point a ,point b ,point c){
           double crossproduct =(b.x-a.x)*(c.y-a.y) -(b.y-a.y)*(c.x-a.x);
           if(crossproduct<0){
               return -1;

           }else if(crossproduct>0){
               return +1;
           }else{
               return 0;
           }

       }






    

}