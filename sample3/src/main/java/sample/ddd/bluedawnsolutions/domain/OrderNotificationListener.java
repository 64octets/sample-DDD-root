package sample.ddd.bluedawnsolutions.domain;

import sample.ddd.bluedawnsolutions.application.DomainEventListener;
import sample.ddd.bluedawnsolutions.services.NotificationService;

public class OrderNotificationListener implements DomainEventListener<OrderingEvent> {

    private final NotificationService notificationService;

    public OrderNotificationListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Override
    public void onDomainEvent(OrderingEvent eventObject) {
        if (eventObject.isOrdered()) {
            this.notificationService.sendEmail(eventObject.getContactEmail(), "Your order has been ORDERED!");
        }
    }
}
