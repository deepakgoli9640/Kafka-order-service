package SpringBoot.Kafka.controller;


import SpringBoot.Kafka.entity.Order;
import SpringBoot.Kafka.producer.OrderProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
public class OrderController {

      private final OrderProducer orderProducer;

      public OrderController(OrderProducer orderProducer)
      {
          this.orderProducer=orderProducer;
      }

      @PostMapping
      public ResponseEntity<String> placeorder(@RequestBody Order order)
      {
          orderProducer.sendOrder(order);
          return ResponseEntity.accepted().body("Order placed Successfully");
      }


}
