package info.zhangran.aws.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@Slf4j
@RestController
@EnableAutoConfiguration
public class DemoController {

  @Value("${dynamodb.access.key}")
  private String dynamodbAccessKey;

  @Value("${exploreparamstore.device.token}")
  private String deviceToken;


  @Value("${test1}")
  private String secretManagerTest1;

  @Value("${test2}")
  private String secretManagerTest2;

  @Value("${test3}")
  private String secretManagerTest3;

  @GetMapping("/parameter")
  public ResponseEntity<String> getParam() {
    log.info("Parameter Store DyamoDB Access Key {}", dynamodbAccessKey);
    log.info("Parameter Store Device Token {}", deviceToken);
    log.info("Secret Manager test1's value {}", secretManagerTest1);
    log.info("Secret Manager test2's value {}", secretManagerTest2);
    log.info("Secret Manager test3's value {}", secretManagerTest3);
    return ResponseEntity.ok("hello");
  }

}
