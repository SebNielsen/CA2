package entities;

import entities.CityInfo;
import entities.InfoEntity;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-05T15:17:16")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile ListAttribute<Address, InfoEntity> infoEntities;
    public static volatile SingularAttribute<Address, String> street;
    public static volatile SingularAttribute<Address, String> additionalInfo;
    public static volatile SingularAttribute<Address, CityInfo> city;

}