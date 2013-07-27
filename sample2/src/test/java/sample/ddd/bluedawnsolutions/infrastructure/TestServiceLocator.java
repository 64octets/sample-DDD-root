package sample.ddd.bluedawnsolutions.infrastructure;

import org.junit.Before;
import sample.ddd.bluedawnsolutions.services.ExternalSupplierService;
import sample.ddd.bluedawnsolutions.services.NotificationService;

import static org.mockito.Mockito.mock;

public class TestServiceLocator {

    @Before
    public void initialiseServiceLocator(){
        ServiceLocator instance = new ServiceLocator();
        instance.loadService(NotificationService.class, mock(NotificationService.class));
        instance.loadService(ExternalSupplierService.class, mock(ExternalSupplierService.class));
        ServiceLocator.load(instance);
    }
}
