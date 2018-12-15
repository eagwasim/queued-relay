package services;

public interface QueueService {
    public void queue(Object data);

    public Object dequeue();
}
