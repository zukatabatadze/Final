public class CoreException extends Exception {
    private String errorMessage;

    public CoreException(String errorMessage) {
        this. errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}