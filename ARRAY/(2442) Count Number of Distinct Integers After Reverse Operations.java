 //tc=0(n) space-0(n)
 public int countDistinctIntegers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for(int n: nums){
        set.add(n);
        set.add(reverse(n));
    }
    return set.size();//saare distinct vale honge isme
}

 int reverse(int n){
    int rev = 0;
    while(n != 0){
        int rem = n % 10;
        rev = rev* 10 + rem;
        n /= 10;
    }
    return rev;
}

}


