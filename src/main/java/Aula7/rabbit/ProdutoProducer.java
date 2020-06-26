package Aula7.rabbit;

import Aula7.model.Produto;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue4;

    public void send(Produto produto){
        rabbitTemplate.convertAndSend(this.queue4.getName(), produto);
    }
}
