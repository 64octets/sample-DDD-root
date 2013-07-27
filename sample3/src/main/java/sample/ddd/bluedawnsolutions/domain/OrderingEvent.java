package sample.ddd.bluedawnsolutions.domain;

public final class OrderingEvent {

    private final OrderItem orderItem;

    private OrderingEvent(OrderItem orderItem) {
        this.orderItem = orderItem;
    }

    public static OrderingEvent createFrom(OrderItem orderItem) {
        return new OrderingEvent(orderItem);
    }

    public boolean isOrdered() {
        return orderItem.isOrdered();
    }

    public String getContactEmail() {
        return orderItem.getContactEmail();
    }
}
