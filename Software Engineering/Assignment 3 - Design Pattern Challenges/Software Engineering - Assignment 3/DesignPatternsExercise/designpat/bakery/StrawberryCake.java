package designpat.bakery;

/**
 * class representing a strawberry cake
 * @author Pavel Detvan & Martin Popov
 */
public class StrawberryCake extends Cake{

    @Override
    public int getCost(){
        return 2*CAKE_COST;
    }

    @Override
    public String getDescription() {
        return "Strawberry cake ";
    }
    
}
