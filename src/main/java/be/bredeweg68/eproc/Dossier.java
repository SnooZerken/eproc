package be.bredeweg68.eproc;

import java.util.List;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import be.bredeweg68.eproc.ValidationGroups.Create;
import be.bredeweg68.eproc.ValidationGroups.Update;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Dossier extends PanacheEntity {

    @Transient
    Set<ConstraintViolation<Dossier>> violations;


    @NotBlank(
        message = "A reference must be provided",
        groups = Create.class
    )
    @Column(length = 100)
    public String reference;

    @NotBlank(
        message = "A title must be provided",
        groups = Create.class
    )
    @Column(length = 200)
    public String title;

    @NotNull(
        message = "An organisation must be provided",
        groups = Create.class
    )
    @OneToOne
    public Organisation organisation;

    @Column(length = 4)
    @Size(
        min = 0, 
        max = 4,
        groups = Update.class,
        message = "Description should contain 0 to 4 characters"
    )
    public String description;

    @Valid
    @AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "estimatedamount")),
            @AttributeOverride(name = "currency", column = @Column(name = "estimatedamountcurrency")), })
    public Amount estimatedamount;

    @Valid
    @AttributeOverrides({ @AttributeOverride(name = "amount", column = @Column(name = "awardedamount")),
            @AttributeOverride(name = "currency", column = @Column(name = "awardedamountcurrency")), })
    public Amount awardedamount;

    @OneToOne
    public Nature mainnature;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Nature> additionalnatures;

    @OneToOne
    public Cpv maincpv;

    @ManyToMany(fetch = FetchType.EAGER)
    public Set<Cpv> additionalcpvs;

    @OneToOne
    public ProcedureType proceduretype;

    @OneToOne
    public PublicOfficer contactpoint;

    public static List<Dossier> findByText(String txt) {

        return find("title like CONCAT('%',?1,'%') or reference like CONCAT('%',?1,'%') or description like CONCAT('%',?1,'%')", txt).list();

    }

    public ValidationResult validate(Class group) {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        try {
            violations = validator.validate(this, group);
          
        }catch(Exception e){
            System.out.println("In catch - ALL");
        }

        if (violations.isEmpty()) {
            return new ValidationResult("Dossier is valid");
        } else {
            return new ValidationResult(violations);
        }  

    }

}
