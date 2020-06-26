package Aula7.service;

import Aula7.model.Compras;
import Aula7.rabbit.ComprasProducer;
import Aula7.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasService {

    @Autowired
    private ComprasRepository comprasRepository;

    @Autowired
    private ComprasProducer comprasProducer;

    public void sendComprasRabbit(Compras compras) { comprasProducer.send(compras); }

    public Compras save(Compras compras){
        return comprasRepository.save(compras);
    }
    public List<Compras> findAll(){
        return comprasRepository.findAll();
    }
    public Optional<Compras> findById(String id){
        return comprasRepository.findById(id);
    }
    public void delete(int id){
        String idString = String.valueOf(id);
        comprasRepository.deleteById(idString);
    }

    public void deleteAll(){
        comprasRepository.deleteAll();
    }
}
