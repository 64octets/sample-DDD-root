package sample.ddd.bluedawnsolutions.services;

import sample.ddd.bluedawnsolutions.domain.OrderItem;
import sample.ddd.bluedawnsolutions.domain.SupplierOrderResponse;

public interface ExternalSupplierService {
    SupplierOrderResponse placeOrder(OrderItem item);
}
