package busstation;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar_
 */
public class readFiles implements helperinterface {
    public ArrayList<manger> manger = new ArrayList<manger>();
     public ArrayList<Driver> driver = new ArrayList<Driver>();
      public ArrayList<Customer> cutomer = new ArrayList<Customer>();
    @SuppressWarnings("Convert2Diamond")
    public ArrayList<trips> trip = new ArrayList<trips>();

    /**
     *
     */
    @Override
    public void readFile() {
        FileReader frTrip = null;
        try {
            String line = null;
            String lineTrip;
            frTrip = new FileReader("trips.txt");
            try (BufferedReader brTrip = new BufferedReader(frTrip)) {
                lineTrip = brTrip.readLine();
                int k = 0;
                while (lineTrip != null) {
                    String[] partsTrip = lineTrip.split(",");
                    if (null != partsTrip[0]) {
                        trips x = new trips(partsTrip[0], partsTrip[1], partsTrip[2], partsTrip[3], partsTrip[4], partsTrip[5], partsTrip[6], partsTrip[7], partsTrip[8], partsTrip[9],partsTrip[10]);
                        trip.add(k, x);
                        k++;
                    }
                    lineTrip = brTrip.readLine();
                }
            }catch(Exception e)
            {}
            FileReader fr = new FileReader("people.txt");
            BufferedReader br = new BufferedReader(fr);
            try {
                line = br.readLine();
            } catch (IOException ex) {
                Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
            int d=0,m=0,c=0;
            while (line != null) {
                
                String[] parts = line.split(",");
                if (null != parts[0]) {
                    switch (parts[0]) {
                        case "Driver": {
                            Driver x = new Driver(parts[1], parts[2], parts[3], parts[4], parts[5]);
                            driver.add(d, x);
                            d++;
                            break;
                        }
                        case "Manager": {
                            manger x = new manger(parts[1], parts[2], parts[3], parts[4]);
                            manger.add(m, x);
                            m++;
                            break;
                        }
                        case "Customer": {
                            Customer x = new Customer(parts[1], parts[2], parts[3], parts[4], parts[5], parts[6], parts[7]);
                            cutomer.add(c, x);
                            c++;
                            break;
                        }
                        default:
                            break;
                    }

            }

line = br.readLine();
        }
            br.close();
        }catch(FileNotFoundException ex)
        {   Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
}       catch (IOException ex) {
            Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                frTrip.close();
            } catch (IOException ex) {
                Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    /**
     *
     */
    @Override
  public void savePeopleFile()
  {
      FileWriter wf=null;
        try {
            wf = new FileWriter("People.txt");
            PrintWriter pw=new PrintWriter(wf);
            int i,n;
            for(i=0;i<cutomer.size();i++)
            {
                pw.print("Customer,"+cutomer.get(i).userName+","+cutomer.get(i).passWord+","+cutomer.get(i).name+","+cutomer.get(i).age+","+cutomer.get(i).email+","+cutomer.get(i).visaNumber);
                String x=new String();
                int m=cutomer.get(i).trips.size();
                for(n=0;n<m;n++)
                {
                    x=x+cutomer.get(i).trips.get(n)+"-";
                }
                pw.println(","+x);
            }     for(i=0;i<manger.size();i++)
            {
                pw.println("Manager,"+manger.get(i).userName+","+manger.get(i).passWord+","+manger.get(i).name+","+manger.get(i).age);
                
            }     int k;
            for(i=0;i<driver.size();i++)
            {
                pw.print("Driver,"+driver.get(i).userName+","+driver.get(i).passWord+","+driver.get(i).name+","+driver.get(i).age);
                String y=new String();
                for(k=0;k<driver.get(i).trips.size();k++)
                {
                    y=y+driver.get(i).trips.get(k)+"-";
          }
          pw.println(","+y);
      }     pw.close();
        } catch (IOException ex) {
            Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                wf.close();
            } catch (IOException ex) {
                Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  }

    /**
     *
     */
    @Override
  public void saveTripsFile() 
  {
      FileWriter wf=null;
        try {
            wf = new FileWriter("trips.txt");
            PrintWriter pw=new PrintWriter(wf);
            int i;
            int m=trip.size();
            for(i=0;i<m;i++)
            {
                pw.println(trip.get(i).tripCode+","+trip.get(i).depart+","+trip.get(i).destination+","+trip.get(i).date+
                        ","+trip.get(i).vehicle+","+trip.get(i).time+","+trip.get(i).way+","+trip.get(i).stops+","
                        +trip.get(i).seats+","+trip.get(i).availableSeats+","+trip.get(i).price);
            }   pw.close();
        } catch (IOException ex) {
            Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                wf.close();
            } catch (IOException ex) {
                Logger.getLogger(readFiles.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
  }
    @Override
  public String[] stringCitiesDep() {

        ArrayList<String> list = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        int i;
        for ( i = 0; i < trip.size(); i++) {
            list.add(trip.get(i).depart);
        }
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        String[] s = new String[list.size()];
        list.toArray(s);
        return s;
    }
    @Override
 public String[] stringCitiesDest() {

        ArrayList<String> list = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        int i;
        for (i = 0; i < trip.size(); i++) {
            list.add(trip.get(i).destination);
        }
        hs.addAll(list);
        list.clear();
        list.addAll(hs);
        String[] s = new String[list.size()];
        list.toArray(s);
        return s;
    }
 
  /*public void saveManagerFile() throws IOException
  {
      FileWriter wf=new FileWriter("Manager.txt");
      PrintWriter pw=new PrintWriter(wf);
      int i,n;
      for(i=0;i<manger.size();i++)
      {
          pw.println("Manager"+manger.get(i).userName+","+manger.get(i).passWord+","+manger.get(i).name+","+manger.get(i).age);
       
      }
      pw.close();
  }
  public void saveDriverFile() throws IOException
  {
      FileWriter fw=new FileWriter("Driver.txt");
      PrintWriter pw=new PrintWriter(fw);
      int i,n;
      for(i=0;i<driver.size();i++)
      {
          pw.print("Driver"+driver.get(i).userName+","+driver.get(i).passWord+","+driver.get(i).name+","+driver.get(i).age);
          String trip=new String();
          for(n=0;n<driver.get(i).trips.length;i++)
          {
              trip=trip+cutomer.get(i).trips[n]+"-";
          }
          pw.println(","+trip);
      }
      pw.close();
  }*/

    /*void readTripFile() throws FileNotFoundException, IOException
  {
      String lineTrip;
        
        FileReader frTrip= new FileReader("trips.txt");
        BufferedReader brTrip=new BufferedReader (frTrip);
        lineTrip = brTrip.readLine();
        int k=0;
         while(lineTrip!=null)
          {
              String []partsTrip=lineTrip.split(",");
              if (null != partsTrip[0])
              {
                  trips x= new trips(partsTrip[0],partsTrip[1],partsTrip[2],partsTrip[3],partsTrip[4],partsTrip[5],partsTrip[6],partsTrip[7],partsTrip[8],partsTrip[9]);
                  trip.add(k,x);
                  k++;
              }
              lineTrip = brTrip.readLine();
  }
         brTrip.close();
        
    
}*/
}
