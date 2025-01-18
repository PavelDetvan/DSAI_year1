package designpat.bakery;

/**
 * class representing a vanilla cake
 * @author Pavel Detvan & Martin Popov
 */
public class VanillaCake extends Cake {
    @Override
    public String getDescription() {
        return "Vanilla cake ";
    }

    @Override
    public int getCost() {
        return CAKE_COST;
    }
}
