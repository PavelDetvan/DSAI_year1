package Restaurant.Pricing;

import Restaurant.Menu.MenuProduct;
import Restaurant.Order.Order;
import Restaurant.Order.OrderRestaurant;

import java.util.List;

/**
 * class that implements the CalculateEntryPrice interface and provides a way to calculate the price of an order using a specified pricing strategy.
 * it pass on the actual calculation to the strategy object passed in its constructor
 */
public class PriceCalculator implements CalculateEntryPrice {
    private Order order;
    private CalculateEntryPrice strategy;

    public PriceCalculator(Order order, CalculateEntryPrice strategy) {
        this.order = order;
        this.strategy = strategy;
    }


    /**
    * Calculates the price of the order using the specified pricing strategy.
    * @return the price of the order
    */
    @Override
    public double calculatePrice() {
       return strategy.calculatePrice();
    }
}
