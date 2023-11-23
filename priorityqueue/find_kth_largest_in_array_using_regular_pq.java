public int findKthLargestElement(int[] arr, int k) {
         int len = arr.length;
         // 1. arr not sorted
         // 2. no repeated elements
         
         // Method 1 - just using normal PriorityQueue.
         PriorityQueue q = new PriorityQueue();
         // insert all elements into PQ.
         for (int i=0; i<len; i++) {
             q.add(Comparator.comparing(arr[i]));
             if (q.size()>k) {
                 q.poll()
             }
         }
         
         // now pop n-k elements - so that the topmost is Kth
         for (int i=0; i<k; i++) {
             q.pop();
         }
         return q.peek();
}
