package br.com.alura.domainEventsExample.domain.event;

public interface EventHandler {
    void send(Event event) throws InterruptedException;
}