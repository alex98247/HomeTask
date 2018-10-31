package MultiThreading;

import java.util.List;

public class MyThread extends Thread {
    PoolResource<Integer> resource;

    public MyThread(PoolResource<Integer> resource) {
        this.resource = resource;
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        List<Integer> freeResource = this.resource.getResource(3);
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.resource.freeResources(freeResource);
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

