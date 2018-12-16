package test.core;


import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import test.bot.TestBot;
import test.bot.ThreadBotWorker;

public class EndPoint {
    public static void main(String[] args) {
        ApiContextInitializer.init(); // Инициализируем апи
        TelegramBotsApi botapi = new TelegramBotsApi();
        try {
            TestBot testBot = new TestBot();
            botapi.registerBot(testBot);
            Thread thread = new Thread(new ThreadBotWorker(testBot));
            thread.start();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}