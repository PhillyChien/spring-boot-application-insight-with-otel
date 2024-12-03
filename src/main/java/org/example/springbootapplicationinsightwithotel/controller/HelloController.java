package org.example.springbootapplicationinsightwithotel.controller;

import org.example.springbootapplicationinsightwithotel.service.CommonService;
import org.example.springbootapplicationinsightwithotel.service.LoggingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/hello")
@RestController
public class HelloController {
    private final CommonService commonService;
    private final LoggingService loggingService;

    public HelloController(CommonService commonService, LoggingService loggingService) {
        this.commonService = commonService;
        this.loggingService = loggingService;
    }

    @GetMapping("/ok")
    public ResponseEntity<String> sayHello() {

        loggingService.info("HelloController.sayHello() has been called");

        String result = commonService.sayHello();

        loggingService.info("HelloController.sayHello() has been executed");
        return ResponseEntity.ok(result);
    }

    @GetMapping("/error")
    public ResponseEntity<String> sayError() {

        loggingService.info("HelloController.sayError() has been called");

        try {
            commonService.sayError();
        } catch (Exception e) {
            loggingService.warn("HelloController.sayError() has been executed with error");
            return ResponseEntity.status(400).body(e.getMessage());
        }

        return ResponseEntity.ok("Hello from HelloController.sayError()");
    }

    @GetMapping("/internal-error")
    public ResponseEntity<String> sayInternalError() {

        loggingService.info("HelloController.sayInternalError() has been called");

        try {
            commonService.sayInternalError();
        } catch (Exception e) {
            loggingService.error("HelloController.sayInternalError() has been executed with error");
            return ResponseEntity.status(500).body(e.getMessage());
        }

        return ResponseEntity.ok("Hello from HelloController.sayInternalError()");
    }
}
