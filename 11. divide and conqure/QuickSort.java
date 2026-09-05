public class QuickSort {
    public static void printArr(int arr[]) {
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    public static void qSort(int arr[], int si, int ei) {
        //base 
        if (si >= ei) {
            return;
        }

        //kaam 
        // pivot as last element

        int pidx = partition(arr, si, ei);
        qSort(arr, si, pidx-1);
        qSort(arr, pidx+1, ei);

    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];

        int i = si-1; 
        for (int j=si ; j<ei ; j++){
            if(arr[j] <= pivot ){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            i++;
            int temp = pivot;
            arr[ei] = arr[i]; 
            arr[i] = temp;

        }
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6, 3, 9, 5, 2, 8};
        qSort(arr, 0, arr.length - 1);
        printArr(arr);
    }
}
