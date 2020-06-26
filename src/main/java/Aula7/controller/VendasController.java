package Aula7.controller;

import Aula7.constant.Constants;
import Aula7.model.Vendas;
import Aula7.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class VendasController {

    @Autowired
    private VendasService vendasService;

    @PostMapping(Constants.API_VENDAS)
    public Vendas save(@RequestBody Vendas vendas){
        return vendasService.save(vendas);
    }

    @GetMapping(Constants.API_VENDAS)
    public List<Vendas> findAll(){
        return vendasService.findAll();
    }

    @PutMapping(Constants.API_VENDAS)
    public void update(@RequestBody Vendas vendas){
        vendasService.save(vendas);
    }

    @DeleteMapping(Constants.API_VENDAS + "/{id}")
    public void delete(@PathVariable("id") int id){
        vendasService.delete(id);
    }

    @GetMapping(Constants.API_VENDAS + "/{id}")
    public Optional<Vendas> findById(@PathVariable("id") String id){
        return vendasService.findById(id);
    }
}
