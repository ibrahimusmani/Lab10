/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softcons.lab10.view;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.*;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import static com.mysql.cj.core.MysqlType.NULL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeObject.keys;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.lightcouch.CouchDbClient;
import org.lightcouch.View;
import softcons.lab10.model.City;


/**
 *
 * @author ibrah   
 */
public class Lab10 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        Scanner scanf = new Scanner(System.in);
        // TODO code application logic here
        String csv = "GeoLiteCity-Location.csv";
        String line;
        int x=0;
        List<String> list = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(csv))) {

            
            while((line = br.readLine()) != null)
            {
                list.add(line);
            }

//            String[] stringArr = list.toArray(new String[0]);
            //System.out.println(list.get(0));

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
                CouchDbClient dbClient = new CouchDbClient("lab10", true, "http", "127.0.0.1", 5984, "Ibrahim", "admin");
                //Map<String, String> map = new HashMap<>();
                
                
                
//                SessionFactory factory=new Configuration().configure().buildSessionFactory();
//		//creating session object  
//		Session session=factory.openSession();  
			//creating transaction object  
			//Transaction t=session.beginTransaction();  
//			Employee e1=new Employee();  
//			e1.setId(116);  
//			e1.setFirst_name("Fahad");  
//			e1.setLast_name("Satti");  
//			session.persist(e1);//persisting the object  
                        int temp = 2;
                        int size = list.size();
                        City city; //= new City();
                        String[] data;
                        //data is entered once
//                        while(temp!=size){
//                            data = list.get(temp).split(",");
//                            System.out.println(data[0]);
//                            data[1] = data[1].substring(1, data[1].length()-1);
//                            data[2] = data[2].substring(1, data[2].length()-1);
//                            data[3] = data[3].substring(1, data[3].length()-1);
//                            data[4] = data[4].substring(1, data[4].length()-1);
//                            map.put("_id", data[0]);
//                            map.put("Country", data[1]);
//                            map.put("Region", data[2]);
//                            map.put("City", data[3]);
//                            //System.out.println(data[3]);
//                            //System.out.println(data[2]);
//                            if(!data[4].equals("\"\"")&& !data[4].equals("")){
//                                map.put("PostalCode", data[4]);
//                            }
//                            map.put("Latitude", data[5]);
//                            map.put("Longitude", data[6]);
//                            if(data.length>7 && !data[7].equals("\"\"") && !data[7].equals("")){
//                                map.put("MetroCode", data[7]);
//                            }
//                            if(data.length>8 && !data[8].equals("\"\"")&& !data[8].equals("")){
//                                 map.put("AreaCode", data[8]);
//                            }
//                            dbClient.save(map);
//                            temp++;
//                            
//                            
//                        }
//                        List<JsonObject> json = dbClient.view("_all_docs").query(JsonObject.class);
//                        for (int i=0;i<json.size();i++){
//                        System.out.println(json.get(i));}
                        
//                        HttpGet get = new HttpGet("http://localhost:5984/lab10/_design/testview/_view/test1?limit=20&reduce=false");
//                        HttpResponse response = httpclient.execute(get);
                        
                           //Query Wali Line Jahan User Input Deta Hai
                        Transaction t = null;// = session.beginTransaction();
                        //city = new City();
                        //double cityarr[]={0,0,0,0,0};
                        List<Double> cityarr = new ArrayList<Double>();
                        int it=0;
                        double userlat=0;
                        double userlng=0;
                        double userlat1=0;
                        double userlng1=0;
                        
                        double max=0;
                        int itey=0;
                        
//                        List<JsonObject> view = dbClient.view("city/cityview").key("Islamabad").query(JsonObject.class);
//                        String myjson=view.get(0).toString();
//                        String[] json;
//                        //JsonObject parser = (JsonObject) new JsonParser().parse(myjson);
////                        JsonObject obj=view.get(0);
////                        String pageName = obj.getJSONObject("pageInfo").getString("pageName");
//                        json=myjson.split(",");
//                        String latitude = json[2].split("\"")[5];
//                        String longitude = json[3].split("\"")[3];
//                        String country = json[4].split("\"")[3];
//                        System.out.println(myjson);
//                        System.out.println(latitude);
//                        System.out.println(longitude);
//                        System.out.println(country);
                        
                        List<JsonObject> view2;// = dbClient.view("city/latlong").key("33.6900","73.0551").query(JsonObject.class);
                        //System.out.println(view2);
                       // List<JsonObject> testet = dbClient.view("city/latlong").key(String.format("%.4f", 34.2528),String.format("%.4f", 73.425)).query(JsonObject.class);
                        //System.out.println("WEEEWOOOWEEEWOOOO");
                        //System.out.println(testet);
                        
                        
                        List<Double> mylat = new ArrayList<Double>();
                        List<Double> mylng = new ArrayList<Double>();
                        System.out.println("Enter City:");
                        String inputcity = scanf.nextLine();
                        System.out.println("Enter 2nd City:");
                        String inputcity1 = scanf.nextLine();
                        System.out.println("How many closest cities do you want?");
                        int num = scanf.nextInt();
                        
                        List<JsonObject> user = dbClient.view("city/cityview").key(inputcity).query(JsonObject.class);
                        String myuser=user.get(0).toString();
                        String[] User = myuser.split(",");
                        userlat =Double.parseDouble(User[2].split("\"")[5]);
                        userlng =Double.parseDouble(User[3].split("\"")[3]);
//                        System.out.println("lat"+userlat+"long"+userlng);
                         List<JsonObject> city2 = dbClient.view("city/cityview").key(inputcity1).query(JsonObject.class);
//                         System.out.println(city2);
                         String mycity2=city2.get(0).toString();
                         String[] City2 = mycity2.split(",");
                         userlat1=Double.parseDouble(City2[2].split("\"")[5]);
                         userlng1 = Double.parseDouble(City2[3].split("\"")[3]);
//                         System.out.println("lat"+userlat1+"long"+userlng1);
                        System.out.println("Distance between 2 cities: "+abs(distance(userlat,userlng,userlat1,userlng1))*10000/1.150 + " miles");
                        
                        
                        //List<JsonObject> test = dbClient.view("_all_docs").key("1").query(JsonObject.class);
                        JsonObject lol;// = dbClient.find(JsonObject.class, "1");
//                        JsonObject lulz = dbClient.find(JsonObject.class, "500");
//                        System.out.println(lulz);
                        //System.out.println(list.size());
                        int sizey = list.size()-2;
                        double templat,templng;
                        String tempcity;
                        String tempy;
                        String[] splittempy,temptemp;
                        for (int i=0;i<sizey;i++)
                        {
                            if (i<num)
                            {
                                lol = dbClient.find(JsonObject.class, Integer.toString(i+1));
                                tempy=lol.toString();
                                splittempy = tempy.split(",");
                                templat = Double.parseDouble(splittempy[splittempy.length-3].split("\"")[3]);
                                templng = Double.parseDouble(splittempy[splittempy.length-1].split("\"")[3]);
                                //tempcity = splittempy[5].split("\"")[3];
                                cityarr.add((double)distance(userlat,userlng,templat,templng));
                                mylat.add((double)templat);
                                mylng.add((double)templng);
                            }
                            else
                               {
                                   lol = dbClient.find(JsonObject.class, Integer.toString(i+1));
                                   tempy=lol.toString();
                                   splittempy = tempy.split(",");
                                   //System.out.println(tempy);
                                   templat = Double.parseDouble(splittempy[splittempy.length-3].split("\"")[3]);
                                   //System.out.println(templat);
                                   templng = Double.parseDouble(splittempy[splittempy.length-1].split("\"")[3]);
                                   temptemp = splittempy[splittempy.length-2].split("\"");
                                   if (temptemp.length<4)
                                       tempcity = "";
                                   else
                                    tempcity = splittempy[splittempy.length-2].split("\"")[3];
                                   //System.out.println("this is city " + tempcity);
                                   max =0;
                                   for (int j = 0; j < num; j++) {
                                        if (cityarr.get(j) > max) {
                                          max = cityarr.get(j);
                                          itey = j;                                         
                                        }
                                   }
                                   if (distance(userlat,userlng,templat,templng)<max && !tempcity.equals(inputcity)){
                                       cityarr.set(itey,(double)distance(userlat,userlng,templat,templng));
                                       mylat.set(itey,(double)templat);
                                       mylng.set(itey,(double)templng);
                                   }
                               }
                        }
                            
                            ArrayList output = new ArrayList();
                            for (int j=0;j<num;j++)
                            {
                               view2 = dbClient.view("city/latlong").key(String.format("%.4f", mylat.get(j)),String.format("%.4f", mylng.get(j))).query(JsonObject.class);
                               //System.out.println(view2);
                               String closest=view2.get(0).toString();
                               String[] CL = closest.split(",");
                               output.add(CL[3].split("\"")[5]+" " +CL[4].split("\"")[3]+" "+CL[5].split("\"")[3]+" "+CL[6].split("\"")[3]);
                               
                            }
                            
                            System.out.println("Closest cities are");
                            for (int j=0;j<num;j++)
                            {
                                System.out.println(output.get(j));
                            }
//                        try{
                            //t = session.beginTransaction();
                            //List cities = session.createQuery("FROM City").list(); 
//                            for (Iterator iterator = cities.iterator(); iterator.hasNext();){
//                               city = (City) iterator.next();
//                               
//                               if (inputcity.equals(city.getCity())){
//                                System.out.print("Location Id: " + city.getLocId()); 
//                                System.out.print("  Latitude: " + city.getLatitude()); 
//                                System.out.println("  Longitude: " + city.getLongitude());
//                                userlat = city.getLatitude();
//                                userlng = city.getLongitude();
//                               }
//                               
//                            }
//                             List cities1 = session.createQuery("FROM City").list(); 
//                            for (Iterator iterator = cities1.iterator(); iterator.hasNext();){
//                               city = (City) iterator.next();
//                               
//                               if (inputcity1.equals(city.getCity())){
//                                System.out.println("Distance between 2 cities: "+abs(distance(userlat,userlng,city.getLatitude(),city.getLongitude()))*10000/1.150 + " miles");
//                                
//                               }
//                               
//                            }
                        
//                            city = null;
//                            List citiess = session.createQuery("FROM City").list(); 
//                            for (Iterator iterator = citiess.iterator(); iterator.hasNext();){
//                               city = (City) iterator.next();
//                               //Debugging
////                               if (inputcity.equals(city.getCity())){
////                                System.out.print("Location Id: " + city.getLocId()); 
////                                System.out.print("  Latitude: " + city.getLatitude()); 
////                                System.out.println("  Longitude: " + city.getLongitude());
////                               }
//                               if (it<num)
//                               {
//                                   //Debugging
//                                   //System.out.println("Inside 2nd for loop");
//                                   cityarr.add((double)distance(userlat,userlng,city.getLatitude(),city.getLongitude()));
//                                   mylat.add((double)city.getLatitude());
//                                   mylng.add((double)city.getLongitude());
////                                   if (cityarr[it]>max)
////                                       max=cityarr[it];
//                               }
//                               else
//                               {
//                                   max =0;
//                                   for (int i = 0; i < num; i++) {
//                                        if (cityarr.get(i) > max) {
//                                          max = cityarr.get(i);
//                                          itey = i;
//                                          //Debugging
//                                          //System.out.println("Itey: "+itey);
//                                        }
//                                   }
//                                   if (distance(userlat,userlng,city.getLatitude(),city.getLongitude())<max && !city.getCity().equals(inputcity)){
//                                       cityarr.set(itey,(double)distance(userlat,userlng,city.getLatitude(),city.getLongitude()));
//                                       //Debugging
//                                       //System.out.println("Itey: "+itey);
//                                       mylat.set(itey,(double)city.getLatitude());
//                                       mylng.set(itey,(double)city.getLongitude());
//                                       //Debugging
////                                       System.out.println("MAX: "+max);
////                                       System.out.println("Distance: "+cityarr[itey]);
////                                       System.out.println("yeh lat and long hain: "+mylat[itey]+" "+mylng[itey]);
//                                   }
//                               }
//                               it++;
//                            
//                        }
//                            city = null;
//                            //Debugging
////                            System.out.println("\nTest for lat and long");
////                            System.out.println("Lat: "+mylat[0]+" Long: "+mylng[0]);
////                            System.out.println("Lat: "+mylat[1]+" Long: "+mylng[1]);
////                            System.out.println("Lat: "+mylat[2]+" Long: "+mylng[2]);
////                            System.out.println("Lat: "+mylat[3]+" Long: "+mylng[3]);
////                            System.out.println("Lat: "+mylat[4]+" Long: "+mylng[4]);
//                            int i;
//                            System.out.println("Closest cities are");
//                            List citiesss = session.createQuery("FROM City").list(); 
//                            for (Iterator iterator = citiesss.iterator();iterator.hasNext();){
//                               city = (City) iterator.next();
//                               for(i=0;i<num;i++){
//                               if (mylat.get(i)==city.getLatitude() && mylng.get(i)==city.getLongitude())
//                               {
//                                   System.out.println(city.getCountry()+" " +city.getCity()+" "+city.getLatitude()+" "+city.getLongitude());
//                               }}
//                               
////                               else if (mylat[1]==city.getLatitude() && mylng[1]==city.getLongitude())
////                               {
////                                   System.out.println(city.getCountry()+" " +city.getCity()+" "+city.getLatitude()+" "+city.getLongitude());
////                               }
////                               else if (mylat[2]==city.getLatitude() && mylng[2]==city.getLongitude())
////                               {
////                                   System.out.println(city.getCountry()+" " +city.getCity()+" "+city.getLatitude()+" "+city.getLongitude());
////                               }
////                               else if (mylat[3]==city.getLatitude() && mylng[3]==city.getLongitude())
////                               {
////                                   System.out.println(city.getCountry()+" " +city.getCity()+" "+city.getLatitude()+" "+city.getLongitude());
////                               }
////                               else if (mylat[4]==city.getLatitude() && mylng[4]==city.getLongitude())
////                               {
////                                   System.out.println(city.getCountry()+" " +city.getCity()+" "+city.getLatitude()+" "+city.getLongitude());
////                               }
//                               
//                               
//                            }
//                        }
//                        catch (HibernateException e) {
//                                if (t!=null) t.rollback();
//                                e.printStackTrace(); 
//                             }
//			t.commit();//transaction is commited  
//		session.close(); 
        
        //System.out.println(distance());
        
                        }
    
    public static double distance(double lat1, double lng1, double lat2, double lng2)
    {
        double pk = (double) (180/Math.PI);
        double B1 = lat1 / pk;
        double B2 = lat2 / pk;
        double dL = (lng1-lng2) / pk;

        double t1 = (double) (Math.cos(B1)*Math.cos(B2)*Math.cos(dL));
        double t2 = (double) (Math.sin(B1)*Math.sin(B2));

        double tt = (double) Math.acos(t1 + t2);
        return tt;
    }
}
