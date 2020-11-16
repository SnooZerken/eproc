package be.bredeweg68.eproc;

import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Cpv extends PanacheEntity{

    public String code;
    public String description;

    public static List<Cpv> findByText(String txt){

        return Cpv.find("code like CONCAT('%',?1,'%') or description like CONCAT('%',?1,'%')",txt).list();
    }        

}

