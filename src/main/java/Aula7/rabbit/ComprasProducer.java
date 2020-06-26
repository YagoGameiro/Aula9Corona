package Aula7.rabbit;

import Aula7.model.Compras;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComprasProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue2;

    public void send(Compras compras){
        rabbitTemplate.convertAndSend(this.queue2.getName(), compras);
    }
}
