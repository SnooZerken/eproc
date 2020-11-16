package be.bredeweg68.eproc;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Nature extends PanacheEntity{
    
    public String code;
    public String description;

    public static List<Nature> findByText(String txt){
        
        return find("code like CONCAT('%',?1,'%') or description like CONCAT('%',?1,'%')",txt).list();
    }    

}
