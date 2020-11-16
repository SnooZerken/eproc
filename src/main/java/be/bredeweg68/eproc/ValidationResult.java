package be.bredeweg68.eproc;

import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;

public class ValidationResult {

    ValidationResult(String message) {
        this.success = true;
        this.message = message;
        this.validationerrors = null;
    }

    ValidationResult(Set<? extends ConstraintViolation<?>> violations) {
        this.success = false;
        this.message = violations.stream()
             .map(cv -> cv.getMessage())
             .collect(Collectors.joining(", "));

        this.validationerrors = new ValidationErrors();
        violations.forEach(e -> this.validationerrors.addValidationerror(new ValidationError(e.getMessage(), e.getInvalidValue()!=null? e.getInvalidValue().toString():"", e.getPropertyPath()!=null?e.getPropertyPath().toString(): "")));

    }

    private String message;
    private boolean success;
    private ValidationErrors validationerrors;

    public String getMessage() {
        return message;
    }

    public ValidationErrors getValidationErrors(){
        return this.validationerrors;
    }

    public boolean isSuccess() {
        return success;
    }

}