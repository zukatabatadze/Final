public class GeneralException extends Exception {
    private String errorMessage;

    public GeneralException(String errorMessage) {
        this. errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}