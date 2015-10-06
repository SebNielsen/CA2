/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entities.Company;
import entities.Person;
import exception.CompanyNotFoundException;
import exceptions.PersonNotFoundException;
import facade.CompanyFacade;
import facade.ICompanyFacade;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sebastiannielsen
 */
public class CompanyFacadeTest {

    CompanyFacade facade = new CompanyFacade(Persistence.createEntityManagerFactory("CA2_dev"));

    public CompanyFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        EntityManager em = facade.getEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Company").executeUpdate();
            em.persist(new Company(1234l, "firma", "description", 15, 300000l));
            em.persist(new Company(123l, "firma2", "description", 15, 300000l));
            em.persist(new Company(12l, "firma3", "description", 15, 300000l));
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddCompany() throws CompanyNotFoundException {
        Company company = new Company(12345l, "firma4", "description", 15, 300000l);
        facade.createCompany(company);
        assertEquals("firma4", company.getName());
        company = facade.getCompany(company.getCvr());
        assertEquals("firma4", company.getName());
    }

    @Test
    public void testGetCompany() throws CompanyNotFoundException {
        Company company = new Company(123456l, "firma5", "description", 10, 200000l);
        facade.createCompany(company);
        Company c = facade.getCompany(123456l);
        assertEquals(c.getName(), "firma5");
    }

    @Test
    public void testGetCompanies() {
        assertEquals(3, facade.getCompanies().size());
    }

    @Test
    public void testEditCompany() throws CompanyNotFoundException {
        Company company = facade.getCompany(1234l);
        company.setName("firma9");
        facade.editCompany(company);
        assertEquals("firma9", company.getName());
        System.out.println(facade.getCompany(1234l).getName());
        company = facade.getCompany(1234l);
        assertEquals("firma9", company.getName());
    }

    @Test
    public void testDeletePerson() throws CompanyNotFoundException {
        facade.deleteCompany(12l);
        assertEquals(facade.getCompanies().size(), 2);
    }

}
