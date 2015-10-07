package DBTester;

import deploy.DeploymentConfiguration;
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
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

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
        
        DeploymentConfiguration.setDevModeOn();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(DeploymentConfiguration.PU_NAME);
        EntityManager em = emf.createEntityManager();
//        Persistence.generateSchema("pu_test", null);
    }
}
