package Aula7.controller;

import Aula7.constant.Constants;
import Aula7.model.Compras;
import Aula7.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping(Constants.API_COMPRAS)
    public Compras save(@RequestBody Compras compras){
        return comprasService.save(compras);
    }

    @GetMapping(Constants.API_COMPRAS)
    public List<Compras> findAll(){
        return comprasService.findAll();
    }

    @PutMapping(Constants.API_COMPRAS)
    public void update(@RequestBody Compras compras){
        comprasService.save(compras);
    }

    @DeleteMapping(Constants.API_COMPRAS + "/{id}")
    public void delete(@PathVariable("id") int id){
        comprasService.delete(id);
    }

    @GetMapping(Constants.API_COMPRAS + "/{id}")
    public Optional<Compras> findById(@PathVariable("id") String id){
        return comprasService.findById(id);
    }
}
