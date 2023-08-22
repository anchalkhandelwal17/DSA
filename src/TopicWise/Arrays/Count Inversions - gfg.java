class Solution
{
     static long inversionCount(long arr[], long N)
    {
        
        int len = (int)N;
        long count = mergeSort(arr, 0, len - 1);
        return count;
    }

    private static long mergeSort(long arr[], int left, int right) {
        long count = 0;
        if (left >= right){
            return count;
        } 
            int mid = (left + right) / 2;
            count += mergeSort(arr, left, mid);
            count += mergeSort(arr, mid + 1, right);
            count += merge(arr, left, mid + 1, right);
        
        return count;
    }

    private static long merge(long arr[], int left, int mid, int right) {
        int i = left;
        int j = mid;
        ArrayList<Long>  temp= new ArrayList<Long>();
        long count = 0;
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp.add(arr[i]);
                i++;
            } else {
               temp.add(arr[j]);
                j++;
                count += mid - i;
            }
        }

        while (i <= mid - 1) {
           temp.add(arr[i]);
                i++;
        }
        while (j <= right) {
            temp.add(arr[j]);
                j++;
        }
        for (int idx = left; idx <= right; idx++) {
            arr[idx] = temp.get(idx-left);
        }

        return count;
    }
}