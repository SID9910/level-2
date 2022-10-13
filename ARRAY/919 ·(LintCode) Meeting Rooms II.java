/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
      
      int[] start = new int[intervals.size()];
      int[] end =new int[intervals.size()];
     int i=0;
       for(Interval val:intervals){
          start[i] =val.start;
          end[i]=val.end;
          i++;
      }
      Arrays.sort(start);
      Arrays.sort(end);
 
      i=0;
     int  j=0;
int count =0;
int res=Integer.MIN_VALUE;
      while(i<start.length && j<end.length){
          if(start[i]<end[j]){
             count++;
             i++;
          }else{
              count--;
              j++;
          }
res=Math.max(count,res);
      }

return res;
    }
}