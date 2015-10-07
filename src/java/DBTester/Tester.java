package DBTester;

import entities.Address;
import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import facade.PersonFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author sebastiannielsen
 */
public class Tester {
    
    public Tester(){
    }
    
    public static void main(String[] args) {
        test();
    }
    
    public static void test(){
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2_dev");
//        EntityManager em = emf.createEntityManager();
//        
//        Hobby hobby = new Hobby("Programming", "Software Development");
//        Phone phone = new Phone(51887460, "Mobil");
//        Address address = new Address("Lombardigade", "14 1 tv");
//        CityInfo cityinfo = new CityInfo(2300, "Kbh S");
//        address.setCity(cityinfo);
//        
//        Person person = new Person("Sebastian", "Nielsen");
//        person.addHobby(hobby);
//        person.setEmail("sebnielsen@hotmail.com");
//        person.addPhone(phone);
//        person.setAddress(address);
//        
//        Company company = new Company();
//        
//        em.getTransaction().begin();
//        em.persist(person);
//        em.getTransaction().commit();
//        
//        PersonFacade facade = new PersonFacade();
//        List<Person> personList = facade.getPersonsInCity(cityinfo);
//        System.out.println(personList.get(0).getHobbies().get(0).getDescription());
    }
}
