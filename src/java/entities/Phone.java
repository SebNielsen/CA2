package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author sebastiannielsen
 */
@Entity
public class Phone implements Serializable {

    @Id 
    private int number;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private InfoEntity infoEntity; 

    public Phone() {
    }

    public Phone(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
