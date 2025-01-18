package designpat.bakery;

/**
 * class representing saying on the cake
 * @author Pavel Detvan & Martin Popov
 */
public class Saying extends CakeDecorator{
    private String saying;
    
    public Saying(Cake cake, String string) {
        super(cake);
        saying = string;
    }
    
    @Override
    public String getDescription() {
        return super.cake.getDescription() + "with saying \"" + saying + "\" ";     
    }

    @Override
    public int getCost() {
       return super.cake.getCost();
    }
}
