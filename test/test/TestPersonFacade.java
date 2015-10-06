package test;

import entities.Address;
import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import facade.PersonFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jonas
 */
public class TestPersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
    EntityManager em = emf.createEntityManager();

    PersonFacade pf = new PersonFacade();

    public TestPersonFacade() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void createPersonTest() {
        Hobby hobby = new Hobby("Programming", "Software Development");
        Phone phone = new Phone(51887460, "Mobil");
        Address address = new Address("Lombardigade", "14 1 tv");
        CityInfo cityinfo = new CityInfo(2300, "Kbh S");
        address.setCity(cityinfo);
        
        Person person = new Person("Sebastian", "Nielsen");
        person.addHobby(hobby);
        person.setEmail("sebnielsen@hotmail.com");
        person.addPhone(phone);
        person.setAddress(address);
        
        pf.createperson(person);
        
        Person p = em.find(Person.class, person);
        assertEquals(person.getFirstName(), p.getFirstName());
    }
}
