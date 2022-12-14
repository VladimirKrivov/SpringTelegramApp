package com.example.tgm.app.telegram.service;

import com.example.tgm.app.model.entity.Order;
import com.example.tgm.app.model.entity.Product;
import com.example.tgm.app.model.entity.ProductInOrder;
import com.example.tgm.app.telegram.config.TelegramConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class TelegramService extends TelegramLongPollingBot {

    private final TelegramConfig telegramConfig;
//    private final OrderService orderService;

    public TelegramService(TelegramConfig telegramConfig) {
        this.telegramConfig = telegramConfig;
//        this.orderService = orderService;
    }


    @Override
    public String getBotUsername() {
        return telegramConfig.getBotName();
    }

    @Override
    public String getBotToken() {
        return telegramConfig.getBotToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            switch (messageText) {
                case "/start":
                    try {
                        startCommandReceived(chatId, update.getMessage().getChat().getFirstName());
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "/all":
                    try {
                        getAllOrder(chatId);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                default:
                    try {
                        sendMessage(chatId, "???????????? ?????????????? ???? ????????????????????????????");
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
            }
        }

    }

    private void getAllOrder(Long chatID) throws TelegramApiException {
//        List<Order> orders = orderService.getAll();
//        for (Order a : orders) {
//            sendMessage(chatID, toMessage(a));
//        }

    }

    private void startCommandReceived(Long chatId, String name) throws TelegramApiException {
        String message = "???????????? " + name + ", ?????????????? ??????????????????????????!";
        sendMessage(chatId, message);
    }

    private void sendMessage(Long chatId, String message) throws TelegramApiException {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(chatId));
        sendMessage.setText(message);
        execute(sendMessage);
    }

    public void toMessage(Order order) throws TelegramApiException {

//        int allPrice = 0;
//        String prodPos = "";
//
//        for (ProductInOrder pr : order.getRegistrationOrder()){
//            allPrice += (pr.getProdCount() * pr.getProducts().getPrice());
//            double price  = (pr.getProdCount() * pr.getProducts().getPrice());
//            prodPos += pr.getProducts().getTitle() + " x " +pr.getProdCount() + " " + price + " ??????." + ("\n");
//        }

        String b = "?? ?????? ?????????? ??????????!" + "\n" +
                "?????? ??????????????????: " + order.getFirstName() + "\n" +
                "?????????? ????????????????: " + order.getPhoneNumber() + "\n" +
                "?????? ????????????????: " + order.getDelivery() + "\n" +
                "??????????: " + order.getCity() + "\n" +
                "??????????: " + order.getStreet() + "\n" +
                "?????????? ????????: " + order.getHouse() + "\n" +
                "???????????????????? ????????????: " + order.getPerson() + "\n" +
                "?????????????????? ?? ????????????: " + order.getOther() + "\n" +
                "|" + "\n" +
                "|" + "\n" +
                "|" + "\n";
//                prodPos + "\n" +
//                "?????????? ?????????????????? ????????????: " + allPrice;
//                "?????????? ?????????????????? ????????????: " + order.get()+ "\n";


        sendMessage(533097066L, b);
    }
}
