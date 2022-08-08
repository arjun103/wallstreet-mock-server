package com.example.wallstreetmockserver.mockServer;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/mock")
public class WallstreetMockServer {

    String getAddonResponse = "{\"data\":{\"id\":\"292515\",\"type\":\"credits\",\"attributes\":{\"available-credit\":\"0.0\",\"auto-recharge\":false,\"recharge-quantity\":0,\"auto-recharge-threshold\":5,\"recharge-options\":[5,10,25],\"auto-recharge-options\":[\"Off\",5,10,25],\"auto-recharge-threshold-options\":[5,10,25],\"recharge-allowed\":true,\"max-recharge-count\":3,\"is-credit-low\":true,\"calling-card-remaining-minutes\":null}}}";

    String getAddonUsageResponse = "{\"data\":{\"product\":\"FRESHCHAT\",\"productAccountId\":\"005fb150-b472-4c5f-a986-809a3ee8e98b\",\"bundleType\":\"SALES360\",\"bundleId\":\"381798185362595102\",\"orgId\":\"88964438062538641\",\"accountStatus\":\"FREDDY_USAGE_OK\",\"sessionsConsumed\":0,\"consumedPercentage\":0,\"sessionsAllowed\":60000,\"autoRechargeThresholdReached\":false,\"autoRecharge\":false,\"rechargeValue\":0}}";

    @PostMapping
    public ResponseEntity<String> events(){
        return ResponseEntity.ok().body(HttpStatus.OK.toString());
    }

    @GetMapping(path = "/ubx/addon")
    public ResponseEntity<String> getAddonFCaller(){
        return new ResponseEntity<> (getAddonResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/ubx/billing/authorize_purchase")
    public ResponseEntity<String> validateAddonFCaller(){
        return new ResponseEntity<> ("success", HttpStatus.OK);
    }

    @PatchMapping(path = "/ubx/addon")
    public ResponseEntity<String> purchaseAddonFCaller(){
        return new ResponseEntity<> ("success", HttpStatus.OK);
    }

    @GetMapping(path = "/v2/bots/account")
    public ResponseEntity<String> getAddonUsageFChat(){
        return new ResponseEntity<> (getAddonUsageResponse, HttpStatus.OK);
    }

    @PostMapping(path = "/ubx/addon/purchase")
    public ResponseEntity<String> purchaseAddonFChat(){
        return new ResponseEntity<> ("success", HttpStatus.OK);
    }
}
