package designpat.bakery;

/**
 * class representing a chocolate cake
 * @author Pavel Detvan & Martin Popov
 */
public class ChocolateCake extends Cake {
    @Override
    public String getDescription() {
        return "Chocolate cake ";
    }

    @Override
    public int getCost() {
        return CAKE_COST;
    }
}
