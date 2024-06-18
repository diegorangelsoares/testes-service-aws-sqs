package com.diego.sqs.api.services;

import com.diego.sqs.api.exception.RecursoNaoEncontradoException;
import com.diego.sqs.api.requests.TesteRequest;
import com.diego.sqs.domain.Teste;
import com.diego.sqs.infrastructure.gson.GsonLocalDateSerializer;
import com.diego.sqs.infrastructure.gson.GsonLocalDateTimeSerializer;
import com.diego.sqs.infrastructure.persistence.TesteRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.messaging.Message;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class TesteServiceImpl implements TesteService{

    @Value("${testes.aws.sqs.url}")
    private String smsQueueUrl;

    private final TesteRepository testeRepository;

    private final QueueMessagingTemplate messagingTemplate;

    public TesteServiceImpl(TesteRepository testeRepository, @Qualifier("queueMessagingTemplate") QueueMessagingTemplate messagingTemplate) {
        this.testeRepository = testeRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @Override
    public Teste cadastrar (TesteRequest testeRequest){
        Teste teste = new Teste();
        teste.setTexto(testeRequest.getTexto());
        teste.setCpf(testeRequest.getCpf());
        return testeRepository.save(teste);
    }

    @Override
    public Page<Teste> listarTodos(Pageable pageable){
        return testeRepository.findAll(pageable);
    }

    @Override
    public Teste buscarPorId(Long id){
        return testeRepository.findById(id).orElseThrow((() -> new RecursoNaoEncontradoException("Teste com id "+id+" não encontrada.")));
    }

    @Override
    public Teste buscarPorCpf(String cpf) {
        return testeRepository.findByCpf(cpf).orElseThrow((() -> new RecursoNaoEncontradoException("Teste com CPF "+cpf+" não encontrada.")));
    }

    @Override
    public void deletePorId(long id) {
        Teste teste = testeRepository.findById(id).orElseThrow((() -> new RecursoNaoEncontradoException("Teste com id "+id+" não encontrado para remoção.")));
        testeRepository.delete(teste);
    }

    @Override
    public TesteRequest enviaTesteFila(TesteRequest teste) {
        Gson gson = getGson();
        String servico = "teste-service";
        sendToQueue(smsQueueUrl, gson.toJson(teste), servico, 0);
        return teste;
    }

    private Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, GsonLocalDateSerializer.INSTANCE)
                .registerTypeAdapter(LocalDateTime.class, GsonLocalDateTimeSerializer.INSTANCE)
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void sendToQueue(String queue, String data, String servico, int tentativaAtual) {
        String dedupId = servico + "_" + tentativaAtual + "_" + UUID.randomUUID();
        Message<String> msg = MessageBuilder.withPayload(data)
                .setHeader("message-group-id", "send-sms-" + UUID.randomUUID())
                .setHeader("message-deduplication-id", dedupId)
                .setHeader("sender", "testes-service")
                .build();

        try {
            messagingTemplate.send(queue, msg);
        }catch (Exception e) {
            log.error("Falha ao enviar mensagem para a fila - " + e.getMessage());
            throw e;
        }
    }




}
