import java.util.*;

public class HW0 {

    public static void main(String[] args) {
        // Q1
        int testResult1 = maxOfArray(new int[] {1, 3, 4, 5, 2});
        int testResult2 = maxOfArray(new int[] {-1, -3, -4, -5, -2});

        System.out.println(testResult1); // should output 5
        System.out.println(testResult2); // should output -1
        boolean emptyCaseCorrect = false;

        try {

            maxOfArray(new int[] {});


        } catch (IllegalArgumentException e) {
            emptyCaseCorrect = true;
        }
        if (emptyCaseCorrect) {

          System.out.println("maxOfArray appears to work for the empty array case");
        } else {

            System.out.println("maxOfArray appears to be incorrect for the empty array case");

        }


        // Q2 twoSum WORKS
        int[] testResult3 = twoSum(new int[] {0, 2, 3, 4, 5}, 6);
        int[] testResult4 = twoSum(new int[] {1, 2, 3, 4, 5}, 10);

        System.out.println(Arrays.toString(testResult3)); // should output [1, 3]
        System.out.println(Arrays.toString(testResult4)); // should output [-1, -1]


        // Q3 add arrays
        List<Integer> testResult5 = add(Arrays.asList(1, 2, 3), Arrays.asList(2, 4, 2));
        List<Integer> testResult6 = add(Arrays.asList(9, 9, 9), Arrays.asList(1));
        List<Integer> testResult7 = add(Arrays.asList(9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 7, 5, 8, 0, 7), Arrays.asList(1, 2, 3, 4, 5));

        System.out.println(testResult5); // should output [3, 6, 5]
        System.out.println(testResult6); // should output [1, 0, 0, 0]
        System.out.println(testResult7); // should output [9, 2, 2, 3, 3, 7, 2, 0, 3, 6, 8, 5, 4, 7, 8, 8, 1, 5, 2]
    }

    /**
     * Add your key ideas to this comment.
     * How did you approach the problem?
     * Why does your code work?
     */
    public static int maxOfArray(int[] arr) {

        // Initialize maximum element

        if (arr == null || arr.length ==0)

        {
            throw new IllegalArgumentException("array is empty");

        }

        int maxValue = arr[0];


        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > maxValue) {
                maxValue = arr[i];
            }
        }


        return maxValue;
    }

    /**
     * Add your key ideas to this comment.
     * How did you approach the problem?
     * Why does your code work?
     */
    public static int[] twoSum(int[] arr, int targetSum) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }



    /**
     * Add your key ideas to this comment.
     * How did you approach the problem?
     * Why does your code work?
     */
    public static List<Integer> add(List<Integer> lst1, List<Integer> lst2) {




        throw new UnsupportedOperationException("add not yet written");
    }
}

