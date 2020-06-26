package Aula7.rabbit;

import Aula7.model.Compras;
import Aula7.service.ComprasService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ComprasConsumer {

    @Autowired
    private ComprasService comprasService;

    @RabbitListener(queues = {"${queue2.compras.name}"})
    public void receive (@Payload Compras compras){
        System.out.println("Id: "+ compras.getId() + "\nNome: " + compras.getDescricao());
        //Inserir dado no Mongo
        comprasService.save(compras);
    }
}
