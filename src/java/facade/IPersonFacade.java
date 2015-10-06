/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entities.CityInfo;
import entities.Hobby;
import entities.Person;
import entities.Phone;
import exceptions.PersonNotFoundException;
import java.util.List;

/**
 *
 * @author Jonas
 */
public interface IPersonFacade {

    public void createPerson(Person person);

    public Person getPerson(Person person) throws PersonNotFoundException;

    public void editPerson(Person person) throws PersonNotFoundException;

    public void deletePerson(Person person) throws PersonNotFoundException;

    public List<Person> getPersonsWithHobby(Hobby hobby) throws PersonNotFoundException;

    public List<Person> getPersonsInCity(CityInfo city) throws PersonNotFoundException;

    public Long getPersonCountWithHobby(Hobby hobby);
}
