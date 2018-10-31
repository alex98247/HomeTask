import MultiThreading.MyThread;
import MultiThreading.PoolResource;

public class Main {

    public static void main(String[] args) {
        PoolResource<Integer> resource = new PoolResource(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0});
        for (int i = 0; i < 4; i++) {
            new MyThread(resource).start();
        }
    }
}
