package com.diego.sqs.infrastructure.sqs;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQSAsync;
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SqsConfig {

    @Value("${testes.aws.sqs.accessKey}")
    private String awsAccess;

    @Value("${testes.aws.sqs.secretKey}")
    private String awsSecret;

    @Value("${testes.aws.sqs.enableAwsRoleAuth}")
    private boolean enableAwsRoleAuth;

    @Value("${testes.aws.region}")
    private String region;

    @Bean("amazonSQSAsyncTestes")
    public AmazonSQSAsync amazonSQSAsync() {

        AmazonSQSAsyncClientBuilder clientBuilder = AmazonSQSAsyncClientBuilder.standard();

        if(!enableAwsRoleAuth)
            clientBuilder.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccess, awsSecret)));

        return clientBuilder
                .withRegion(region)
                .build();
    }

    @Bean("queueMessagingTemplate")
    public QueueMessagingTemplate queueMessagingTemplate(@Qualifier("amazonSQSAsyncTestes") AmazonSQSAsync amazonSQSAsync) {
        return new QueueMessagingTemplate(amazonSQSAsync);
    }

//    @Bean
//    public SimpleMessageListenerContainerFactory simpleMessageListenerContainerFactory(
//            @Qualifier("amazonSQSAsyncTestes") AmazonSQSAsync amazonSqs) {
//        SimpleMessageListenerContainerFactory factory = new SimpleMessageListenerContainerFactory();
//        factory.setAmazonSqs(amazonSqs);
//        factory.setAutoStartup(true);
//        factory.setMaxNumberOfMessages(10);
//        factory.setWaitTimeOut(10);
//        factory.setBackOffTime(60000L);
//        return factory;
//    }
//
//    @Bean
//    public QueueMessageHandlerFactory queueMessageHandlerFactory(
//            final ObjectMapper mapper,
//            final @Qualifier("amazonSQSAsyncTestes") AmazonSQSAsync amazonSQSAsync){
//        final QueueMessageHandlerFactory queueHandlerFactory = new QueueMessageHandlerFactory();
//        queueHandlerFactory.setAmazonSqs(amazonSQSAsync);
//        queueHandlerFactory.setArgumentResolvers(Collections.singletonList(
//                new PayloadMethodArgumentResolver(jackson2MessageConverter(mapper))
//        ));
//        return queueHandlerFactory;
//    }
//
//    private MessageConverter jackson2MessageConverter(final ObjectMapper mapper){
//        final MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//        converter.setObjectMapper(mapper);
//        converter.setStrictContentTypeMatch(false);
//        converter.setObjectMapper(mapper);
//        return converter;
//    }
}

