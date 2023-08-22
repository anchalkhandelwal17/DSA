class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        // TC : O(n)
        // SC : O(1)
   // Calculating the sum of values of array
        long sumArr = 0;
        
        // Calculating the sum of first n natural numbers
        long sumNNaturalNum = (n * (n + 1))/2;
        
        // calculating the sum of square of values of array
        long sumArrSqr = 0;
        
        // calculating the sum of square of first n natural numbers
        long sumNNaturalNumSqr = (n * (n+1) * (2 * n + 1))/6;
        
	  // Now calculating sumArr and sumArrSqr
        for(int i=0; i<n; i++){
            sumArr += arr[i];
            sumArrSqr += (long)(arr[i]) * (long)(arr[i]);
        }
        
        // subtracting the sum of values of array - the sum of first n natural numbers
        // sumArr - sumNNaturalNum = x-y
        long val1 = sumArr - sumNNaturalNum; // x-y  
        
        // subtracting the sum of square of values of array - 
        // the sum of square of first n natural numbers
        // sumArrSqr - sumNNaturalNumSqr = x^2-y^2
        long val2 = sumArrSqr - sumNNaturalNumSqr; // x^2-y^2
        
        // x + y = (x^2-y^2)(x-y)
        val2 = val2/val1; // x+y 
        
        // x-y = val1 and x+y = val2
        
        // Finding x and y 
        // x = ((x+y)+(x-y))/2
        long x  = (val1 + val2)/2;
        
        // y = (x+y)-x
        long y = val2 - x;
        
        return new int[]{(int)x, (int)y};
    }
}