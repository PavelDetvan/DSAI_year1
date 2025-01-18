package Restaurant.Order;

import Restaurant.Menu.MenuProduct;

import java.util.Date;
import java.util.List;

/**
 * class Representing an Order placed through a Web interface, extends the abstract class Order
 */
public class OrderWeb extends Order{

    /**
     * constructor for OrderWeb
     * @param orderedProducts List of MenuProduct objects representing the products ordered
     * @param orderStatus String representing the status of the order
     * @param additionalComment String with any additional comments about the order
     */
    public OrderWeb(List<MenuProduct> orderedProducts, String orderStatus, String additionalComment) {
        super(orderedProducts, orderStatus, additionalComment);
    }
}
