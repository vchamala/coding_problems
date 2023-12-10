class MinStack {
    
    Stack<Integer> stack = new Stack<Integer>();
    // maintain a minSTack with array (num, countOfNum) -- this is 
    // to keep track of number of min occurences.. this is to..
    // cover the case where a min num is repeatedly pushed..
    Stack<int[]> minStack = new Stack<int[]>();

    public MinStack() {

    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val < minStack.peek()[0]) {
            minStack.push(new int[]{val, 1});
        }
        
        else if (val == minStack.peek()[0]) {
            minStack.peek()[1]++;
        }
        
    }
    
    public void pop() {
        // now as we are popping the stack..
        // check if is the same as minStack.peek .. is yes, decrement the 
        // minStack peek count..
        if (stack.peek().equals(minStack.peek()[0])) {
            minStack.peek()[1]--;
        }
        
        // if we reach minStack peek count to 0 , then pop from the minStack..
        if (minStack.peek()[1] == 0) {
            minStack.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
