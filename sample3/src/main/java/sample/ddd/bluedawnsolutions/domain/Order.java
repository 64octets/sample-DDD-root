package sample.ddd.bluedawnsolutions.domain;

import com.google.common.collect.Lists;
import sample.ddd.bluedawnsolutions.application.DomainEventListener;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import java.util.List;
import java.util.Set;

public class Order {

    private List<OrderItem> items = Lists.newArrayList();

    public void addOrderItem(OrderItem item) {
        items.add(item);
    }

    public void notifyCustomers(Set<DomainEventListener> listeners) {
        for (OrderItem item : items) {
            item.notifyCustomer(listeners);
        }
    }

    public void updateOrderItemFromSupplierResponse(OrderItem item, SupplierOrderState supplierOrderState) {
        item.updateOrderItemTo(supplierOrderState.getOrderState());
    }
}
