import java.util.LinkedList;
import java.util.Queue;

public class Task2 {
    public static void main(String[] args) {
        Market market = new Market();
        market.acceptOrder("Заказ 1");
        market.acceptOrder("Заказ 2");

        market.update(); // Order delivered: Order 1

        market.acceptOrder("Заказ 3");

        System.out.println("Размер заказа: " + market.getQueueSize()); // Queue size: 2

        market.update(); // Order delivered: Order 2

        System.out.println("Размер заказа: " + market.getQueueSize()); // Queue size: 1

        market.update(); // Order delivered: Order 3

        System.out.println("Размер заказа: " + market.getQueueSize()); // Queue size: 0
    }
}


interface QueueBehaviour {
    void enqueue(String person);
    String dequeue();
    int getQueueSize();
    boolean isQueueEmpty();
}


interface MarketBehaviour {
    void acceptOrder(String order);
    String deliverOrder();
}

// Реализация класса Market
class Market implements QueueBehaviour, MarketBehaviour {
    private Queue<String> queue = new LinkedList<>();
    private String currentOrder;

    @Override
    public void enqueue(String person) {
        queue.add(person);
    }

    @Override
    public String dequeue() {
        return queue.poll();
    }

    @Override
    public int getQueueSize() {
        return queue.size();
    }

    @Override
    public boolean isQueueEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void acceptOrder(String order) {
        currentOrder = order;
    }

    @Override
    public String deliverOrder() {
        String orderToDeliver = currentOrder;
        currentOrder = null;
        return orderToDeliver;
    }

    public void update() {
        if (currentOrder != null) {
            enqueue(currentOrder);
            currentOrder = null;
        }

        if (!isQueueEmpty()) {
            String orderToDeliver = dequeue();
            System.out.println("Заказ доставлен: " + orderToDeliver);
        }
    }
}

