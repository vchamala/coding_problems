public Queue() {
         int[] arr = new int[size];
         int front;
         int rear;
         int size;
         
         public add(int element) {
             front = element;
             size++;
             arr[size-1] = element;
             // update the array by keeping 
         }
         
         public remove() {
             front = arr[size-2];
             int[] anotherArray = new int[size-1];
             for (int i=0; i<=size-2; i++) {
                 anotherArray[i] = arr[i];
             }
             size--;
             arr = anotherArray;
         }
         
         public add(int element) {
             size++;
             int[] anotherArray = new int[size];
             for (int i=0; i<size; i++) {
                 anotherArray[i] = arr[i];
             }
             anotherArray[size] = element;
             arr = anotherArray;
         }
}
