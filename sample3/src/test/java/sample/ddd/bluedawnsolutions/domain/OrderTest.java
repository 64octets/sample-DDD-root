package sample.ddd.bluedawnsolutions.domain;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import sample.ddd.bluedawnsolutions.application.OrderingService;
import sample.ddd.bluedawnsolutions.application.StandardOrderingService;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;


public class OrderTest {

    private OrderingService orderingService;

    private ExternalSupplierService mockExternalSupplierService;
    private NotificationService mockNotificationService;

    @Before
    public void initialiseOrderingService() {
        mockExternalSupplierService = mock(ExternalSupplierService.class);
        mockNotificationService = mock(NotificationService.class);
        //mimick the autowiring behaviour that would occur normally.
        orderingService = new StandardOrderingService(mockExternalSupplierService, mockNotificationService);
    }

    @Test
    public void ensureThatWhenPlacingOrderThatCustomerIsNotifiedWhenStateIsOrdered() {


        Order order = new Order();
        OrderItem item1 = new OrderItem(new Customer("bob@mail.com"));
        OrderItem item2 = new OrderItem(new Customer("jim@fancytestmail.com"));
        order.addOrderItem(item1);
        order.addOrderItem(item2);

        when(mockExternalSupplierService.placeOrder(any(Order.class)))
                .thenReturn(Lists.newArrayList(new SupplierOrderResponse(SupplierOrderState.ORDERED, item1),
                        new SupplierOrderResponse(SupplierOrderState.PENDING, item2)));

        orderingService.placeOrderAndNotifyCustomer(order);

        assertThat(item1.getState(), is("ORDERED"));
        assertThat(item2.getState(), is("PENDING"));

        verify(mockExternalSupplierService).placeOrder(order);

        verify(mockNotificationService).sendEmail("bob@mail.com", "Your order has been ORDERED!");

    }


}
