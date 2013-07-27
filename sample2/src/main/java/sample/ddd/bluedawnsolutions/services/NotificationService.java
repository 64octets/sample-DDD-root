package sample.ddd.bluedawnsolutions.services;

/**
 * Created with IntelliJ IDEA.
 * User: kevinpotgieter
 * Date: 26/06/2013
 * Time: 08:44
 * To change this template use File | Settings | File Templates.
 */
public interface NotificationService {
    void sendEmail(String toEmail, String message);
}
