package sample.ddd.bluedawnsolutions.domain;

import org.junit.Test;
import sample.ddd.bluedawnsolutions.infrastructure.ServiceLocator;
import sample.ddd.bluedawnsolutions.infrastructure.TestServiceLocator;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class OrderTest extends TestServiceLocator {

    @Test
    public void ensureThatWhenPlacingOrderThatCustomerIsNotifiedWhenStateIsOrdered() {


        ExternalSupplierService mockExternalSupplierService = ServiceLocator.getService(ExternalSupplierService.class);
        NotificationService mockNotificationService = ServiceLocator.getService(NotificationService.class);

        when(mockExternalSupplierService.placeOrder(any(OrderItem.class)))
                .thenReturn(SupplierOrderResponse.ORDERED)
                .thenReturn(SupplierOrderResponse.PENDING);

        Order order = new Order();
        OrderItem item1 = new OrderItem(new Customer("bob@mail.com"));
        OrderItem item2 = new OrderItem(new Customer("jim@fancytestmail.com"));
        order.addOrderItem(item1);
        order.addOrderItem(item2);

        order.placeOrderAndNotifyCustomer();

        assertThat(item1.getState(), is("ORDERED"));
        assertThat(item2.getState(), is("PENDING"));

        verify(mockExternalSupplierService).placeOrder(item1);

        verify(mockNotificationService).sendEmail("bob@mail.com", "Your order has been ORDERED!");

    }


}
