public class QueueUsingArray {

    static int rear;
    static int size;
    static int arr[];

    public QueueUsingArray(int n) {
        arr = new int[n];
        rear = -1;
        size = n;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public void add(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
            return;
        }
        rear++;
        arr[rear] = data;
        System.out.println("Added : " + data); 
    }

    public void remove(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        int front = arr[0];
        for (int idx = 0; idx < rear; idx++) {
            arr[idx]=arr[idx+1];
        }
        rear--;
        System.out.println("removed : "+front);
    }

    public int peek(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
             q.remove();
        }
    }

}
