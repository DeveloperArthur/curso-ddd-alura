package br.com.alura.domainEventsExample;

import br.com.alura.domainEventsExample.domain.event.EventHandler;
import br.com.alura.domainEventsExample.domain.event.PedidoFeito;
import br.com.alura.domainEventsExample.infra.EventDispatcher;
import br.com.alura.domainEventsExample.infra.SendMessageToAwsKinesisEventHandler;
import br.com.alura.domainEventsExample.infra.SendMessageToKafkaEventHandler;
import br.com.alura.domainEventsExample.infra.SendMessageToRabbitMQEventHandler;

public class Main {
    public static void main(String[] args) {
        PedidoFeito pedidoFeito = new PedidoFeito();

        EventHandler handlerkafka = new SendMessageToKafkaEventHandler();
        EventHandler handlerrabbitmq = new SendMessageToRabbitMQEventHandler();
        EventHandler handleraws = new SendMessageToAwsKinesisEventHandler();

        EventDispatcher eventDispatcher = new EventDispatcher();
        eventDispatcher.register(pedidoFeito.getNameClass(), handlerkafka);
        eventDispatcher.register(pedidoFeito.getNameClass(), handlerrabbitmq);
        eventDispatcher.register(pedidoFeito.getNameClass(), handleraws);

        //metodo notify ou notifyAsync
        eventDispatcher.notify(pedidoFeito);
    }
}
