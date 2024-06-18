package com.diego.sqs;

import com.diego.sqs.api.configuration.ApplicationProperty;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.MessageFormat;


@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperty.class)
public class TestesApplication {

    public static void main(String[] args) throws UnknownHostException {

        Logger logger = LoggerFactory.getLogger(TestesApplication.class);
        SpringApplication app = new SpringApplication(TestesApplication.class);
        Environment env = app.run(args).getEnvironment();
        if (logger.isInfoEnabled()) {
            String mensageLog = """
			
			----------------------------------------------------------
			Teste Service está rodando! Acesse uma das URLs:
			Local Swagger: http://localhost:{0}/swagger-ui/index.html
			Local:   http://localhost:{0}
			Externa: http://{1}:{0}
			----------------------------------------------------------
			""";
            logger.info(MessageFormat.format(mensageLog,
                    env.getProperty("server.port"),
                    InetAddress.getLocalHost().getHostAddress()));
        }

        log.info("APP UP");


    }

}
