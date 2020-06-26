package Aula7.service;

import Aula7.model.Produto;
import Aula7.rabbit.ProdutoProducer;
import Aula7.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoProducer produtoProducer;

    public void sendProdutoRabbit(Produto produto) { produtoProducer.send(produto); }

    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }
    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }
    public Optional<Produto> findById(String id){
        return produtoRepository.findById(id);
    }
    public void delete(String id){
        produtoRepository.deleteById(id);
    }

    public void deleteAll(){
        produtoRepository.deleteAll();
    }
}
