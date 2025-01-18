package Restaurant.Delivery;

import Restaurant.Order.Order;
import java.util.List;
/**
 * Delivery class represents the delivery system of the restaurant
 * manages the orders assigned to waiters
 */
public class Delivery {
    /**
    * ID of the waiter handling the delivery
    */
    private String waiterId;
    /**
    * list of all available employees
    */
    static private List<Waiter> employees;

    /**
     * constructor, creates a new Delivery object with the specified waiter ID and list of employees
     * @param waiterId ID of the waiter handling the delivery
     * @param employees list of all available employees
     */
    public Delivery(String waiterId, List<Waiter> employees) {
        this.waiterId = waiterId;
        Delivery.employees = employees;
    }

    /**
     * Returns the ID of the waiter handling the delivery
     * @return the ID of the waiter handling the delivery
     */
    public String getWaiterId() {
        return waiterId;
    }

    /**
     * Returns the list of all employees assigned to deliveries
     * @return the list of all employees assigned to deliveries
     */
    public List<Waiter> getEmployees() {
        return employees;
    }

    /**
    * Sets the ID of the waiter handling the delivery.
    * @param waiterId   the ID of the waiter handling the delivery
    */
    public void setWaiterId(String waiterId) {
        this.waiterId = waiterId;
    }


    /**
     * Assigns an order to a waiter with the least number of orders
     * @param order the order to be assigned
     */
    public void addDelivery(Order order) {
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getWaiterOrders().size() < employees.get(index).getWaiterOrders().size()) {
                index = i;
            }
        }
        employees.get(index).getWaiterOrders().add(order);
    }
}
