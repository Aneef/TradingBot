package com.trade.tradingbot.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class Configs {
    @Value("${binance.api.websocket.url}")
    String baseURL;

    @Value("${coin.symbol}")
    String coinSymbol;

    @Value("${coin.pricecheck.interval}")
    String priceCheckInterval;
}
