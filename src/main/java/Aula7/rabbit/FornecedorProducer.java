package Aula7.rabbit;

import Aula7.model.Fornecedor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FornecedorProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue3;

    public void send(Fornecedor fornecedor){
        rabbitTemplate.convertAndSend(this.queue3.getName(), fornecedor);
    }
}
