//package bag;

import java.util.ArrayList;

public class ShoppingBag{
    private ArrayList<Item> basket;
    private double totalPrice = 0;
    


    public ShoppingBag(){
        basket = new ArrayList<>();
    }

    public void add(Item item){
        basket.add(item);
    }

    public double totalPriceForProduct(String name){
        totalPrice = 0;
        for(int i=0; i<basket.size(); i++){
            if(basket.get(i).getName().equals(name)){
                totalPrice += basket.get(i).getPrice();
            }
        }
        return totalPrice;
    }


    public static class Product implements Item{
        private String name;
        private double price;
        private String bio;
    
        public Product(){
        }
        
        public Product(String name, double price, String bio){
            this.name = name;
            this.price = price;
            this.bio = bio;
        }
    
        public String getName() {
            return this.name;
        }
    
        public double getPrice() {
            return this.price;
        }
    
    }

    public static void main(String[] args) {
        Product milk = new Product("milk", 1.25, "lactofree");
        Product milkbio = new Product("milk", 2.25, "lactofree bio");
        Product weed = new Product("Lemonhaze", 10, "good");
        Product shit = new Product();

        ShoppingBag pavels = new ShoppingBag();
        pavels.add(milk);
        pavels.add(milk);
        pavels.add(milk);
        pavels.add(milkbio);
        pavels.add(weed);
        
        System.out.println(pavels.totalPriceForProduct("Lemonhaze"));
        
    }
}