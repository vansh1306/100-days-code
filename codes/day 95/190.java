class Solution {
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        int curr = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='0' && ch<='9'){
                curr = curr*10+(ch-'0');
            }
            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(op=='+'){
                    stack.push(curr);
                    curr=0;
                }else if(op=='-'){
                    stack.push(-curr);
                    curr=0;
                }else if(op=='*'){
                    stack.push(stack.pop()*curr);
                    curr=0;
                }else if(op=='/'){
                    stack.push(stack.pop()/curr);
                    curr=0;
                }
                op = ch;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum+=stack.pop();
        }
        return sum;
    }
}