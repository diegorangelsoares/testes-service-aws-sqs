package com.diego.sqs.api.services;

import com.diego.sqs.api.requests.TesteRequest;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ConsumerService {

//    @SqsListener(value = {"${testes.aws.sqs.url}"}, deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    @SqsListener(value = {"${testes.aws.sqs.url}"})
    public void consomeFila(TesteRequest teste) {
//    public void consomeFila(@Payload final TesteRequest teste) {
        log.info("Consumindo fila...");
        log.info(teste.toString());
    }


}
