import java.util.ArrayList;

public class BillContainer {
    private double sum;
    private ArrayList<Bill> allBills;


    public BillContainer(){
        allBills = new ArrayList<>();
    }
    public void addBill(Bill bill){
        sum += bill.getAmountDue();
        allBills.add(bill);
    }

    public double totalFee(){
        return sum;
    }

    @Override
    public String toString(){
        String string = "";
        for(int i = 0; i<allBills.size(); i++){
            string = string + allBills.get(i).toString() + ";  ";
        }
        return string;
    }

    public static void main(String[] args) {
        Doctor doc1 = new Doctor("Pavel", 25, "drugs", 100);
        Doctor doc2 = new Doctor("yuri", 19, "pasta", 15);

        Patient pat1 = new Patient("Ula", 19, "PL6969");
        Patient pat2 = new Patient("Sila", 19, "TU420");
        
        Bill bill1 = new Bill(pat1, doc2);
        Bill bill2 = new Bill(pat2, doc2);
        Bill bill3 = new Bill(pat2, doc1);
        Bill bill4 = new Bill(pat1, doc2);

        BillContainer BilCon = new BillContainer();
        BilCon.addBill(bill1);
        BilCon.addBill(bill2);
        BilCon.addBill(bill3);
        BilCon.addBill(bill4);
        
        System.out.println(BilCon.toString());
        System.out.println(BilCon.totalFee());


    }

}
