import java.util.ArrayList;

public class HW3_2 {

    public static void heapAdd(int[] arr, int value){
        int n = arr.length;

        n = n+1;

        value = arr[n - 1];

        heapify(arr, n, value);

    }

    public static int extractMax(int[] heap)
    {
        int popped = (heap[1]);
        heap[1] = heap.length-1;
        heapify(heap, heap.length, 1);
        return popped;
    }




    static void heapify(int arr[], int n, int i)
    {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // If largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }


    public static ArrayList heapSort(int[] array) {
       int  n = array.length;

       int[] heap = new int[n];

       ArrayList result = new ArrayList(n);
       for (int i=0; i<n-1; i++){
           heapAdd(heap, array[i]);

       }

       while (heap.length > 0){
           result.add(extractMax(heap));

       }

       return result;

    }

    public static void main(String []args){
        int [] testcase1 = {1,4,5,1,3,4,2,6};

        int [] testcase2 = {99, 23,412,56,23,49,523};

        heapSort(testcase1);
        heapSort(testcase2);

    }


}
