package org.example.springbootapplicationinsightwithotel.service;

import org.springframework.stereotype.Service;

@Service
public class CommonService {

    private final LoggingService loggingService;

    public CommonService(LoggingService loggingService) {
        this.loggingService = loggingService;
    }

    public String sayHello() {
        loggingService.info("CommonService has been called");
        return "Hello from CommonService";
    }

    public void sayError() {
        loggingService.error("CommonService has been called with error");
        throw new RuntimeException("Error from CommonService");
    }

    public void sayInternalError() {
        loggingService.error("CommonService has been called with internal error");
        throw new RuntimeException("Internal error from CommonService");
    }
}
