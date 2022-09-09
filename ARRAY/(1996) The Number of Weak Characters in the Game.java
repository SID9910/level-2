class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
      int n=properties.length;
        //is sort main thoda or perfect hona hoga
Arrays.sort(properties, new Comparator<int[]>() { // sorting based on array elements
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
int c= 0;
int max=0;
for(int i = 1; i < n; i++) {
if(properties[max][0]>properties[i][0] && properties[max][1]>properties[i][1])
c++;
else
max = i;
}
return c;
}  
    }
