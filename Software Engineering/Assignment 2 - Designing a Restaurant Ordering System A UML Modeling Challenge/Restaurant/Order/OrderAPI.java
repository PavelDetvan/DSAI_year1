package Restaurant.Order;

import java.util.List;

import Restaurant.Menu.MenuProduct;

/**
 * this class represents an implementation of the Order abstract class that is specifically designed for use in an API
 * The OrderAPI class is used to create and manipulate orders that are received via an API (UberEats etc)
 */
public class OrderAPI extends Order{

    /**
     * Constructor for creating a new OrderAPI object
     * @param orderedProducts list of MenuProduct objects representing the items that were ordered
     * @param orderStatus string representing the status of the order
     * @param additionalComment string containing any additional comments or special instructions regarding the order
     */
    public OrderAPI(List<MenuProduct> orderedProducts, String orderStatus, String additionalComment) {
        super(orderedProducts, orderStatus, additionalComment);
    }
}
