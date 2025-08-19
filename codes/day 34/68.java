class Solution {
    public int[] decrypt(int[] code, int k) {
        if(k == 0)
            return new int[code.length];

        int[] ans = new int[code.length];
        for(int i=0; i<code.length; i++){
            if(k > 0){
                for(int j = i + 1; j<=i+k; j++){
                    ans[i] += code[j % code.length];
                }
            }
            else{
                int absk = -k;
                int index = 0;
                int j = code.length - absk + i;
                while(index < absk){
                    ans[i] += code[j % code.length];
                    j++;
                    index++;
                }
            }
        }
        return ans;
        
    }
}