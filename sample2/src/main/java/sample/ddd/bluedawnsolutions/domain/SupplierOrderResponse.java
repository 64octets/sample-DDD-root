package sample.ddd.bluedawnsolutions.domain;

public enum SupplierOrderResponse {
    ORDERED,
    PENDING;

    public String getOrderState() {
        return this.name();
    }
}
