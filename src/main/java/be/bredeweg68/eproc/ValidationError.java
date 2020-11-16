package be.bredeweg68.eproc;

public class ValidationError {

    private String message;
    private String invalidValue;
    private String propertyPath;

    public ValidationError(String message, String invalidValue, String propertyPath) {
        this.message = message;
        this.invalidValue = invalidValue;
        this.propertyPath = propertyPath;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getInvalidValue() {
        return invalidValue;
    }

    public void setInvalidValue(String invalidValue) {
        this.invalidValue = invalidValue;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public void setPropertyPath(String propertyPath) {
        this.propertyPath = propertyPath;
    }

}