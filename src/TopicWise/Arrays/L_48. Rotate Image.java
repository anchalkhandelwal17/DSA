class Solution {
    public void rotate(int[][] matrix) {
        // TC : O(n-1) + O(n/2) + O(n) + O(n/2)
        // SC : O(1)

// Approach : Simply Transpose the matrix, then reverse each row

        for(int i=0; i<matrix.length-1; i++){
            for(int j=i+1; j<matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0; i<matrix.length; i++){

            int start = 0;
            int end = matrix.length-1;

            while(start < end){
                int temp = matrix[i][start];
                matrix[i][start] = matrix[i][end];
                matrix[i][end] = temp;
                start++;
                end--;
            }
        }
    }
}