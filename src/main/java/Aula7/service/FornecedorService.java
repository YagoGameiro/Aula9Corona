package Aula7.service;

import Aula7.model.Fornecedor;
import Aula7.rabbit.FornecedorProducer;
import Aula7.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {
    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private FornecedorProducer fornecedorProducer;

    public void sendFornecedorRabbit(Fornecedor fornecedor) { fornecedorProducer.send(fornecedor); }

    public Fornecedor save(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }
    public List<Fornecedor> findAll(){
        return fornecedorRepository.findAll();
    }
    public Optional<Fornecedor> findById(String id){
        return fornecedorRepository.findById(id);
    }
    public void delete(int id){
        String idString = String.valueOf(id);
        fornecedorRepository.deleteById(idString);
    }

    public void deleteAll(){
        fornecedorRepository.deleteAll();
    }
}
