package sample.ddd.bluedawnsolutions.application;

public interface DomainEventListener<T> {

    public void onDomainEvent(T eventObject);
}
