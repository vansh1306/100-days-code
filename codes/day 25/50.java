class Solution {
    static boolean isLeap(int N) {
        if(N % 400==0 || N % 4==0 && N % 100!=0  )
         return true;
        return false;
    }
}