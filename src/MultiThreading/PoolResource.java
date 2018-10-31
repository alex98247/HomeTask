package MultiThreading;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PoolResource<T> {
    private Stack<T> resource;

    public PoolResource(T[] res) {

        this.resource = new Stack<>();
        for (T u : res) this.resource.push(u);
    }

    public synchronized List<T> getResource(int count) {
        List<T> resource = new LinkedList<>();
        while (true) {
            if (this.resource.size() >= count) {
                for (int i = 0; i < count; i++) resource.add(this.resource.pop());
                break;
            }
        }
        return resource;
    }

    public void freeResources(List<T> freeResource) {
        for (T u : freeResource) resource.push(u);
    }
}
