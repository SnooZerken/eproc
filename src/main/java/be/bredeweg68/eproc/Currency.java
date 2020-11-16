package be.bredeweg68.eproc;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Currency extends PanacheEntity{

    public String code;
    public String desc;

}
