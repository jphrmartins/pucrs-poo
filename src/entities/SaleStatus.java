package entities;

public enum  SaleStatus {
    FINISHED("Finalizada"), CANCELED("Cancelada");

    private String namedStatus;

    private SaleStatus(String namedStatus) {
        this.namedStatus = namedStatus;
    }

    public String getNamedStatus() {
        return namedStatus;
    }
}
