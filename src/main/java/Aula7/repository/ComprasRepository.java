package Aula7.repository;

import Aula7.model.Compras;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComprasRepository extends MongoRepository<Compras, String> {
}
