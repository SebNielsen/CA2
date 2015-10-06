/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Company;
import entities.Person;
import java.util.List;

/**
 *
 * @author sebastiannielsen
 */
public class JSONConverter {
   
   private static Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
   
   public JSONConverter(){
        
   }
    
   public static Person getPersonFromJson(String js){
       Person person = gson.fromJson(js, Person.class);
       return person;
   }
   
   public static String getJSONFromPerson(Person p) {
       return gson.toJson(p);
   }
   
   public static String getJSONFromPerson(List<Person> persons) {
       return gson.toJson(persons);
   }
   
   public static Company getCompanyFromJson(String js){
       Company company = gson.fromJson(js, Company.class);
       return company;
   }
   
   public static String getJSONFromCompany(Company c) {
       return gson.toJson(c);
   }
   
   public static String getJSONFromCompany(List<Company> companies) {
       return gson.toJson(companies);
   } 
    
}
