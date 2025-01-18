package Restaurant.Order;

import Restaurant.Menu.MenuProduct;
import Restaurant.Pricing.CalculateEntryPrice;

import java.util.Date;
import java.util.List;

/**
 * The abstract Order class represents an order made by a customer in a restaurant.
 * This class implements the CalculateEntryPrice interface, which requires it to have a method
 * 0calculatePrice() to calculate the total price of the order based on the prices of the ordered products.
 */
public abstract class Order implements CalculateEntryPrice{
    /**
     * The static variable orderNumber is used to keep track of the number of orders made in the system, unique
     */
     private static int orderNumber = 1;
     
     /**
      * The list of ordered products, the time the order was made, the total price, and delivery and payment statuses are all attributes of the order
      */
    private List<MenuProduct> orderedProducts;
    private Date orderTime;
    private double totalPrice;
    private boolean delivered = false;
    private boolean paidFor = false;
    private String orderStatus;
    private String additionalComment;

    /**
     * Setter method for the list of ordered products
     * @param orderedProducts list of ordered products
     */
    public void setOrderedProducts(List<MenuProduct> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    /**
     * Setter method for the delivery status of the order
     * @param delivered delivery status of the order
     */
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    /**
     * Setter method for the payment status of the order
     * @param paidFor payment status of the order
     */
    public void setPaidFor(boolean paidFor) {
        this.paidFor = paidFor;
    }

    /**
     * Getter method for the delivery status of the order
     * @return delivery status of the order
     */
    public boolean isDelivered() {
        return delivered;
    }

    /**
     * Getter method for the payment status of the order
     * @return payment status of the order
     */
    public boolean isPaidFor() {
        return paidFor;
    }

    /**
     * Getter method for the time the order was made
     * @return time the order was made
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * Getter method for the order number
     * @return order number
     */
    public static int getOrderNumber() {
        return orderNumber;
    }

    /**
     * Getter method for the list of ordered products
     * @return list of ordered products
     */
    public List<MenuProduct> getOrderedProducts() {
        return orderedProducts;
    }

    /**
     * Getter method for the total price of the order
     * @return total price of the order
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Getter method for the order status
     * @return order status
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Getter method for any additional comments associated with the order
     * @return additional comments associated with the order
     */
    public String getAdditionalComment() {
        return additionalComment;
    }

    /**
     * Calculates the total price of the ordered products by summing up the prices of each product
     * @return the total price of the ordered products
     */
    public double calculatePrice() {
     double sum = 0;
     for (MenuProduct orderedProduct : orderedProducts) {
         sum += orderedProduct.getPrice();
     }
     return sum;
 }

 /**
  * constructor, constructs an Order object with the given list of ordered products, order status, and additional comment. The order time is set to the current time, and the order number is incremented by 1 for each new order.
  * @param orderedProducts list of ordered products
  * @param orderStatus status of the order
  * @param additionalComment additional comment for the order
  */
    public Order(List<MenuProduct> orderedProducts, String orderStatus, String additionalComment) {
        this.orderedProducts = orderedProducts;
        this.totalPrice = calculatePrice();
        this.orderStatus = orderStatus;
        this.additionalComment = additionalComment;
        Order.orderNumber++;
        this.orderTime = new Date();
    }
}
