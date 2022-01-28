public class HW1 {

    public static void main(String[] args) {
        // Q1
        int testResult1 = findMissing(new int[] {0, 1, 2, 4, 5});
        System.out.println(testResult1); // should output 3

        int testResult2 = findMissing(new int[] {5, 0, 4, 3, 1});
        System.out.println(testResult2); // should output 2

        int testResult3 = findMissing(new int[] {});
        System.out.println(testResult3); // should output 0

        int testResult4 = findMissing(new int[] {9, 3, 5, 1, 4, 8, 2, 10, 0, 6});
        System.out.println(testResult4); // should output 7


        // Q3
        System.out.println(countFives(123467890)); // should output 0
        System.out.println(countFives(555555));    // should output 6
        System.out.println(countFives(15354));     // should output 2


        // Q4
        int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
        System.out.println(testResult5); // should output 9

        int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
        System.out.println(testResult6); // should output 6

        int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
        System.out.println(testResult7); // should output 14
    }

    /**
     * Add your key ideas to this comment.
     * How did you approach the problem?
     * Why does your code work?
     */
    public static int findMissing(int[] arr) {

        int N = 0;
        int s =0;

        for (int i =0; i <arr.length; i++){
            N++;
            s +=i;
        }

        return (N *(N+1))/2 - s;

        //store length of the array in the integer variable N

        // calculate the sum of all of the elements in the array and store it in the variable s (sum)

        // return an integer that is the missing value in the array (N(N+1))/2 - s

        //throw new UnsupportedOperationException("findMissing not yet written");
    }

    /**
     * Add your key ideas to this comment.
     * How did you approach the problem?
     * Why does your code work?
     */
    public static int countFives(int num) {
        throw new UnsupportedOperationException("countFives not yet written");
    }

    /**
     * Add your key ideas to this comment.
     * How did you approach the problem?
     * Why does your code work?
     */
    public static int pickTrees(int[] arr) {
        throw new UnsupportedOperationException("pickTrees not yet written");
    }
}

