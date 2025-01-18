package Restaurant.Menu;

import Restaurant.Pricing.CalculateEntryPrice;

import java.util.List;

/**
 * class represents a menu product that can be offered by the restaurant. contains the name, description, price, and list of ingredients of the product
 */
public class MenuProduct implements CalculateEntryPrice {
    private String name;
    private String description;
    private double price;
    private List<Ingredient> ingredients;

    /**
     * constructor, creates a new menu product with the given name, description, and ingredients
     * @param name name of the product
     * @param description description of the product
     * @param ingredients list of ingredients used in the product
     */
    public MenuProduct(String name, String description, List<Ingredient> ingredients) {
        this.name = name;
        this.description = description;
        this.price = calculatePrice();
        this.ingredients = ingredients;
    }

    /**
     * Sets the name of the menu product
     * @param name name to be set for the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the description of the menu product
     * @param description description to be set for the product
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Sets the price of the menu product
     * @param price price to be set for the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the list of ingredients used in the menu product
     * @param ingredients list of ingredients to be set for the product
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Returns the name of the menu product
     * @return name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the description of the menu product
     * @return description of the product
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the price of the menu product
     * @return price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * returns the list of ingredients used in the menu product
     * @return list of ingredients used in the product
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
    * Calculates the price of the menu product based on the total price of its ingredients.
    * @return calculated price of the product
    */
    @Override
    public double calculatePrice() {
        double sum = 0;

        for (Ingredient ingredient : ingredients) {
            sum += ingredient.getPrice();
        }
        return sum;
    }
}

