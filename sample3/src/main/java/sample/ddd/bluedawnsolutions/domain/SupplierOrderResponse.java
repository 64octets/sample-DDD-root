package sample.ddd.bluedawnsolutions.domain;

/**
 * Value object to hold the external response representation for the placement of an order.
 */
public class SupplierOrderResponse {

    private final SupplierOrderState supplierOrderState;
    private final OrderItem item;

    public SupplierOrderResponse(SupplierOrderState supplierOrderState, OrderItem item) {
        this.supplierOrderState = supplierOrderState;
        this.item = item;
    }

    public SupplierOrderState getSupplierOrderState() {
        return supplierOrderState;
    }

    public OrderItem getItem() {
        return item;
    }
}
