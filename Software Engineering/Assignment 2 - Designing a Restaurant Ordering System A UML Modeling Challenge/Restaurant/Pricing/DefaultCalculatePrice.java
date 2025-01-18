package Restaurant.Pricing;

import Restaurant.Menu.MenuProduct;

/**
 * The DefaultCalculatePrice class implements the CalculateEntryPrice interface and provides the default calculation of a menu product's price
 */
public class DefaultCalculatePrice implements CalculateEntryPrice {
    private MenuProduct menuProduct;

    /**
     * constructor
     * @param menuProduct menu product to be used in the calculation
     */
    public DefaultCalculatePrice(MenuProduct menuProduct) {
        this.menuProduct = menuProduct;
    }

    /**
    * Calculates the price of the menu product.
    * @return the price of the menu product
    */
    @Override
    public double calculatePrice() {
        return menuProduct.getPrice();
    }

}
