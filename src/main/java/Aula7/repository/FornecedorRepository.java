package Aula7.repository;

import Aula7.model.Fornecedor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {
}
