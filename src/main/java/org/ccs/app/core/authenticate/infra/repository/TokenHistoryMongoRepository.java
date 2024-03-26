package org.ccs.app.core.authenticate.infra.repository;

import org.ccs.app.core.authenticate.domain.IssuedToken;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TokenHistoryMongoRepository extends MongoRepository<IssuedToken, String> {

    Optional<IssuedToken> findTokenHistoryByToken(String token);
}
