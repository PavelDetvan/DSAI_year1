public abstract class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    @Override
    public boolean equals(Object other){
	    if (other == null){
            return false;
        }
	    if (getClass() != other.getClass()){
            return false;
        }
        Person otherPerson = (Person)other;
        return age==otherPerson.getAge() && name.equals(otherPerson.getName());
        
    }

    @Override
    public String toString(){
        return (getName() +"   "+ getAge());
    }


}