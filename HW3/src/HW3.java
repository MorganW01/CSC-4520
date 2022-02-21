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
        //checks to see where to place left and right nodes
        if (left < size && heap.get(left) > heap.get(largest))
            largest = left;
        if (right < size && heap.get(right) > heap.get(largest))
            largest = right;

        if (largest != i) {
            int temp = heap.get(largest);
            heap.set(largest, heap.get(i));
            heap.set(i, temp);

            heapify(heap, largest);
        }
    }

    public static void heapAdd(ArrayList<Integer> heap, int value) {
        int size = heap.size();
        //checks size of the array and adds values
        if (size == 0) {
            heap.add(value);
        } else {
            heap.add(value);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(heap, i);
            }
        }
    }

    //where the problem is
    public static int extractMax(ArrayList<Integer> heap) {
        //declares max of the heap
        int max = (heap.get(1));
        //decreases size of heap
        heap.set(1, heap.size() - 1);
        //calls heapify method
        heapify(heap, 1);
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

        //reverses the array so it's smallest to largest
        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {
        //driver method

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(4);
        array.add(5);
        array.add(1);
        array.add(3);
        array.add(4);
        array.add(2);
        array.add(6);

        heapSort(array);

    }
}
