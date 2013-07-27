package sample.ddd.bluedawnsolutions.domain;

import sample.ddd.bluedawnsolutions.infrastructure.ServiceLocator;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

public class OrderItem {

    private String state;
    private Customer customer;

    public OrderItem(Customer customer) {
        this.customer = customer;
    }

    void placeOrderWith(){

        ExternalSupplierService externalSupplierService = ServiceLocator.getService(ExternalSupplierService.class);
        SupplierOrderResponse response = externalSupplierService.placeOrder(this);

        updateOrderItemTo(response.getOrderState());
    }

    private void updateOrderItemTo(String orderState) {
        this.state = orderState;
    }

    public void notifyCustomer() {
        if(state.equals("ORDERED")){
            NotificationService notificationService = ServiceLocator.getService(NotificationService.class);
            notificationService.sendEmail(customer.getEmailAddress(), "Your order has been ORDERED!");
        }
    }

    public String getState() {
        return state;
    }
}
