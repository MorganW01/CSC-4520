import java.util.ArrayList;
import java.util.Collections;

class HW3 {
    public static void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < size && hT.get(l) > hT.get(largest))
            largest = l;
        if (r < size && hT.get(r) > hT.get(largest))
            largest = r;

        if (largest != i) {
            int temp = hT.get(largest);
            hT.set(largest, hT.get(i));
            hT.set(i, temp);

            heapify(hT, largest);
        }
    }

    public static void heapAdd(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(hT, i);
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
            heapAdd(heap, (Integer)array.get(i));

        }

        while(heap.size() > 0){
            result.add(extractMax(heap));
        }

        Collections.reverse(result);
        return result;

    }

    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
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
