package br.fatec.linhasitapirarest.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import br.fatec.linhasitapirarest.model.OnibusLocalizacao;

public interface OnibusLocalizacaoRepository extends MongoRepository<OnibusLocalizacao,String>{
    
}
