class Solution {
  public:
  int dt(int n){
      if(n<=0){
      return n;
  }
  
  int sum=0;
  int rem=n%10;
  sum=rem+dt(n/10);
  return sum;
  }
    int sumOfDigits(int n) {
      return dt(n);
    }
};