package br.com.alura.domainEventsExample.infra;

import br.com.alura.domainEventsExample.domain.event.Event;
import br.com.alura.domainEventsExample.domain.event.EventHandler;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class SendMessageToKafkaEventHandler implements EventHandler {
    @Override
    public void send(Event event) throws InterruptedException {
        TimeUnit.SECONDS.sleep((int) (Math.random() * 5) + 1);
        System.out.println("evento KAFKA concluido as "+ LocalDateTime.now());
    }
}