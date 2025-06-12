package com.welab.k8s_backend_alim.event.consumer;

import com.welab.k8s_backend_alim.event.consumer.message.user.SiteUserInfoEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaMessageConcumer {
    @KafkaListener(
            topics = SiteUserInfoEvent.Topic,
            properties = {
                    JsonDeserializer.VALUE_DEFAULT_TYPE
                        + ":com.welab.k8s_backend_alim.event.consumer.message.user.SiteUserInfoEvent"
            }
    )
    void handleStieUserInfoEvent(SiteUserInfoEvent event, Acknowledgment ack) {
            log.info("SiteUserInfoEvent 처리. userId={}", event.getUserId());

            ack.acknowledge();
    }
}
