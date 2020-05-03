package tn.com.veganet.Camunda;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class Printer {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public void printMessage(DelegateExecution execution) {
        log.info("Hello world " + execution.getVariable("date"));
    }
}
