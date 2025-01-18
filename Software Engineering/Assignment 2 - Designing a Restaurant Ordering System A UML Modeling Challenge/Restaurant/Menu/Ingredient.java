package Restaurant.Menu;

/**
 * an ingredient that can be used in a menu item
 */
public class Ingredient {
    private String name;
    private double price;

    /**
     * constructor, creates a new ingredient with the given name and price
     * @param name name of the ingredient
     * @param price price of the ingredient
     */
    public Ingredient(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * returns the name of the ingredient
     * @return name of the ingredient
     */
    public String getName() {
        return name;
    }

    /**
     * returns the price of the ingredient
     * @return price of the ingredient
     */
    public double getPrice() {
        return price;
    }
}
