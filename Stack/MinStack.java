package Stack;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MinStack {
    private PriorityQueue<Integer> q = new PriorityQueue<>();
    private ArrayList<Integer> stack = new ArrayList<>();
    private int top;

    public MinStack() {
        this.top = -1;
    }
    
    public void push(int val) {
        this.stack.add(val);
        q.offer(val);
        this.top++;
    }
    
    public void pop() {
        Integer elem = this.top();
        this.stack.remove(this.top);
        q.remove(elem);
        this.top--;
    }
    
    public int top() {
        return this.stack.get(top);
    }
    
    public int getMin() {
        return q.peek();
    }
}
