package com.infosys.openhack.piedpiper.iotgateway.service;

import com.hazelcast.core.HazelcastInstance;
import com.infosys.openhack.piedpiper.iotgateway.model.IotData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by aditya on 25/2/18.
 */

@Service
//@CacheConfig(cacheNames = "iot-data")
public class IotCacheServiceImpl implements IotCacheService {

    private static Logger log = LoggerFactory.getLogger(IotCacheServiceImpl.class);

    @Autowired
    HazelcastInstance hazelcastInstance;


    @Override
   // @Cacheable
    public IotData cacheIotData(IotData iotData) {
        hazelcastInstance.getMap("iot-data").put("ioTHazel", iotData);
        log.info("Executing: " + this.getClass().getSimpleName() + ".store(\"" + iotData + "\");");
        return iotData;
    }



}
