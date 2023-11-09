package br.fatec.linhasitapirarest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Sorts.descending;
import org.bson.Document;

import br.fatec.linhasitapirarest.model.OnibusLocalizacao;
import br.fatec.linhasitapirarest.repository.OnibusLocalizacaoRepository;

@RestController
public class OnibusLocalizacaoController {

    @Autowired
    OnibusLocalizacaoRepository onibusRepo;

    @PostMapping("/api")
    public boolean postLocalizacao(@RequestBody OnibusLocalizacao onibusLocalizacao) {
        System.out.println(onibusLocalizacao);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("linhasItapira");
        MongoCollection<Document> collection = database.getCollection("onibusLocalizacao");

        Document searchQuery = new Document();
        FindIterable<Document> cursor = collection.find(searchQuery).sort(descending("_id")).limit(1);
        Integer ultimoId = 1;
        try (final MongoCursor<Document> cursorIterator = cursor.cursor()) {
            while (cursorIterator.hasNext()) {
                ultimoId = (Integer) cursorIterator.next().get("_id");
                System.out.println(ultimoId);
            }
        }

        onibusLocalizacao.set_id(ultimoId + 1);
        onibusRepo.save(onibusLocalizacao);

        return true;
    }

}
