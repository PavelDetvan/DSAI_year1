package designpat.bakery;

/**
 * Create an order and print it
 */
public class Main {
    public static void main(String[] args) {
        Order order = new Order();
        order.addCake(new VanillaCake());
        order.addCake(new ChocolateCake());
        
        //decorated vanilla cake order
        Cake decoratedVanillaCake = new VanillaCake();
        decoratedVanillaCake = new Saying(decoratedVanillaCake, "PLAIN!");
        order.addCake(decoratedVanillaCake);

        //vanilla cake with sprinkles order
        Cake decoratedVanillaCakeWithSprinkles = new VanillaCake();
        decoratedVanillaCakeWithSprinkles = new Sprinkles(decoratedVanillaCakeWithSprinkles);
        decoratedVanillaCakeWithSprinkles = new Saying(decoratedVanillaCakeWithSprinkles, "FANCY!");
        order.addCake(decoratedVanillaCakeWithSprinkles);

        //multi-layered strawberry cake with double sprinkles and two sayings order
        Cake decoratedStrawberryCake = new MultiLayered(new StrawberryCake());
        decoratedStrawberryCake = new Sprinkles(decoratedStrawberryCake);
        decoratedStrawberryCake = new Sprinkles(decoratedStrawberryCake);
        decoratedStrawberryCake = new Saying(decoratedStrawberryCake, "One of");
        decoratedStrawberryCake = new Saying(decoratedStrawberryCake, "EVERYTHING");
        order.addCake(decoratedStrawberryCake);

        //strawberry cake order
        // Cake strawberryCake = new StrawberryCake();
        // order.addCake(strawberryCake);

        order.printOrder();
    }
}
