package com.example.tgm.app.telegram.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@PropertySource("value.properties")
public class TelegramConfig {
    @Value("${bot.name}")
    String botName;
    @Value("${bot.token}")
    String botToken;
}
