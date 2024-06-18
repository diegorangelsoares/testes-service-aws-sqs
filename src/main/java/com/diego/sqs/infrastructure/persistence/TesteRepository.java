package com.diego.sqs.infrastructure.persistence;

import com.diego.sqs.domain.Teste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;

@Repository
public interface TesteRepository  extends JpaRepository<Teste, Long> {

    Optional<Teste> findById(long id);

    Optional<Teste> findByCpf(String cpf);

}

