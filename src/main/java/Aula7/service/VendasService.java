package Aula7.service;

import Aula7.model.Vendas;
import Aula7.rabbit.VendasProducer;
import Aula7.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendasService {
    @Autowired
    private VendasRepository vendasRepository;

    @Autowired
    private VendasProducer vendasProducer;

    public void sendVendasRabbit(Vendas vendas) { vendasProducer.send(vendas); }

    public Vendas save(Vendas vendas){
        return vendasRepository.save(vendas);
    }
    public List<Vendas> findAll(){
        return vendasRepository.findAll();
    }
    public Optional<Vendas> findById(String id){
        return vendasRepository.findById(id);
    }
    public void delete(int id){
        String idString = String.valueOf(id);
        vendasRepository.deleteById(idString);
    }

    public void deleteAll(){
        vendasRepository.deleteAll();
    }
}
