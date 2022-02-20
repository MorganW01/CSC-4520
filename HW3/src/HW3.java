import java.util.*;

public class HW3 {

    public static ArrayList<Integer> heapSort(int arr[]){
        //creating max heap by using reverse order in Priority Queue
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i< arr.length; i++) {
            heap.add(arr[i]);
        }
        ArrayList<Integer> heaper = new ArrayList<>();
        while(heap.size()>0)
            heaper.add(heap.remove());
        Collections.reverse(heaper);
        return heaper;
    }
    public static void printer(ArrayList<Integer> arr, int n) {
        for(int i = 0; i < n; i++)
            System.out.print(arr.get(i) + " ");
    }

    public static void main(String args []) {

        int testcase1[] = {1, 4, 5, 1, 3, 4, 2, 6};
        ArrayList<Integer> test1 = heapSort(testcase1);
        printer(test1, test1.size());
        System.out.println();
        int testcase2[] = {99, 23, 412, 56, 23, 49, 523};
        ArrayList<Integer> test2 = heapSort(testcase2);
        printer(test2, test2.size());
    }
}
