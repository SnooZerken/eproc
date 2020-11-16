package be.bredeweg68.eproc;

import javax.persistence.Embeddable;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Embeddable
public class Amount extends PanacheEntityBase{

    @PositiveOrZero(
        message = "An amount has to be a positive number"
    )
    public Float amount;
    
    @Size(
        min = 3,
        max = 3,
        message = "Currency should be expressed in 3 numbers"
    )
    public String currency;
    
}
