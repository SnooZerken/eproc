package be.bredeweg68.eproc;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class PublicOfficer extends PanacheEntity{

    public String email;
    public String name;

    public static List<PublicOfficer> findByText(String txt){

        return PublicOfficer.find("email like CONCAT('%',?1,'%') or name like CONCAT('%',?1,'%')",txt).list();

    }           
    
}
