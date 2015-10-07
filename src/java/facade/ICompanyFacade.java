/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.CityInfo;
import entities.Company;
import exception.CompanyNotFoundException;
import java.util.List;

/**
 *
 * @author sebastiannielsen
 */
public interface ICompanyFacade {
    
    Company createCompany(Company c);
    Company getCompany(long cvr) throws CompanyNotFoundException; 
    List<Company> getCompanies();
    List<Company> getCompaniesInCity(CityInfo city) throws CompanyNotFoundException;
    List<Company> getCompaniesWithEmployeeCount(Long empCount) throws CompanyNotFoundException;
    Company editCompany(Company c) throws CompanyNotFoundException;
    Company deleteCompany(long cvr) throws CompanyNotFoundException;
    
}
