package be.bredeweg68.eproc;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrors {

    private List<ValidationError> validationerrors;

    public List<ValidationError> getValidationerrors() {
        return validationerrors;
    }

    public void setValidationerrors(List<ValidationError> validationerrors) {
        this.validationerrors = validationerrors;
    }

    public void addValidationerror(ValidationError ve){
        this.validationerrors.add(ve);
    }

    public ValidationErrors() {
        this.validationerrors = new ArrayList<ValidationError>();
    }

    
    
}
