package br.com.alura.domainEventsExample.domain.event;

public class Event {
    public String getNameClass(){
        return getClass().getName();
    }
}