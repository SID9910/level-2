class Solution {

    public double myPow(double x, int n) {
        //ye question main dikkat hai thodi rating bhi aachi nhi hai iski
        //beakr sawal`
          double temp=x;
            if(n==0)
            return 1;
            temp=myPow(x,n/2);
            if(n%2==0)
            return temp*temp;
            else 
            {
            if(n > 0)
                return x*temp*temp;
            else
                return (temp*temp)/x;
            }

    }
}