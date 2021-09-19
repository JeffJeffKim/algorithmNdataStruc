package backjun.sort;

public class QuickSort_Baeldung {

    public static void main(String[] args) {
        int arr[] = new int[]{6, 1, 2, 8, 7, 3, 4, 9, 5};
        quickSort(arr, 0, arr.length-1);
        for(int n : arr)
            System.out.print(n);
    }

    static public void quickSort(int arr[], int begin, int end) {
//        if (begin < end) {
//            int partitionIndex = partition(arr, begin, end);
//
//            quickSort(arr, begin, partitionIndex-1);
//            quickSort(arr, partitionIndex+1, end);
//        }
        if(begin >= end)    return;
        int partitionIndex = partition(arr, begin, end);

        quickSort(arr, begin, partitionIndex-1);
        quickSort(arr, partitionIndex+1, end);
    }

    static private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= arr[end]) {
                swap(arr, j, ++i);
//                i++;
//
//                int swapTemp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = swapTemp;
            }
        }

        swap(arr, end, ++i);

//        int swapTemp = arr[++i];
//        arr[i] = arr[end];
//        arr[end] = swapTemp;

        return i;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
