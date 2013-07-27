package sample.ddd.bluedawnsolutions.domain;

import com.google.common.collect.Lists;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import java.util.List;

public class Order {

    private List<OrderItem> items = Lists.newArrayList();

    public void placeOrderAndNotifyCustomer(ExternalSupplierService externalSupplierService, NotificationService notificationService) {

        for (OrderItem item : items) {
            item.placeOrderWith(externalSupplierService);
            item.notifyCustomer(notificationService);
        }
    }

    public void addOrderItem(OrderItem item) {
        items.add(item);
    }
}
