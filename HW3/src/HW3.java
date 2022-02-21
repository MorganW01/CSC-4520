import java.util.ArrayList;
import java.util.Collections;

class HW3 {
    public static void heapify(ArrayList<Integer> heap, int i) {
        //declare size
        int size = heap.size();
        //largest node
        int largest = i;
        // define left and right nodes
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;

        //checks left and right node values against the largest and assigns variables accordingly based on conditions.
        if (left < size && heap.get(left) > heap.get(largest))
            largest = left;
        if (right < size && heap.get(right) > heap.get(largest))
            largest = right;

        if (largest != i) {
            int temp = heap.get(largest);
            heap.set(largest, heap.get(i));
            heap.set(i, temp);
            //recursive call to heapify
            heapify(heap, largest);
        }
    }

    public static void heapAdd(ArrayList<Integer> heap, int value) {
        //stores the size of the array
        int size = heap.size();
        //adds the new value to the heap
        heap.add(value);
        //heapifies the heap with the new value
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(heap, i);
        }
    }


    public static int extractMax(ArrayList<Integer> heap) {
        //stores max: first element in the array at the index 0
        int max = heap.get(0);
        //removes it from array
        heap.remove(0);
        //fixes the size of the array
        heap.trimToSize();
        //heapifies again
        heapify(heap, 0);
        //returns max
        return max;

    }


    public static ArrayList<Integer> heapSort (ArrayList<Integer> array) {
        //n is the size of the array
        int  n = array.size();

        //two new array lists heap and result
        ArrayList<Integer> heap = new ArrayList<>(n);
        ArrayList<Integer> result = new ArrayList<>(n);
        //adds all values of list into the heap
        for (int i=0; i< n-1; i++){ // n-1
            heapAdd(heap, array.get(i));

        }


        //adds values of the heap from largest to smallest by extracting max each time
        while(heap.size() > 0){
            result.add(extractMax(heap));
        }

        //reverses the array so it's smallest to largest (max heap is largest to smallest by default)
        Collections.reverse(result);
        return result;


    }

    public static void main(String[] args) {
        //driver method

        //creates test case 1 array
        ArrayList<Integer> testcase1 = new ArrayList<>();
        //adds all elements
        testcase1.add(1);
        testcase1.add(4);
        testcase1.add(5);
        testcase1.add(1);
        testcase1.add(3);
        testcase1.add(4);
        testcase1.add(2);
        testcase1.add(6);

        //creates test case 2 array
        ArrayList<Integer> testcase2 = new ArrayList<>();
        //adds all elements
        testcase2.add(99);
        testcase2.add(23);
        testcase2.add(412);
        testcase2.add(56);
        testcase2.add(23);
        testcase2.add(49);
        testcase2.add(523);


        System.out.println("Test case 1 result: "+ heapSort(testcase1));
        System.out.println("Test case 2 result: "+ heapSort(testcase2));

    }
}
