import java.util.ArrayList;

public class Heap_using_arrayList {
    static class Heap{
        private ArrayList<Integer> arr = new ArrayList<>();

        public void add (int data){
            arr.add(data);

            int x = arr.size()-1;
            int par = (x-1)/2;

            while(arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }
        
        private void heapify(int i){
            int l = (2*i)+1;
            int r = (2*i)+2;
            int minIdx = i;

            if(l < arr.size() && arr.get(minIdx) > arr.get(l)){
                minIdx = l;
            }
            if(r < arr.size() && arr.get(minIdx) > arr.get(r)){
                minIdx = r;
            }
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }
        }

        public int remove(){
            int data = arr.get(0);

            //swap with last
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size() - 1, temp);
            //remove
            arr.remove(arr.size() - 1);
            //fix heap 
            heapify(0);

            return data;

        }

        public boolean isEmpty(){
            return arr.isEmpty();
        }

        private void heapify_heapSort_maxheap(int arr[], int i, int size) {
            int l = (2 * i) + 1;
            int r = (2 * i) + 2;
            int maxidx = i;

            if (l < size && arr[maxidx] < arr[l]) {
                maxidx = l;
            }
            if (r < size && arr[maxidx] < arr[r]) {
                maxidx = r;
            }
            if (maxidx != i) {
                int temp = arr[i];
                arr[i] = arr[maxidx];
                arr[maxidx] = temp;

                heapify_heapSort_maxheap(arr, maxidx, size);
            }
        }

        public void heapSort(int array[]){
            int size = array.length;
            for (int i = size/2; i >= 0; i--) {
                heapify_heapSort_maxheap(array, i, size);
            }
            for (int i=size-1; i>0; i--){
                int temp = array[0];
                array[0] = array[i];
                array[i] = temp;

                heapify_heapSort_maxheap(array, 0, i);
            }
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(3);
        h.add(4);
        h.add(1);
        h.add(5);

        // while (!h.isEmpty()) {
        //     System.out.println(h.peek());
        //     h.remove();
        // }

        int arr[] = {1,2,4,5,3};
        h.heapSort(arr);
        for (int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
