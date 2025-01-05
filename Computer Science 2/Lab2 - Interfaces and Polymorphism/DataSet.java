//package car;

public class DataSet {
    private double sum = 0;
    private int count = 0;
    private Measurer measurer;
    private Filter filter;

    public DataSet(Measurer measurer, Filter filter){
       this.measurer = measurer;
       this.filter = filter;
    }

   
    public void add(Object x){
        Car car = (Car)x;
        if(filter.accept(car)){
            sum += measurer.measure(car);
            count++;
        }
    }
   
    public double getAverage(){
        if (count == 0) return 0;
        else return sum / count;
    }

    static class CarFilter implements Filter{
        public boolean accept(Object x) {
            Car car = (Car)x;
            if(car.canDrive(100)){
                return true;
            }
            return false;
        }
    }

    static class CarMeasurer implements Measurer{
        public double measure(Object anObject) {
            Car car = (Car)anObject;
            double fuel = car.getFuel();
            return fuel;
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car(0.1);
        car1.addFuel(70);
        Car car2 = new Car(0.07);
        car2.addFuel(60);
        CarMeasurer carM = new CarMeasurer();
        CarFilter carF = new CarFilter();
        DataSet data1 = new DataSet(carM,carF);
        data1.add(car1);
        data1.add(car2);
        System.out.println(data1.getAverage());
        
    }
}
