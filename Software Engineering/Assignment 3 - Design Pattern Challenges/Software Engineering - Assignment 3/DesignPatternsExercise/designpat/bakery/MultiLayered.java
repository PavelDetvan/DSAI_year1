package designpat.bakery;

/**
 * multy-layered cake class
 * @author Pavel Detvan & Martin Popov
 */
public class MultiLayered extends CakeDecorator{
    private Cake cake;

    public MultiLayered(Cake cake) {
        super(cake);
    }

    @Override
    public String getDescription() {
        return "Multi-Layered " + super.cake.getDescription();
    }

    @Override
    public int getCost() {
       return super.cake.getCost() + 5;
    }
}
