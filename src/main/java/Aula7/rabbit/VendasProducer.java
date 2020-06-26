package Aula7.rabbit;

import Aula7.model.Vendas;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VendasProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue5;

    public void send(Vendas vendas){
        rabbitTemplate.convertAndSend(this.queue5.getName(), vendas);
    }
}
