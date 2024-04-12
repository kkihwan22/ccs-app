package org.ccs.app.core.authenticate.infra.repository;

import org.ccs.app.core.authenticate.domain.TokenHistoryDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenHistoryMongoRepository extends MongoRepository<TokenHistoryDocument, String> {

    Optional<TokenHistoryDocument> findTokenHistoryByToken(String token);
}
