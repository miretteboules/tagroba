package busstation;


import java.util.ArrayList;


public class Customer extends Person {

    protected String email;
    protected long visaNumber;
    protected ArrayList<String> trips = new ArrayList();

    public Customer(String userName, String passWord, String name, String age, String email, String visaNumber, String trips) {
        super(userName, passWord, name, age);
        this.visaNumber = Long.parseLong(visaNumber);
        this.email = email;
        String[] parts = trips.split("-");
        int n = parts.length;
        int i;
        for (i = 0; i < n; i++) {
        this.trips.add(parts[i]);
        }
    }

  
}
