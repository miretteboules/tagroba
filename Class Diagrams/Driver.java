package busstation;


import java.util.ArrayList;


public class Driver extends Person {

        protected ArrayList<String> trips = new ArrayList();
    
    public Driver(String userName, String passWord, String name, String age, String trips)
    {
        super(userName, passWord, name, age);
        String[] parts1 = trips.split("-");
        int n = parts1.length;
        int i;
        for (i = 0; i < n; i++) {
            this.trips.add(parts1[i]);
        }
    }}