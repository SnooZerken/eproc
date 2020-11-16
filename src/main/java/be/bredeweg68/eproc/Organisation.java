package be.bredeweg68.eproc;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Organisation extends PanacheEntity{

    public String acronym;
    public String name;   

      
    public static List<Organisation> findByAcronym(String acronym){
        return list("acronym", acronym);
    }

    public static List<Organisation> findByName(String name){
        return list("name", name);
    }

    public Organisation(String acronym, String name) {
        this.acronym = acronym;
        this.name = name;
    }

    public Organisation() {
    } 

    

}
