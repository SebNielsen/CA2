package facade;

import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersonFacade {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("CA2PU");
    EntityManager em = emf.createEntityManager();

    public void createperson(Person person) {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
    }

    public Person getPerson(Phone phone) {
        return em.find(Person.class, phone.getNumber());
    }

    public void updatePerson(Person person) {
        Person person1 = em.find(Person.class, person);
        em.getTransaction().begin();
        person1.setAddress(person.getAddress());
        person1.setEmail(person.getEmail());
        person1.setFirstName(person.getFirstName());
        person1.setHobbies(person.getHobbies());
        person1.setLastName(person.getLastName());
        person1.setPhones(person.getPhones());
        em.getTransaction().commit();
    }

    public void deletePerson(Person person) {
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }

    public List<Person> getPersonsWithHobby(Hobby hobby) {
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.hobbies.name=:hobby").setParameter("hobby", hobby);
        return query.getResultList();
    }

    public List<Person> getPersonsInCity(CityInfo city) {
        Query query = em.createQuery("SELECT p FROM Person p WHERE p.address.city=:city").setParameter("city", city);
        return query.getResultList();
    }

    public Long getPersonCountWithHobby(Hobby hobby) {
        Query query = em.createQuery("SELECT COUNT(p.id) FROM Person p WHERE p.hobbies.name=:hobby").setParameter("hobby", hobby);
        return (Long) query.getSingleResult();
    }

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
    public List<CityInfo> getZipCodes() {
        Query query = em.createQuery("SELECT c FROM CityInfo c");
        return query.getResultList();
    }

    public List<Company> getCompaniesWithEmployeeCount(Long empCount) {
        Query query = em.createQuery("SELECT c FROM Company c WHERE c.NumEmployees > :empCount").setParameter("empCount", empCount);
        return query.getResultList();
    }

    public Company getCompany(Company company) {
        Query query = em.createQuery("SELECT c FROM Company c WHERE c.cvr=:cvr OR c.phones=:phones").setParameter("cvr", company.getCvr()).setParameter("phones", company.getPhones());
        return (Company) query.getSingleResult();
    }
}
