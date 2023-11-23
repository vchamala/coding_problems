public int findKthLargestElement(int[] arr, int k) {
         int len = arr.length;
         // 1. arr not sorted
         // 2. no repeated elements
         
         // Method 1 - just using normal PriorityQueue.
         
         // ?? - Need to check minHeap implementation...
         PriorityQueue minHeap = new PriorityQueue();
         // insert all elements into PQ.
         for (int i=0; i<len; i++) {
             minHeap.add(arr[i]);
             // If size is going past k - poll.
             if (minHeap.size()>k) {
                 minHeap.poll()
             }
         }
         
         return q.peek();
}
