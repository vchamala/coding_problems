class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> evalStack = new Stack<Integer>();
        // at every num1 num2 operation - sequence do op and keep in position..
        for (int i=0; i<tokens.length; i++) {
            // now if the string is operation.. push result into stack - it means that top of stack must always have 2 integers .. whenever we face an operation symbol in the array..
            if (tokens[i].equals("+")) {
                int num1 = Integer.valueOf(evalStack.pop());
                int num2 = Integer.valueOf(evalStack.pop());
                evalStack.push(num1+num2);
            } else if (tokens[i].equals("-")) {
                int num1 = Integer.valueOf(evalStack.pop());
                int num2 = Integer.valueOf(evalStack.pop());
                evalStack.push(num2-num1);        
            } else if (tokens[i].equals("*")) {
                int num1 = Integer.valueOf(evalStack.pop());
                int num2 = Integer.valueOf(evalStack.pop());
                evalStack.push(num1*num2);        
            } else if (tokens[i].equals("/")) {
                int num1 = Integer.valueOf(evalStack.pop());
                int num2 = Integer.valueOf(evalStack.pop());
                evalStack.push(num2/num1);         
            } else {
                // else .. directly push to stack
                evalStack.push(Integer.valueOf(tokens[i]));
            }
        }   
        // at this point the stack must have only 1 value i.e total result..
        return Integer.valueOf(evalStack.peek());
    }
}
