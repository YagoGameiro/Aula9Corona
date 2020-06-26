package Aula7.rabbit;

import Aula7.model.Vendas;
import Aula7.service.VendasService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class VendasConsumer {

    @Autowired
    private VendasService vendasService;

    @RabbitListener(queues = {"${queue5.vendas.name}"})
    public void receive (@Payload Vendas vendas){
        System.out.println("Id: "+ vendas.getId() + "\nNome: " + vendas.getDescricao());
        //Inserir dado no Mongo
        vendasService.save(vendas);
    }
}
