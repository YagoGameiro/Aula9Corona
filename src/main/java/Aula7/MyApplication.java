package Aula7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyApplication {
    @Value("${queue.cliente.name}")
    private String clienteQueue;
    @Value("${queue2.compras.name}")
    private String comprasQueue;
    @Value("${queue3.fornecedor.name}")
    private String fornecedorQueue;
    @Value("${queue4.produto.name}")
    private String produtoQueue;
    @Value("${queue5.vendas.name}")
    private String vendasQueue;

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

    @Bean
    public Queue queue(){
        return new Queue(clienteQueue, true);
    }

    @Bean
    public Queue queue2(){
        return new Queue(comprasQueue, true);
    }

    @Bean
    public Queue queue3(){
        return new Queue(fornecedorQueue, true);
    }

    @Bean
    public Queue queue4(){
        return new Queue(produtoQueue, true);
    }

    @Bean
    public Queue queue5(){
        return new Queue(vendasQueue, true);
    }
}