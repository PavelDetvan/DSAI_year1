//package car;

//import car.DataSet.CarFilter;
//import car.DataSet.CarMeasurer;

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

}
