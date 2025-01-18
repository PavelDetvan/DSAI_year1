package designpat.bakery;

/**
 * class representing sprinkles
 * @author Pavel Detvan & Martin Popov
 */
public class Sprinkles extends CakeDecorator{
    public Sprinkles(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return super.cake.getDescription() + "with sprinkles ";
    }

    @Override
    public int getCost() {
       return super.cake.getCost() + 2;
    }
    
}
