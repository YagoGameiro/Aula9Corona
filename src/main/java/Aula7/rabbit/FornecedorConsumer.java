package Aula7.rabbit;

import Aula7.model.Fornecedor;
import Aula7.service.FornecedorService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class FornecedorConsumer {

    @Autowired
    private FornecedorService fornecedorService;

    @RabbitListener(queues = {"${queue3.fornecedor.name}"})
    public void receive (@Payload Fornecedor fornecedor){
        System.out.println("Id: "+ fornecedor.getId() + "\nNome: " + fornecedor.getNome());
        //Inserir dado no Mongo
        fornecedorService.save(fornecedor);
    }
}
