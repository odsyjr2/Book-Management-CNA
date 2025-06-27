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
    AuthorRepository authorRepository;

    @Autowired
    PublishManageRepository publishManageRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='AuthorApproved'"
    )
    public void wheneverAuthorApproved_ApproveAuthor(
        @Payload AuthorApproved authorApproved
    ) {
        AuthorApproved event = authorApproved;
        System.out.println(
            "\n\n##### listener ApproveAuthor : " + authorApproved + "\n\n"
        );

        // Sample Logic //
        Author.approveAuthor(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookApproved'"
    )
    public void wheneverBookApproved_ApprovePublish(
        @Payload BookApproved bookApproved
    ) {
        BookApproved event = bookApproved;
        System.out.println(
            "\n\n##### listener ApprovePublish : " + bookApproved + "\n\n"
        );

        // Sample Logic //
        PublishManage.approvePublish(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
