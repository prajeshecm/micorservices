package com.hla.loan.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("myHealthCheck")
public class KafkaHealthIndicator  implements HealthIndicator {

    private int check() {
        // perform some specific health check
        return 0;
    }

    @Override
    public Health health() {
        int errorCode = check();
        if(errorCode !=0 ){
            return  Health.down().withDetail("DOWN TEST ","Server is down ..").build();
        }
        return Health.up().withDetail("UP TEST ","Server is UP and Running...").build();
    }
}
