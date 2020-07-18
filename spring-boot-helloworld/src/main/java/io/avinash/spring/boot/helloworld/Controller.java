package io.avinash.spring.boot.helloworld;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


  @Value("${test}")

  private String testVar;
  @GetMapping("/test")
  String getTest()
  {
    return this.testVar;
  }

}
