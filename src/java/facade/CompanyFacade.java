/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Company;
import exception.CompanyNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author sebastiannielsen
 */
public class CompanyFacade implements ICompanyFacade {

    private EntityManagerFactory emf;

    public CompanyFacade(EntityManagerFactory e) {
        emf = e;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void createCompany(Company c) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public Company getCompany(long cvr) throws CompanyNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Company c WHERE c.cvr=:cvr").setParameter("cvr", cvr);
            Company c = (Company) query.getSingleResult();
            if (c == null) {
                throw new CompanyNotFoundException("No Company found with provided cvr");
            }
            return c;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Company> getCompanies() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("select c from Company c").getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void editCompany(Company c) throws CompanyNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Company c WHERE c.cvr=:cvr").setParameter("cvr", c.getCvr());
            Company edited = (Company) query.getSingleResult();
            if (edited == null) {
                throw new CompanyNotFoundException("No Company found with provided cvr");
            }
            edited.setCvr(c.getCvr());
            edited.setName(c.getName());
            edited.setDescription(c.getDescription());
            edited.setMarketValue(c.getMarketValue());
            edited.setNumEmployees(c.getNumEmployees());
            edited.setEmail(c.getEmail());
            edited.setAddress(c.getAddress());
            em.getTransaction().begin();
            em.merge(edited);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteCompany(long cvr) throws CompanyNotFoundException {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("SELECT c FROM Company c WHERE c.cvr=:cvr").setParameter("cvr", cvr);
            Company c = (Company) query.getSingleResult();
            if (c == null) {
                throw new CompanyNotFoundException("No Company found with provided cvr");
            }
            em.getTransaction().begin();
            em.remove(c);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

}
