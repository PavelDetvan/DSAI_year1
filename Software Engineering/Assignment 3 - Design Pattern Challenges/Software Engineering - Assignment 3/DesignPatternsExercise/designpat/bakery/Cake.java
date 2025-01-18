package designpat.bakery;

/**
 * Cake bake class.
 * @author Pavel Detvan & Martin Popov
 */
public abstract class Cake{

    protected int CAKE_COST = 10;
    
    public abstract int getCost();

    public abstract String getDescription();
}
