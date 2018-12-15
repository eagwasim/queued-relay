package services;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MockSynchronizedQueueImpl implements QueueService {
    private static final Queue<Object> INTEGER_QUEUE = new ConcurrentLinkedQueue<>();

    @Override
    public void queue(Object data) {
        INTEGER_QUEUE.add(data);
    }

    @Override
    public Object dequeue() {
        return INTEGER_QUEUE.remove();
    }
}
