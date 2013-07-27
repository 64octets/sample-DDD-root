package sample.ddd.bluedawnsolutions.domain;

import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

public class OrderItem {

    private String state;
    private Customer contact;

    public OrderItem(Customer contact) {
        this.contact = contact;
    }

    void placeOrderWith(ExternalSupplierService externalSupplierService){

        SupplierOrderResponse response = externalSupplierService.placeOrder(this);

        updateOrderItemTo(response.getOrderState());
    }

    private void updateOrderItemTo(String orderState) {
        this.state = orderState;
    }

    public void notifyCustomer(NotificationService notificationService) {
        if(state.equals("ORDERED")){
            notificationService.sendEmail(contact.getEmailAddress(), "Your order has been ORDERED!");
        }
    }

    public String getState() {
        return state;
    }
}
