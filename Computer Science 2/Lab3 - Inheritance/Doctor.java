public class Doctor extends Person{
    private String speciality;
    private double officeVisitFee;

    public Doctor(String name, int age, String speciality, double officeVisitFee){
        super(name, age);
        this.speciality = speciality;
        this.officeVisitFee = officeVisitFee;
    }

    public String getSpecialty(){
        return this.speciality;
    }

    public double getOfficeVisitFee(){
        return this.officeVisitFee;
    }

    public void setOfficeVisitFee(double officeVisitFee){
        this.officeVisitFee = officeVisitFee;
    }

    public void setSpecialty(String specialty){
        this.speciality = specialty;
    }

    @Override
    public boolean equals(Object other){
	    if (other == null){
            return false;
        }
	    if (getClass() != other.getClass()){
            return false;
        }
        Doctor otherDoc = (Doctor)other;
        return getAge()==otherDoc.getAge() && getName().equals(otherDoc.getName()) && speciality.equals(otherDoc.speciality) && officeVisitFee==otherDoc.getOfficeVisitFee();
        
    }

    @Override
    public String toString(){
        return (getName() +"   "+ getAge() + "  " + getSpecialty() + "  " + getOfficeVisitFee());
    }
}
