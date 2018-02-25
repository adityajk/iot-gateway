package com.infosys.openhack.piedpiper.iotgateway.controller;

import com.hazelcast.core.HazelcastInstance;
import com.infosys.openhack.piedpiper.iotgateway.model.IotData;
import com.infosys.openhack.piedpiper.iotgateway.model.IotFilterData;
import com.infosys.openhack.piedpiper.iotgateway.service.IotCacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by aditya on 25/2/18.
 */
@RestController
@RequestMapping("/rest/gateway")
public class IotHttpController {

    private static Logger log = LoggerFactory.getLogger(IotHttpController.class);
    @Autowired
    HazelcastInstance hazelcastInstance;


    @Autowired
    IotCacheService iotCacheService;

    @PostMapping
    public void handleHttpRest(IotData iotData) {
        iotCacheService.cacheIotData(iotData);
    }

    @Scheduled(fixedRate = 2000)
    public IotFilterData sendFilterData() {
        Map<String, IotData> map = hazelcastInstance.getMap("iot-data");
        map.entrySet().stream().map(m -> m.getValue().getVehicleType()).forEach(System.out::println);
        log.info("print");
        return null;

    }


}
