package Restaurant.Order;

import Restaurant.Menu.MenuProduct;

import java.util.Date;
import java.util.List;

/**
 * OrderQR is a subclass of the abstract class Order, representing an order placed via QR code
 */
public class OrderQR extends Order{

    /**
     * constructor for OrderQR
     * @param orderedProducts List of MenuProduct objects representing the products ordered in this order
     * @param orderStatus String representing the status of this order
     * @param additionalComment String representing any additional comment made for this order
     */
    public OrderQR(List<MenuProduct> orderedProducts, String orderStatus, String additionalComment) {
        super(orderedProducts, orderStatus, additionalComment);
        //TODO Auto-generated constructor stub
    }
    
}
