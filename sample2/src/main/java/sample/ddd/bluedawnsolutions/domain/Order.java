package sample.ddd.bluedawnsolutions.domain;

import com.google.common.collect.Lists;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import java.util.List;

public class Order {

    private List<OrderItem> items = Lists.newArrayList();

    public void placeOrderAndNotifyCustomer() {

        for (OrderItem item : items) {
            item.placeOrderWith();
            item.notifyCustomer();
        }
    }

    public void addOrderItem(OrderItem item) {
        items.add(item);
    }
}
