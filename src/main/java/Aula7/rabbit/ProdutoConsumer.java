package Aula7.rabbit;

import Aula7.model.Produto;
import Aula7.service.ProdutoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ProdutoConsumer {

    @Autowired
    private ProdutoService produtoService;

    @RabbitListener(queues = {"${queue4.produto.name}"})
    public void receive (@Payload Produto produto){
        System.out.println("Id: "+ produto.getId() + "\nNome: " + produto.getNome());
        //Inserir dado no Mongo
        produtoService.save(produto);
    }
}
