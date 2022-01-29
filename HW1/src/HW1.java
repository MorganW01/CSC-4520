public class HW1 {

    public static void main(String[] args) {
        // Q1
        System.out.println("Question 1 test cases:");
        int testResult1 = findMissing(new int[] {0, 1, 2, 4, 5});
        System.out.println(testResult1); // should output 3

        int testResult2 = findMissing(new int[] {5, 0, 4, 3, 1});
        System.out.println(testResult2); // should output 2

        int testResult3 = findMissing(new int[] {});
        System.out.println(testResult3); // should output 0

        int testResult4 = findMissing(new int[] {9, 3, 5, 1, 4, 8, 2, 10, 0, 6});
        System.out.println(testResult4); // should output 7


        // Q3
        System.out.println("Question 3 test cases:");
        System.out.println(countFives(123467890)); // should output 0
        System.out.println(countFives(555555));    // should output 6
        System.out.println(countFives(15354));     // should output 2

        // Q4
        System.out.println("Question 4 test cases:");
        // 1,3,5
        int testResult5 = pickTrees(new int[] {1, 2, 3, 4, 5});
        System.out.println(testResult5); // should output 9

        //3,3
        int testResult6 = pickTrees(new int[] {1, 3, 4, 3});
        System.out.println(testResult6); // should output 6

        //5,9
        int testResult7 = pickTrees(new int[] {5, 1, 4, 9});
        System.out.println(testResult7); // should output 14
    }

    /**
     * I approached this problem by storing the length of the array in the variable N. Then calculate the sum of all of the elements
     * store it in variable s. The calculation in the return statement finds the value that is missing in the array.
     * My code works because the syntax is correct and it runs correctly for all of the test cases.
     */
    public static int findMissing(int[] arr) {
        //store length of the array in the integer variable N
        int N = arr.length;
        int s = 0;

        for (int i =0; i <arr.length; i++){
            // calculate the sum of all of the elements in the array and store it in the variable s (sum)
            s +=arr[i];
        }
        // return an integer that is the missing value in the array (N(N+1))/2 - s
        return N *(N+1)/2 - s;
    }

    /**
     * I first consider the base case, if the number is 0, which would return 0 for the amount of fives in the number.
     * Created a variable 'fives' to count the number of fives in the number. I created another variable to take the last digit off
     * of the number and check if it was a five. If it is, fives variable increments. Recursion is used to take the last digit off
     * of the number and check if the next digit is a five. Once finished, the total amount of fives is returned.
     * My code works because the syntax is correct and it runs correctly for all of the test cases.
     */
    public static int countFives(int num) {
        //base case, if the number given is 0, return 0
        if (num == 0){
            return 0;
        }
        //counter variable to keep track of the amount of fives
        int fives = 0;
        //variable to take the last digit from the given number. ex. 125 % 10 = 5
        int individualNum = num % 10;

        // if the number is equal to five, increment the fives variable
        if(individualNum == 5){
            fives++;
            //uses recursion to count fives of the next number. Divides by 10 to take the last digit off.
            return fives + countFives(num/10);
        }
        //if number isn't equal to five, divide by 10 to take the last number off and use recursion to check if next digit is a five.
        else {
            return countFives(num/10);
        }
    }

    /**
     * This question requires a helper function. The initial function contains a return statement that runs the helper method with the
     * given array. The helper method has a base case that first checks if the array length is less than that of the tree, which would mean that no trees are being cut
     * If the array length -1 = the tree then that means there  is only one tree and that is that is the amount of wood we can harvest.
     * The sum and other sum variables use recursion to calculate amount of wood that we can harvest from the trees in the given array. The
     * return statement checks if which sum is bigger and returns it.
     * My code works because the syntax is correct and it runs correctly for all of the test cases.
     */
    //driver method that runs the helper method
    public static int pickTrees(int[] arr) {
        //returns the helper method with the given array and 0 for the initial tree amount.
        return treeHelper(arr, 0);
    }

    public static int treeHelper(int[] arr, int tree){
        // if the length of the array is less that trees then return 0 because no trees are being cut.
        if (arr.length <= tree){
            return 0;
        }

        // if array length -1 = tree (index) return the index of the array at tree.
        if (arr.length-1 == tree){
            return arr[tree];
        }
        /*if taking the first tree, the sum equals the index of the array at tree + recursion to run the function again using the
        value of the tree two indexes away, since we hve to cut down every other tree.
         */
        int sum = arr[tree]+treeHelper(arr, tree+2);

        /*otherSum assumes we are skipping the first tree and cutting down the second tree. We then have to add the value of the
        array at index tree +1 then add it to the value that we get from running the function using the value tree+3 to skip the second
        tree.
         */
        int otherSum = arr[tree+1] + treeHelper(arr, tree+3);

        //we want to harvest as much wood as possible, so we need to find the maximum between sum and otherSum.
        return Math.max(sum, otherSum);

    }

}

