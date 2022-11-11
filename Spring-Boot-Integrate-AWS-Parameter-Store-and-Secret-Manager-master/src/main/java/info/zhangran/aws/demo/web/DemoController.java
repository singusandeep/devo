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

 
  

  @GetMapping("/parameter")
  public ResponseEntity<String> getParam() {  
    return ResponseEntity.ok("value : value1");
  }

}
