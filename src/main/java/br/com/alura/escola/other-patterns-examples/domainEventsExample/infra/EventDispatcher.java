package br.com.alura.domainEventsExample.infra;

import br.com.alura.domainEventsExample.domain.event.Event;
import br.com.alura.domainEventsExample.domain.event.EventHandler;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EventDispatcher {
    private Map<String, List<EventHandler>> events = new HashMap<>();

    public void register(String event, EventHandler eventHandler){
        if (this.events.get(event) == null || this.events.get(event).size() == 0){
            this.events.put(event, new ArrayList<>());
        }
        this.events.get(event).add(eventHandler);
    }

    //método sincrono e bloqueante
    public void notify(Event event){
        this.events.get(event.getNameClass()).forEach(h -> {
            try {
                System.out.println("Send event at "+ LocalDateTime.now());
                h.send(event);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    //método com programação reativa e nao bloqueante
    public void notifyAsync(Event event){
        int numberOfAllTasks = events.get(event.getNameClass()).size();
        ExecutorService executor = Executors.newFixedThreadPool(numberOfAllTasks);

        this.events.get(event.getNameClass()).forEach(task -> {
            executor.execute(createTask(task, event));
        });
    }

    private Runnable createTask(EventHandler task, Event event) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Send event at "+ LocalDateTime.now());
                    task.send(event);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}