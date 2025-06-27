package bookmanagementcna.infra;

import bookmanagementcna.config.kafka.KafkaProcessor;
import bookmanagementcna.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AdminRepository adminRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='RegistrationRequested'"
    )
    public void wheneverRegistrationRequested_RequestRegister(
        @Payload RegistrationRequested registrationRequested
    ) {
        RegistrationRequested event = registrationRequested;
        System.out.println(
            "\n\n##### listener RequestRegister : " +
            registrationRequested +
            "\n\n"
        );

        // Comments //
        //requestId에서 작가 등록인지 출판 등록인지 구분 필요

        // Sample Logic //
        Admin.requestRegister(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PublishRequestRegistered'"
    )
    public void wheneverPublishRequestRegistered_RequestRegister(
        @Payload PublishRequestRegistered publishRequestRegistered
    ) {
        PublishRequestRegistered event = publishRequestRegistered;
        System.out.println(
            "\n\n##### listener RequestRegister : " +
            publishRequestRegistered +
            "\n\n"
        );

        // Comments //
        //requestId에서 작가 등록인지 출판 등록인지 구분 필요

        // Sample Logic //
        Admin.requestRegister(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Login'"
    )
    public void wheneverLogin_ApproveLogin(@Payload Login login) {
        Login event = login;
        System.out.println(
            "\n\n##### listener ApproveLogin : " + login + "\n\n"
        );

        // Sample Logic //
        Admin.approveLogin(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Logout'"
    )
    public void wheneverLogout_ApproveLogout(@Payload Logout logout) {
        Logout event = logout;
        System.out.println(
            "\n\n##### listener ApproveLogout : " + logout + "\n\n"
        );

        // Sample Logic //
        Admin.approveLogout(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
