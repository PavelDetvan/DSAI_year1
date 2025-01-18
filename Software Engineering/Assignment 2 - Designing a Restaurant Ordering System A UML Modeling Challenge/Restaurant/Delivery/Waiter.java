package Restaurant.Delivery;

import Restaurant.Order.Order;
import java.util.List;

/**
 * Waiter class that represents a waiter at a restaurant
 */
public class Waiter {
    /**
     * name of the waiter
     */
    private String name;
    /**
     * ID of the waiter
     */
    private int id;
    /**
     * list of orders that the waiter is responsible for
     */
    private List<Order> waiterOrders;

    /**
     * Constructor, creates a Waiter object with the given name, id, and list of orders
     * @param name name of the waiter
     * @param id ID of the waiter
     * @param waiterOrders list of orders that the waiter is responsible for
     */
    public Waiter(String name, int id, List<Order> waiterOrders) {
        this.name = name;
        this.id = id;
        this.waiterOrders = waiterOrders;
    }

    /**
     * returns the name of the waiter
     * @return name of the waiter
     */ 
    public String getName() {
        return name;
    }

    /**
     * returns the id of the waiter
     * @return ID of the waiter
     */
    public int getId() {
        return id;
    }

    /**
     * returns a list of orders that the waiter is responsible for
     * @return list of orders that the waiter is responsible for
     */
    public List<Order> getWaiterOrders() {
        return waiterOrders;
    }
}
