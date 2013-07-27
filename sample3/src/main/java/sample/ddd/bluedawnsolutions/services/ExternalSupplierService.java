package sample.ddd.bluedawnsolutions.services;

import sample.ddd.bluedawnsolutions.domain.Order;
import sample.ddd.bluedawnsolutions.domain.SupplierOrderResponse;
import sample.ddd.bluedawnsolutions.domain.SupplierOrderState;

import java.util.List;

public interface ExternalSupplierService {
    List<SupplierOrderResponse> placeOrder(Order order);
}
