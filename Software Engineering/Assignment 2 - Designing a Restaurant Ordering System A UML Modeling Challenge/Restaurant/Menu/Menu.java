package Restaurant.Menu;

import java.util.List;

/**
 * class representing a menu in the restaurant
 */
public class Menu {
    private List<MenuProduct> products;

    /**
     * constructor
     * @param products list of menu products to add to the menu
     */
    public Menu(List<MenuProduct> products) {
        this.products = products;
    }

    /**
     * returns the list of products in the menu
     * @return list of menu products
     */
    public List<MenuProduct> getProducts() {
        return products;
    }

    /**
     * adds a new product to the menu
     * @param menuProduct menu product to add
     */
    public void addProduct(MenuProduct menuProduct) {
        products.add(menuProduct);
    }

    /**
     * removes a product from the menu
     * @param menuProduct menu product to remove
     */
    public void removeProduct(MenuProduct menuProduct) {
        products.remove(menuProduct);
    }
}
