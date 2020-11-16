package be.bredeweg68.eproc;

import java.util.List;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class ProcedureType extends PanacheEntity {

    public String code;
    public String name;

    public static List<ProcedureType> findByText(String txt){

        return ProcedureType.find("code like CONCAT('%',?1,'%') or name like CONCAT('%',?1,'%')",txt).list();

    }         
    
}
