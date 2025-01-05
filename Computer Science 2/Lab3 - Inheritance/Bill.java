public class Bill {
    private double amount;
    private Patient patient;
    private Doctor doc;

    public Bill(Patient patient, Doctor doctor){
        this.patient = patient;
        doc = doctor;
        amount = doc.getOfficeVisitFee();
    }

    public double getAmountDue(){
        return amount;
    }

    @Override
    public String toString(){
        return (doc.getName()+" "+ this.patient.getName() +" "+this.amount);
    }
}
