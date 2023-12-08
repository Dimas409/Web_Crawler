import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ChatGPTMyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Study_gpt_bot";
    }

    @Override
    public String getBotToken() {
        return "6643616395:AAF_0YTsAdvmEDRBYvlvZPHPKy85ez3LlMU";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String chatId = update.getMessage().getChatId().toString();
        String messageText = update.getMessage().getText();
        sendTextMessage(chatId, "Вы написали: " + messageText);
    }
    private void sendTextMessage(String chatId, String text){
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);

        try{
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
