package test.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TestBot extends TelegramLongPollingBot {
    
    @Override
    public void onUpdateReceived(Update update) {
// We check if the update has a message and the message has text
        System.out.println("wkek" + update.getMessage().getChatId());
        if (update.hasMessage() && update.getMessage().hasText()) {
            filter(update);
        }
        System.out.println("kek" + update.getMessage().getChatId());
    }

    @Override
    public String getBotUsername() {
        return "HITEK_TEST_BOT";
    }

    @Override
    public String getBotToken() {
        return "534762565:AAFo70xBCRJrMk_Um2CH0qisydUA2gZ0Zks";
    }


    private void filter(Update update){
        String actor = update.getMessage().getFrom().getFirstName();
        System.out.println(update.getMessage().getText());
        if(actor.equals("Sergey")){
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId());
            message.setText("Сергей ленивая жопка, хули ты не учишься говнюк сранный??!!");

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if(actor.equals("Andrey")){
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId());
            message.setText("Андрюша молодец!");

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        } else if(actor.equals("Yuri")){
            SendMessage message = new SendMessage()
                    .setChatId(update.getMessage().getChatId());
            message.setText("Юрасик вообще бомба - молодец!");

            try {
                execute(message); // Call method to send the message
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }

    }

}