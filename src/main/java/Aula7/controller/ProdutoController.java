package Aula7.controller;

import Aula7.model.Produto;
import Aula7.constant.Constants;
import Aula7.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping(Constants.API_PRODUTO)
    public Produto save(@RequestBody Produto produto){
        return produtoService.save(produto);
    }

    @GetMapping(Constants.API_PRODUTO)
    public List<Produto> findAll(){
        return produtoService.findAll();
    }

    @PutMapping(Constants.API_PRODUTO)
    public void update(@RequestBody Produto produto){
        produtoService.save(produto);
    }

    @DeleteMapping(Constants.API_PRODUTO + "/{id}")
    public void delete(@PathVariable("id") String id){
        produtoService.delete(id);
    }

    @GetMapping(Constants.API_PRODUTO + "/{id}")
    public Optional<Produto> findById(@PathVariable("id") String id){
        return produtoService.findById(id);
    }
}
