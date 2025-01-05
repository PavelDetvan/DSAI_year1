public class Patient extends Person{
    private String identificationNumber;

    Patient(String name, int age, String identificationNumber){
        super(name,age);
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationNumber(){
        return this.identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber){
        this.identificationNumber = identificationNumber;
    }

    @Override
    public boolean equals(Object other){
	    if (other == null){
            return false;
        }
	    if (getClass() != other.getClass()){
            return false;
        }
        Patient otherPatient = (Patient)other;
        return getAge()==otherPatient.getAge() && getName().equals(otherPatient.getName()) && getIdentificationNumber().equals(otherPatient.getIdentificationNumber());
        
    }

    @Override
    public String toString(){
        return (getName() +"   "+ getAge() + " " + getIdentificationNumber());
    }
}
