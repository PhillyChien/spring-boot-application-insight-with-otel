package org.example.springbootapplicationinsightwithotel.service;

import org.example.springbootapplicationinsightwithotel.CustomLogger;
import org.springframework.stereotype.Service;

@Service
public class CommonService {

    public String sayHello() {
        CustomLogger.info("CommonService has been called");
        return "Hello from CommonService";
    }

    public void sayError() {
        CustomLogger.error("CommonService has been called with error");
        throw new RuntimeException("Error from CommonService");
    }

    public void sayInternalError() {
        CustomLogger.error("CommonService has been called with internal error");
        throw new RuntimeException("Internal error from CommonService");
    }
}
