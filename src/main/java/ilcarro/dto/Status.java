package ilcarro.dto;

/* @author Rostislav Dolbilov */

public enum Status {
    ACTIVE("ACTIVE"),
    DELETED("DELETED");


    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}