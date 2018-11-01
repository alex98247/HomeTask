package MultiThreading;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PoolResource<T> {
    private Stack<T> resource;

    public PoolResource(T[] resource) {

        this.resource = new Stack<>();
        Arrays.stream(resource).forEach(x -> this.resource.push(x));
    }

    public synchronized List<T> getResource(int count) {
        List<T> resource = new LinkedList<>();
        while (this.resource.size() < count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < count; i++) resource.add(this.resource.pop());
        
        return resource;
    }

    public synchronized void freeResources(List<T> freeResource) {
        for (T u : freeResource) resource.push(u);
        notify();
    }
}
