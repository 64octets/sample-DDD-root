package sample.ddd.bluedawnsolutions.domain;

public enum SupplierOrderState {
    ORDERED,
    PENDING;

    public String getOrderState() {
        return this.name();
    }
}
