package scratch;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Trading {

    private static TreeMap<Integer, Queue<Order>> matcher = new TreeMap<>();

    public static void main(String[] args) {
        Buyers buyers = new Buyers(matcher);
        Sellers sellers = new Sellers(matcher);

        buyers.start();
        sellers.start();

        while (true) {
            matcher.values().forEach(orderQueue -> {
                List<Order> buyersInQueue = orderQueue.stream().filter(order -> order.getOrderType() == ORDER_TYPE.BUY).collect(Collectors.toList());
                List<Order> sellersInQueue = orderQueue.stream().filter(order -> order.getOrderType() == ORDER_TYPE.SELL).collect(Collectors.toList());

                while (!buyersInQueue.isEmpty() && !sellersInQueue.isEmpty()) {
                    Order buy = buyersInQueue.get(0);
                    Order sell = sellersInQueue.get(0);

                    if(buy.getQuantity() > sell.getQuantity()) {
                        Logger.info("Traded quantity: " + sell.getQuantity() + " at " + sell.getPrice());
                        buy.setQuantity(buy.getQuantity() - sell.getQuantity());
                        sellersInQueue.remove(0);
                    } else if(buy.getQuantity() < sell.getQuantity()) {
                        Logger.info("Traded quantity: " + buy.getQuantity() + " at " + buy.getPrice());
                        sell.setQuantity(sell.getQuantity() - buy.getQuantity());
                        buyersInQueue.remove(0);
                    } else {
                        Logger.info("Traded quantity: " + sell.getQuantity() + " at " + sell.getPrice());
                        buyersInQueue.remove(0);
                        sellersInQueue.remove(0);
                    }
                }

            });
        }
    }

}

class Order {
    private ORDER_TYPE orderType;
    private int price;

    private int quantity;

    public Order(ORDER_TYPE orderType, int price, int quantity) {
        this.orderType = orderType;
        this.price = price;
        this.quantity = quantity;
    }

    public ORDER_TYPE getOrderType() {
        return orderType;
    }

    public void setOrderType(ORDER_TYPE orderType) {
        this.orderType = orderType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Buyers extends BaseTrader {
    public Buyers(TreeMap<Integer, Queue<Order>> matcher) {
        super(matcher, ORDER_TYPE.BUY);
    }
}

class Sellers extends BaseTrader {
    public Sellers(TreeMap<Integer, Queue<Order>> matcher) {
        super(matcher, ORDER_TYPE.SELL);
    }
}

class BaseTrader extends Thread {

    private final int currentPrice = 1600;

    private final int lowerCircuit = 1400;
    private final int upperCircuit = 1800;

    protected TreeMap<Integer, Queue<Order>> matcher;

    final protected ORDER_TYPE orderType;

    protected BaseTrader(TreeMap<Integer, Queue<Order>> matcher, ORDER_TYPE orderType) {
        this.matcher = matcher;
        this.orderType = orderType;
    }

    protected int getRandomPrice() {
        return Random.getNumber(lowerCircuit, upperCircuit);
    }

    protected int getRandomQuantity() {
        return Random.getNumber(1, 100000);
    }

    protected void addToMatcher(Order order) {
        Logger.disable("Adding " + order.getOrderType().name() + " order with price " + order.getPrice() + " quantity " + order.getQuantity());
        Timer.delay(2000);
        Queue<Order> orderQueue = matcher.get(order.getPrice());
        if (orderQueue == null) {
            orderQueue = new LinkedList<>();
            orderQueue.add(order);
            matcher.put(order.getPrice(), orderQueue);
        } else {
            orderQueue.add(order);
        }
    }

    @Override
    public void run() {
        while (true) {
            Order order = new Order(orderType, getRandomPrice(), getRandomQuantity());
            addToMatcher(order);
        }
    }
}

class Random {
    public static int getNumber(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}

class Timer {
    public static void delay(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException ignored) {

        }
    }
}

class Logger {
    public static void info(String log) {
        System.out.println(log);
        System.out.println();
    }

    public static void disable(String a) {

    }
}

enum ORDER_TYPE {
    BUY, SELL;
}
