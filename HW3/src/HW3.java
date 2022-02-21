import java.util.ArrayList;
import java.util.Collections;

class HW3 {
    public static void heapify(ArrayList<Integer> heap, int i) {
        int size = heap.size();
        int largest = i;
        int left = (2 * i) + 1;
        int right = (2 * i) + 2;
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
        if (size == 0) {
            heap.add(value);
        } else {
            heap.add(value);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(heap, i);
            }
        }
    }

    public static int extractMax(ArrayList<Integer> heap) {
        int max = (heap.get(1));
        heap.set(1, heap.size() - 1);
        heapify(heap, 1);
        return max;
    }


    public static ArrayList<Integer> heapSort (ArrayList<Integer> array) {
        int  n = array.size();

        ArrayList<Integer> heap = new ArrayList<>(n);

        ArrayList<Integer> result = new ArrayList<>(n);
        for (int i=0; i< n-1; i++){ // n-1
            heapAdd(heap, array.get(i));

        }

        while(heap.size() > 0){
            result.add(extractMax(heap));
        }

        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {

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
