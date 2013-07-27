package sample.ddd.bluedawnsolutions.application;

import com.google.common.collect.Sets;
import sample.ddd.bluedawnsolutions.domain.Order;
import sample.ddd.bluedawnsolutions.domain.OrderNotificationListener;
import sample.ddd.bluedawnsolutions.domain.SupplierOrderResponse;
import sample.ddd.bluedawnsolutions.domain.SupplierOrderState;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import java.util.List;
import java.util.Set;

/**
 * This class' responsibility is to handle communication with outside services to place order on behalf of the order,
 * and return a transformed response from the supplier about the items we just placed.
 */
public class StandardOrderingService implements OrderingService {

    private final ExternalSupplierService externalSupplierService;
    private final NotificationService notificationService;

    public StandardOrderingService(ExternalSupplierService externalSupplierService, NotificationService notificationService) {
        this.externalSupplierService = externalSupplierService;
        this.notificationService = notificationService;
    }

    @Override
    public Order placeOrderAndNotifyCustomer(Order order) {
        Set<DomainEventListener> listeners = Sets.newHashSet();
        listeners.add(new OrderNotificationListener(this.notificationService));

        // Let this application service communicate with the outside supplier and essentially transform the response
        // into a model we can understand.
        List<SupplierOrderResponse> supplierResponse = externalSupplierService.placeOrder(order);

        for(SupplierOrderResponse orderItemResponse : supplierResponse){
            order.updateOrderItemFromSupplierResponse(orderItemResponse.getItem(), orderItemResponse.getSupplierOrderState());
        }
        order.notifyCustomers(listeners);

        return order;
    }
}
