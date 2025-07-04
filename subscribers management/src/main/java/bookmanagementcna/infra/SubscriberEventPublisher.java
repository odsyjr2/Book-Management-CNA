package bookmanagementcna.infra;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class SubscriberEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public void publish(Object event) {
        eventPublisher.publishEvent(event);
    }
    
}
