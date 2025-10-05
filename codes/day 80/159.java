class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String nn : nodes){
            diff--;
            if(diff < 0){
                return false;
            }
            if(!nn.equals("#")){
                diff += 2;
            }
        }
        return diff == 0;
    }
}