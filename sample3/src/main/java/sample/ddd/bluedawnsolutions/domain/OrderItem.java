package sample.ddd.bluedawnsolutions.domain;

import sample.ddd.bluedawnsolutions.application.DomainEventListener;

import java.util.Set;

class OrderItem {

    private String state;
    private Customer customer;

    public OrderItem(Customer customer) {
        this.customer = customer;
    }

    void updateOrderItemTo(String orderState) {
        this.state = orderState;
    }

    public void notifyCustomer(Set<DomainEventListener> listeners) {
        for(DomainEventListener listener : listeners){
            listener.onDomainEvent(OrderingEvent.createFrom(this));
        }
    }

    public String getState() {
        return state;
    }

    public String getContactEmail(){
        return this.customer.getEmailAddress();
    }

    public boolean isOrdered() {
        return this.state !=null &&
                this.getState() == "ORDERED";
    }
}
