package sample.ddd.bluedawnsolutions.application;

import sample.ddd.bluedawnsolutions.domain.Order;

/**
 * Created with IntelliJ IDEA.
 * User: kevinpotgieter
 * Date: 11/07/2013
 * Time: 08:18
 * To change this template use File | Settings | File Templates.
 */
public interface OrderingService {
    Order placeOrderAndNotifyCustomer(Order order);
}
