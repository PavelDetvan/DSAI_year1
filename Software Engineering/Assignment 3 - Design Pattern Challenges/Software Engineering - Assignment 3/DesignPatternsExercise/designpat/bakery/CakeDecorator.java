package designpat.bakery;

/**
 * Base decorator for cakes.
 * @author Pavel Detvan & Martin Popov
 */
public abstract class CakeDecorator extends Cake {
    protected Cake cake;

    public CakeDecorator(Cake cake) {
        this.cake = cake;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract int getCost();
}
