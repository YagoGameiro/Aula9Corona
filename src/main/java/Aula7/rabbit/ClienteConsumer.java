package Aula7.rabbit;

import Aula7.model.Cliente;
import Aula7.service.ClienteService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClienteConsumer {

    @Autowired
    private ClienteService clienteService;

    @RabbitListener(queues = {"${queue.cliente.name}"})
    public void receive (@Payload Cliente cliente){
        System.out.println("Id: "+ cliente.getId() + "\nNome: " + cliente.getNome());
        //Inserir dado no Mongo
        clienteService.save(cliente);
    }
}
