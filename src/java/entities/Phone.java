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
    private Long number;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private InfoEntity infoEntity; 

    public Phone() {
    }

    public Phone(Long number, String description) {
        this.number = number;
        this.description = description;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public InfoEntity getInfoEntity() {
        return infoEntity;
    }

    public void setInfoEntity(InfoEntity infoEntity) {
        this.infoEntity = infoEntity;
    }
    
    
    
    
}
