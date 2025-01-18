package Restaurant.Pricing;

import Restaurant.Menu.MenuProduct;

/**
 * CustomCalculatePrice class implements the CalculateEntryPrice interface and calculates the price of a menu item with a custom discount or markup percentage based on given values
 */
public class CustomCalculatePrice implements CalculateEntryPrice{

    private int discountPercentage;
    private int markupPercentage;
    private MenuProduct menuProduct;
    private boolean discount;
    private boolean rise;

    /**
     * constructor
     * @param discountPercentage percentage value of the discount
     * @param markupPercentage percentage value of the markup
     * @param menuProduct menu item whose price is being modified
     * @param discount whether a discount is applied or not
     * @param rise whether a markup is applied or not
     */
    public CustomCalculatePrice(int discountPercentage, int markupPercentage, MenuProduct menuProduct, boolean discount, boolean rise) {
        this.discountPercentage = discountPercentage;
        this.markupPercentage = markupPercentage;
        this.menuProduct = menuProduct;
        this.discount = discount;
        this.rise = rise;
    }

    /**
    * Calculates the price of the menu item based on the given discount and markup percentages.
    * If discount is true, the price is decreased by the discount percentage.
    * If rise is true, the price is increased by the markup percentage.
    * The modified price is returned.
    * @return the modified price of the menu item
    */
    @Override
    public double calculatePrice() {
        double i = menuProduct.getPrice();
        if (discount) {
            i -= menuProduct.getPrice() * discountPercentage/100;
            menuProduct.setPrice(i);
        }
        if (rise) {
           i +=  menuProduct.getPrice() * markupPercentage/100;
            menuProduct.setPrice(i);
        }
        return i;
    }


}
