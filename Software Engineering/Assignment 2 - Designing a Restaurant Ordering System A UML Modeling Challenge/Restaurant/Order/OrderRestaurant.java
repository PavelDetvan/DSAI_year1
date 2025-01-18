package Restaurant.Order;

import Restaurant.Menu.MenuProduct;

import java.util.Date;
import java.util.List;

/**
 * class representing an order made in a restaurant, extends abstract class Order
 */
public class OrderRestaurant extends Order {

    /**
     * constructor for OrderRestaurant 
     * @param orderedProducts List of MenuProduct objects representing the ordered products
     * @param orderStatus String representing the status of the order
     * @param additionalComment String representing any additional comment added to the order
     */
    public OrderRestaurant(List<MenuProduct> orderedProducts, String orderStatus, String additionalComment) {
        super(orderedProducts, orderStatus, additionalComment);
        //TODO Auto-generated constructor stub
    }
}
