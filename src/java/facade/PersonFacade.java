package facade;

import entities.CityInfo;
import entities.Company;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import exceptions.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class PersonFacade implements IPersonFacade {

    private EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory e) {
        emf = e;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void createPerson(Person person) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Person getPerson(Person person) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, person.getPhones().get(0));
//            Query query = em.createQuery("SELECT p FROM Person p WHERE p.phones=:phones").setParameter("phones", person.getPhones());
//            Person p = (Person) query.getSingleResult();
            if (p == null) {
                throw new PersonNotFoundException("No person with that phone number found!");
            }
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public void editPerson(Person person) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Person edited = em.find(Person.class, 1L);
           
            if (edited == null) {
                throw new PersonNotFoundException("Requested person not found!");
            }
            em.getTransaction().begin();
            edited.setAddress(person.getAddress());
            edited.setEmail(person.getEmail());
            edited.setFirstName(person.getFirstName());
            edited.setHobbies(person.getHobbies());
            edited.setLastName(person.getLastName());
            edited.setPhones(person.getPhones());
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Override
    public void deletePerson(Person person) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Person p = em.find(Person.class, person);
            if (p == null) {
                throw new PersonNotFoundException("Requested person not found!");
            }
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

    }

    @Override
    public List<Person> getPersonsWithHobby(Hobby hobby) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.hobbies.name=:hobby").setParameter("hobby", hobby);
            List<Person> pList = query.getResultList();
            if (pList == null) {
                throw new PersonNotFoundException("No persons found with that hobby!");
            }
            return pList;
        } finally {
            em.close();
        }

    }

    @Override
    public List<Person> getPersonsInCity(CityInfo city) throws PersonNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Person p WHERE p.address.city=:city").setParameter("city", city);
            List<Person> pList = query.getResultList();
            if (pList == null) {
                throw new PersonNotFoundException("No persons found in that city!");
            }
            return pList;

        } finally {
            em.close();
        }
    }

    @Override
    public Long getPersonCountWithHobby(Hobby hobby) {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT COUNT(p.id) FROM Person p WHERE p.hobbies.name=:hobby").setParameter("hobby", hobby);
            return (Long) query.getSingleResult();
        } finally {
            em.close();
        }
    }

//-------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------------------------------------
    public List<CityInfo> getZipCodes() {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM CityInfo c");
        return query.getResultList();
    }

    public List<Company> getCompaniesWithEmployeeCount(Long empCount) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM Company c WHERE c.NumEmployees > :empCount").setParameter("empCount", empCount);
        return query.getResultList();
    }

    public Company getCompany(Company company) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT c FROM Company c WHERE c.cvr=:cvr OR c.phones=:phones").setParameter("cvr", company.getCvr()).setParameter("phones", company.getPhones());
        return (Company) query.getSingleResult();
    }
}
