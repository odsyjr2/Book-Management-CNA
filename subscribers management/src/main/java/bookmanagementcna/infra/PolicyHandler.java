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
    SubscriberRepository subscriberRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookPublicated'"
    )
    public void wheneverBookPublicated_UpdateFeedWhenBookInfoTransferred(
        @Payload BookPublicated bookPublicated
    ) {
        BookPublicated event = bookPublicated;
        System.out.println(
            "\n\n##### listener UpdateFeedWhenBookInfoTransferred : " +
            bookPublicated +
            "\n\n"
        );

        // Sample Logic //
        Subscriber.updateFeedWhenBookInfoTransferred(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='BookInfoSended'"
    )
    public void wheneverBookInfoSended_BookInfoSave(
        @Payload BookInfoSended bookInfoSended
    ) {
        BookInfoSended event = bookInfoSended;
        System.out.println(
            "\n\n##### listener BookInfoSave : " + bookInfoSended + "\n\n"
        );

        // Sample Logic //
        Subscriber.bookInfoSave(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
