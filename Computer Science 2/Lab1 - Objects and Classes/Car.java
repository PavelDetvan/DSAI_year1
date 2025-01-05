public class Car {
    private double fuel;
    private double efficiency;
    private int motorNumber = 0;
    private static String refil = "";
    static int counter = 0;

    public static String fuelRefills(){
        return refil; 
    }
    
    public Car(double efficiency){
        fuel=0;
        this.efficiency=efficiency;
        counter +=1;
        motorNumber = counter;
    }
    
    public boolean canDrive(double distance){
        if(distance<=this.fuel/this.efficiency){
            return true;
        }
        else{
            return false;
        }
    }
    
    public void drive(double distance){
        this.fuel -= distance*this.efficiency;
    }
    
    public double getFuel(){
        return fuel;
    }
    
    public void addFuel(double fuel){
        this.fuel += fuel;
        String str = "Car Motor Number " + motorNumber + ": " + fuel + " liters" + "\n";
        refil = refil + str;
        
    }


    public static void main(String[] args) {
        Car car1 = new Car(0.1);
        Car car2 = new Car(0.1);
        Car car3 = new Car(5);
        car3.addFuel(100);
        car2.drive(5);
        System.out.println(car2.getFuel());
        car1.addFuel(10);
        car2.addFuel(60);
        System.out.println(car1.getFuel());
        car1.drive(5);
        System.out.println(car1.getFuel());
        System.out.println(car1.canDrive(50));
        car1.addFuel(1);
        System.out.println(fuelRefills());

        
    }
}
