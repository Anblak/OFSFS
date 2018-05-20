package com.ofsfs.repository;

import com.ofsfs.domains.UsersFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersFileRepository extends JpaRepository<UsersFile,Long>{
}
