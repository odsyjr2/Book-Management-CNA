package bookmanagementcna.infra;

import bookmanagementcna.config.kafka.KafkaProcessor;
import bookmanagementcna.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionListViewHandler {

    //<<< DDD / CQRS
    @Autowired
    private SubscriptionListRepository subscriptionListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenLogin_then_CREATE_1(@Payload Login login) {
        try {
            if (!login.validate()) return;

            // view 객체 생성
            SubscriptionList subscriptionList = new SubscriptionList();
            // view 객체에 이벤트의 Value 를 set 함
            SubscriptionList.setId(login.getId());
            // view 레파지 토리에 save
            SubscriptionListRepository.save(subscriptionList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenContentViewEnabled_then_UPDATE_1(
        @Payload ContentViewEnabled contentViewEnabled
    ) {
        try {
            if (!contentViewEnabled.validate()) return;
            // view 객체 조회

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //>>> DDD / CQRS
}
