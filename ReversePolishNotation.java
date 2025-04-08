//The approach here is to put the numbers in the stack as we keep iterating through the string array. When we encounter an operator, we pop two numbers, evaluate the result and put the result back into the stack.
//Finally, the only element in the stack is the result
//Time Complexity: O(n) where n is the length of the array
//Space Complexity: O(n)

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int n = tokens.length;
        for(int i = 0; i<n; i++){
            String ch = tokens[i];
            if(ch.equals("+")){
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(num1+num2);
            } else if(ch.equals("-")){
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(num2-num1);
            } else if(ch.equals("*")){
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(num2 * num1);
            } else if(ch.equals("/")){
                int num1 = st.pop();
                int num2 = st.pop();
                st.push(num2/num1);
            } else {
                st.push(Integer.parseInt(ch));
            }          
        }
        return st.pop();  
    }
}