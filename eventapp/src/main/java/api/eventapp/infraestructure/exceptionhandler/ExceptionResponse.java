package api.eventapp.infraestructure.exceptionhandler;

public enum ExceptionResponse {
    NO_DATA_FOUND("No data associated with the requested query was found"),
    ALREADY_EXISTS("A resource with these data already exists"),
    INVALID_DATE("The inserted dates are not valid");

    private final String message;

    ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}