package io.github.jairandersonsouza.authorizer.repository;

import io.github.jairandersonsouza.authorizer.entities.AccountBalance;
import io.github.jairandersonsouza.authorizer.entities.MccEnum;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AccountBalanceRepository extends JpaRepository<AccountBalance, String> {

    @Lock(LockModeType.PESSIMISTIC_READ)
    Optional<AccountBalance> findByAccountIdAndMcc(String id, MccEnum mcc);

}
