package sample.ddd.bluedawnsolutions.infrastructure;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * Sample class to demonstrate the Service Locator usage in DDD. If using Spring, you would have this
 * class delegate to the ApplicationContext in order to look up the needed implementations.
 * @param <T>
 */
public class ServiceLocator<T> {

    private Map<Class<T>, T> services = Maps.newHashMap();
    private static ServiceLocator soleInstance;

    static void load(ServiceLocator arg) {
        soleInstance = arg;
    }

    public final static <T> T getService(Class<T> key) {
        return (T) soleInstance.services.get(key);
    }

    public void loadService(Class<T> key, T service) {
        services.put(key, service);

    }
}
