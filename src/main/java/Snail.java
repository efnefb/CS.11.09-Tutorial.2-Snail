public class Snail {

    /**
     *
     * TODO 5
     *
     * Input: an n x n 2d array.
     * Output: a 1d array of length n^2 that contains the order of elements visited in a snail traversal of the 2d array.
     *
     * Example:
     *
     * Input:
     *
     * {
     *     {1,2,3},
     *     {4,5,6},
     *     {7,8,9}
     * }
     *
     * Output:
     *
     * {1,2,3,6,9,8,7,4,5}
     *
     * @param array2d
     * @return a 1d array containing the order of elements visited in a snail traversal of the 2d array.
     *         returns an empty array if array2d is not square.
     */
    public static int[] flattenSnail(int[][] array2d) {
        if (array2d.length != array2d[0].length) return new int[0];
        int size = (int) Math.pow(array2d.length,2);
        int[] flat = new int[size];
        int i=0;

        for (int[] row: array2d){
            for (int x: row){
                flat[i] = x;
                i++;
                }
        }
        return flat;
    }

    /**
     *
     * TODO 6
     *
     * Input: a 1d array of length n, where n is a perfect square.
     * Output: a 2d array of width == height == sqrt(n) that represents a snail.
     *
     * Example:
     *
     * Input:
     *
     * {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
     *
     * Output:
     *
     * {
     *     {1,2,3,4,5},
     *     {16,17,18,19,6},
     *     {15,24,25,20,7},
     *     {14,23,22,21,8},
     *     {13,12,11,10,9},
     * }
     *
     *
     * @param array1d
     * @return a 2d array of width == height == sqrt(n), where n is the length of the inputted array, that represents a snail.
     *         returns an empty 2d array if the length of array1d is not a perfect square.
     */
    public static int[][] makeSnail(int[] array1d) {
        if (!isPerfectSquare(array1d)) return new int[0][0];
        int n = (int) Math.sqrt(array1d.length);
        int[][] array2d = new int[n][n];

        int y = 0;

        for (int x=0; x<n; x++){
            int[] subarray = new int[n];
            for (int i=y; i<array1d.length; i++){
                if ((i+1)%n!=0){
                    subarray[i%n] = array1d[i];
                }
                else{
                    subarray[i%n] = array1d[i];
                    array2d[x] = subarray;
                    y=i+1;
                    break;
                }
            }
        }

        return array2d;
    }

    /**
     *
     * TODO 1
     *
     * Private helper method that prints the contents of a 1d array.
     * Used mainly for debugging purposes.
     *
     * @param array1d
     */
    private static void print1dArray(int[] array1d) {
        for (int x: array1d){
            System.out.println(x);
        }

    }

    /**
     *
     * TODO 2
     *
     * Private helper method that prints the contents of a 2d array.
     * Used mainly for debugging purposes.
     *
     * @param array2d
     */
    private static void print2dArray(int[][] array2d) {
        for (int[] i: array2d){
            for (int j: i){
                System.out.println(j);
            }
        }

    }

    /**
     *
     * TODO 3
     *
     * Private helper method that checks to see if a 1d array is of a length that is a perfect square.
     *
     * @param array1d
     * @return
     */
    private static boolean isPerfectSquare(int[] array1d) {
        if (array1d==null) return false;
        int sqrt = (int) Math.sqrt(array1d.length);
        if (sqrt * sqrt == array1d.length) return true;
        return false;
    }


    /**
     *
     * TODO 4
     *
     * Private helper method that checks to see if a 2d array is a square.
     *
     * @param array2d
     * @return
     */
    private static boolean isPerfectSquare(int[][] array2d) {
        int biglen = array2d.length;
        int countcols = 0;
        for (int x: array2d[0]) countcols++;

        if (countcols == biglen) return true;
        return false;


    }


}
