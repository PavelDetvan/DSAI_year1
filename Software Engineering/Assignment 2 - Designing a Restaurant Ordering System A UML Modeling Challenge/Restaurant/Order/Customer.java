package Restaurant.Order;

/**
 * Customer class that represents a customer who places an order in the restaurant.
 * Stores information about the customer (name, delivery address, contact details and the order they placed)
 */
public class Customer {
    private static int customerNumber = 0;
    private String deliveryAddress;
    private String contact;
    private String name;
    private Order order;


    /**
     * constructor, creates a new instance of the Customer class with the given name, delivery address, contact details and order
     * @param name name of the customer
     * @param deliveryAdress delivery address of the customer
     * @param contact contact details of the customer
     * @param order order placed by the customer
     */
    public Customer(String name, String deliveryAdress, String contact, OrderRestaurant order) {
        customerNumber += 1;
        this.name = name;
        this.deliveryAddress = deliveryAdress;
        this.contact = contact;
        this.order = order;
    }

    /**
    * Returns the name of the customer
    * @return name of the customer
    */
    public String getName(){
        return this.name;
    }

    /**
     * returns the delivery address of the customer
     * @return delivery address of the customer
     */
    public String getDeliveryAdress(){
        return deliveryAddress;
    }

    /**
     * returns the customer number
     * @return customer number
     */
    public int getCustomerNum(){
        return customerNumber;
    }

    /**
     * returns the contact details of the customer
     * @return contact details of the customer
     */
    public String getContact(){
        return contact;
    }

    /**
     * returns the order placed by the customer
     * @return order placed by the customer
     */
    public Order getOrder(){
        return order;
    }

}
