package fsa.training.ThinhNV_JWD.L.A101.repository;

import fsa.training.ThinhNV_JWD.L.A101.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}