package entities;

import entities.Address;
import entities.Phone;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T15:17:16")
@StaticMetamodel(InfoEntity.class)
public class InfoEntity_ { 

    public static volatile SingularAttribute<InfoEntity, Long> id;
    public static volatile SingularAttribute<InfoEntity, String> email;
    public static volatile SingularAttribute<InfoEntity, Address> address;
    public static volatile ListAttribute<InfoEntity, Phone> phones;

}