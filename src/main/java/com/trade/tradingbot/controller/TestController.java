package com.trade.tradingbot.controller;

import com.binance.connector.client.WebsocketClient;
import com.binance.connector.client.enums.DefaultUrls;
import com.binance.connector.client.impl.WebsocketClientImpl;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {



    public String monitorPrices(String symbol, String interval){
        System.out.println("Monitoring..!!");
        WebsocketClient wsc = new WebsocketClientImpl(DefaultUrls.WS_URL);

        wsc.klineStream(symbol, interval, open -> {
            System.out.println("Connection Opened..!!" + open);
        }, message -> {
                System.out.println("Price..  "+message);
        }, close -> {}, failure -> {
            System.out.println("Error occurred while establishing connection..!!");
        });
        return "Monitoring..!!";
    }

@GetMapping("/mon")
    public String monitorPricesWithDefaultSettings(){
       return monitorPrices("LUNCBUSD", "1m");
    }

    private JSONObject toJson(String json) throws ParseException {
        JSONParser parser = new JSONParser(json);
        return (JSONObject) parser.parse();
    }


}
