package SpringBoot.Kafka.producer;


import SpringBoot.Kafka.entity.Order;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

     private  final KafkaTemplate<String, Order> kafkaTemplate;
     public OrderProducer(KafkaTemplate kafkaTemplate)
     {
         this.kafkaTemplate=kafkaTemplate;
     }

     @Value("${kafka.topic.order}")
    private String orderTopic;

    public void sendOrder(Order order) {
        kafkaTemplate.send(orderTopic, order.getOrderId(), order);
}
}
