/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.Company;
import entities.Person;
import exception.CompanyNotFoundException;
import java.util.List;

/**
 *
 * @author sebastiannielsen
 */
public interface ICompanyFacade {
    
    void createCompany(Company c);
    Company getCompany(long cvr) throws CompanyNotFoundException; 
    List<Company> getCompanies(); 
    void editCompany(Company c) throws CompanyNotFoundException;
    void deleteCompany(long cvr) throws CompanyNotFoundException;
    
}
