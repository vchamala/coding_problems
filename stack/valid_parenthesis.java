class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (char st: s.toCharArray()) {
            if (st == '{' || st == '[' || st == '(') {
                stack.push(st);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                else {
                    char top = (Character) stack.peek();
                    if (st == '}' && top == '{' || 
                    st == ']' && top == '[' || 
                    st == ')' && top == '(') {
                    stack.pop();
                    } else {
                        return false;
                    }
                }
                
            }
        }
        // at this point, for a valid parenthesis - all the valid open and close 
        // braces must have been taken care of and stack must be empty.
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
