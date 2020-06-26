package Aula7.repository;

import Aula7.model.Vendas;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends MongoRepository<Vendas, String> {
}
