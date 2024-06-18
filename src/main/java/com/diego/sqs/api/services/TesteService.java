package com.diego.sqs.api.services;

import com.diego.sqs.api.requests.TesteRequest;
import com.diego.sqs.domain.Teste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface TesteService {

    Teste cadastrar (TesteRequest testeRequest);

    Page<Teste> listarTodos(Pageable pageable);

    Teste buscarPorId(Long id);

    Teste buscarPorCpf(String cpf);

    void deletePorId(long id);

    void sendToQueue(String queue, String data, String servico, int tentativaAtual);

    TesteRequest enviaTesteFila(TesteRequest teste);

    //void consomeFilaDeSms(TesteRequest testeRequest);

}
