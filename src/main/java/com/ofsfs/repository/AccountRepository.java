package com.ofsfs.repository;

import com.ofsfs.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

    Account findByUuid(String uuid);
}
