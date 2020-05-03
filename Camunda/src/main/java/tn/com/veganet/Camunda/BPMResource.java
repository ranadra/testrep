package tn.com.veganet.Camunda;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.SignalEventReceivedBuilder;
import org.joda.time.LocalDateTime;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpHeaders;

@RestController
@RequestMapping("/api/bpm")
public class BPMResource {

    private final RuntimeService runtimeService;
    private HttpHeaders ImmutableMap;

    public BPMResource(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/signals")
    @Timed
    public ResponseEntity<Void> sendSignal(@RequestBody String signal) {
        SignalEventReceivedBuilder signalEvent = runtimeService.createSignalEvent(signal);
        signalEvent.setVariables(ImmutableMap.of("date", LocalDateTime.now()));
        signalEvent.send();
        return ResponseEntity.noContent().build();
    }
}