import java.util.Arrays;

public class OddEvenMergeSort {
    boolean DEBUG = false; //code for debugging/printing

    /**
     * sorting method, to sort an integer array in increasing order
     * complexity: O(n*log(n)) -> recurrsion is calling log(n) times, and all the other methods have complexity of O(n)
     * @param arr int array to be sorted
     * @return sorted int array
     */
    public int[] sort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        // Separate the input into two arrays (stored at separated[0] and separated[1].
        // Split based on odd/even indices.
        int[][] separated = separateOddEven(arr);
        
        if(DEBUG){
            System.out.println("separated[0] " + Arrays.toString(separated[0]));
            System.out.println("separated[1] " + Arrays.toString(separated[1]));
        }

        // Recursively sort the separated arrays.
        int[] odd = sort(separated[0]);
        int[] even = sort(separated[1]);

        if(DEBUG){
            System.out.println("odd " + Arrays.toString(odd));
            System.out.println("even " + Arrays.toString(even));
        }
        
        // Merge the separated arrays back together. Merge based on odd/even indices.
        int[] merged = oddEvenMerge(odd, even);
        
        if(DEBUG){
            System.out.println("merged " + Arrays.toString(merged));
        }


        // Put the merged array into the correct order (this step can also be done in
        // the oddEvenMerge
        int[] sorted = compareExchange(merged);
        if(DEBUG){
            System.out.println("sorted " + Arrays.toString(sorted));
        }

        return sorted;

    }

    /**
     * method to split the array in half according their indexed (even/odd indexes)
     * complexity: O(n) -> n=length of the input array
     * @param arr array to be splitted
     * @return 2D array - splitted given array according the odd/even indexes
     */
    public int[][] separateOddEven(int[] arr) {
        // TODO: Separate input array into odd and even arrays
        int[] even = new int[arr.length/2];
        int[] odd = new int[arr.length/2 + arr.length%2];

        int evenCurrentIndex = 0;
        int oddCurrentIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i % 2 == 0){
                odd[oddCurrentIndex] = arr[i];
                oddCurrentIndex++;
            }
            else{
                even[evenCurrentIndex] = arr[i];
                evenCurrentIndex++;
            }
        }

        int[][] separeted = new int[][]{odd, even};
        return separeted;
    }

    /**
     * method that merges two separate arrays into one (output array o1,e1,o2,e2....)
     * complexity: O(n) -> n=Math.min(oddArr.length,evenArr.length) -> just one loop through an array of length n
     * @param oddArr array1
     * @param evenArr array2
     * @return merged array (length = oddArr+evenArr)
     */
    public int[] oddEvenMerge(int[] oddArr, int[] evenArr) {
        // TODO: Helper method to merge two sorted arrays (oddArr, evenArr) into a
        // single sorted array (output) using the OddEvenMerge algorithm
        int[] merged = new int[oddArr.length+evenArr.length];
        
        for (int i = 0; i < Math.min(oddArr.length,evenArr.length); i++) {
            merged[2*i+1] = evenArr[i];
            merged[2*i] = oddArr[i];
        }

        if(oddArr.length < evenArr.length){
            merged[merged.length-1] = evenArr[evenArr.length-1];
        }
        else if(oddArr.length > evenArr.length){
            merged[merged.length-1] = oddArr[oddArr.length-1];
        }
        return merged;
    }

    /**
     * method to loop through an array once and exchange the elements if element i+1 < element i
     * complexity: O(n) -> n=length of an array -> just one loop through an array of length n
     * @param output array
     * @return array after performing compare-exchange on it
     */
    public int[] compareExchange(int[] output) {
        // TODO: Create the method to perform compare-exchange of elements in the output
        // array
        for (int i = 1; i < output.length; i++) {
            if(output[i-1] > output[i]){
                int temp = output[i-1];
                output[i-1] = output[i];
                output[i] = temp;
            }
        }
        return output;
    }

}
