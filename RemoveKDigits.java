//The idea here is to iterate through the array and insert numbers into the stack if the current number is greater than the top element in stack, if not, we pop from stack and reduce k.
//We repeat this till k becomes 0.
//We then make the string out of the numbers in stack and we reomve and leading zeros from the result
//Time Complexity: O(n)
//Space Complexity: O(n)
import java.util.Stack;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(char digit: num.toCharArray()){
            while(!st.isEmpty() && k > 0 && st.peek() > digit){
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while(k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c: st){
            sb.append(c);
        }

        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}