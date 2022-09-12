class Solution {
    //two pointer technique
    public int bagOfTokensScore(int[] tokens, int power) {
      //base case
        if (tokens.length == 0) return 0;
        if (tokens.length == 1) {
            if (power >= tokens[0]) {
                return 1;
            }else return 0;
        }
        int score = 0;
        Arrays.sort(tokens); 
        int left = 0;
        int right = tokens.length-1;

        while (left <= right) {
            //face up condition in which score increases
            if (tokens[left] <= power) {
                power -= tokens[left];
                score++;
                left++;//increment token index also
            
            }//condition to score greater than 1 and start from last
        else if (score >= 1 && tokens[right] >= power) {
                if (left == right) {
                    return score; //game stop
                }
                power += tokens[right]; // If we can play face-down
                score--;//power increases and score decreases
                right--;
            }else 
            return score; 
        }
        return score;
    }
}

 