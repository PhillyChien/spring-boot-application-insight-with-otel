package org.example.springbootapplicationinsightwithotel.controller;

import org.apache.logging.log4j.message.StringMapMessage;
import org.example.springbootapplicationinsightwithotel.CustomLogger;
import org.example.springbootapplicationinsightwithotel.service.CommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/hello")
@RestController
public class HelloController {
    private final CommonService commonService;

    public HelloController(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping("/ok")
    public ResponseEntity<String> sayHello() {
        CustomLogger.info(CustomLogger.MessageFactory("This is Philly Test").with("key", "on method"));

        String result = commonService.sayHello();

        CustomLogger.info("HelloController.sayHello() has been executed");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/error")
    public ResponseEntity<String> sayError() {

        CustomLogger.info("HelloController.sayError() has been called");

        try {
            commonService.sayError();
        } catch (Exception e) {
            CustomLogger.warn("HelloController.sayError() has been executed with error");
            return ResponseEntity.status(400).body(e.getMessage());
        }

        return ResponseEntity.ok("Hello from HelloController.sayError()");
    }

    @GetMapping("/internal-error")
    public ResponseEntity<String> sayInternalError() {

        CustomLogger.info("HelloController.sayInternalError() has been called");

        try {
            commonService.sayInternalError();
        } catch (Exception e) {
            CustomLogger.error("HelloController.sayInternalError() has been executed with error");
            return ResponseEntity.status(500).body(e.getMessage());
        }

        return ResponseEntity.ok("Hello from HelloController.sayInternalError()");
    }
}
