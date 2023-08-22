class Solution {
    public void setZeroes(int[][] matrix) {
        // Instead of using extra space arrays for row and col we can do it in place by using and manipulating matrix[i][0] and matrix[0][j] , if matrix[i][j] == 0 we can mark matrix[i][0] = 0 && matrix[0][j] = 0 and cell [0][0] will overlap so for it we can create separate variable col and use it if matrix[i][j] = 0 && j != 0, we can mark col as 0. After this we can traverse in the matrix apart from the marked row and col and mark cells as 0, if either col or row is 0 for that cell , in the end we can traverse the 0th row and mark its cells and after that 0th col and mark its cells.

        // TC : O(n*m) + O(n*m)
        // SC : O(1)
        int n = matrix.length;
        int m = matrix[0].length;

        int col = 1;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == 0){

                    matrix[i][0] = 0;
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                    else{
                        col = 0;
                    }
                }
            }
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<m; j++){
                if(matrix[i][j] != 0){
                    if(matrix[i][0] == 0|| matrix[0][j] == 0){
                      matrix[i][j] = 0;
                }
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int i=0; i<m; i++) matrix[0][i] = 0;
        }
        if(col == 0){
            for(int i=0; i<n; i++) matrix[i][0] = 0;
        }
    }
}