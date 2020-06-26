package Aula7.controller;

import Aula7.constant.Constants;
import Aula7.model.Cliente;
import Aula7.repository.ClienteRepository;
import Aula7.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping(Constants.API_CLIENTE)
    public Cliente save(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @GetMapping(Constants.API_CLIENTE)
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @PutMapping(Constants.API_CLIENTE)
    public void update(@RequestBody Cliente cliente){
        clienteService.save(cliente);
    }

    @DeleteMapping(Constants.API_CLIENTE + "/{id}")
    public void delete(@PathVariable("id") String id){
        clienteService.delete(id);
    }

    @GetMapping(Constants.API_CLIENTE + "/{id}")
    public Optional<Cliente> findById(@PathVariable("id") String id){
        return clienteService.findById(id);
    }
}
