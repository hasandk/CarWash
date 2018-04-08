public class Customer {
    int cpr;
    String name, lastName, tlf;
    
    public Customer(int cpr, String name, String lastName,String tlf){
        this.cpr =cpr;
        this.name= name;
        this.lastName= lastName;
        this.tlf = tlf;
    }
    
    public int getCpr(){
         return cpr;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getTlf(){
        return tlf;
    }
}
