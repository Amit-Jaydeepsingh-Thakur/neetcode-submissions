class StockSpanner {

    Stack<int[]> st1;
    Stack<int[]> st2;

    public StockSpanner() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public int next(int price) {
        System.out.println(price);
        int ans = 0;

        if (!st1.isEmpty() && st1.peek()[0] <= price) {
            //System.out.println("here");
            while (!st1.isEmpty() && st1.peek()[0] <= price) {
                int[] top = st1.pop();
                //System.out.println(top[0] + " "+ price);
                ans++;
                st2.push(top);
            }

            int[] node = {price, ans + 1};
            ans = node[1];

            while (!st2.isEmpty()) {
                st1.push(st2.pop());
            }

            st1.push(node);
        } else {
            int[] node = {price, 1};
            ans = node[1];

            st1.push(node);
        }
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */