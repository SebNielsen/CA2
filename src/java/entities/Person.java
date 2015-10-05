package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * @author sebastiannielsen
 */
@Entity
public class Person extends InfoEntity {
    
    private String firstName;
    private String lastName;
    
    @ManyToMany
    private List<Hobby> hobbies = new ArrayList();
    
    public Person(){
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void addHobby(Hobby hobby){
        hobbies.add(hobby);
    }
    
    public List<Hobby> getHobbies(){
        return hobbies;
    }
}
