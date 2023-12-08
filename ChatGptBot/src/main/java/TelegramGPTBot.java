import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.PrimitiveIterator;

public class TelegramGPTBot {
    private static final String TELEGRAM_BOT_TOKEN = "6643616395:AAF_0YTsAdvmEDRBYvlvZPHPKy85ez3LlMU";
    private static final String GPT_API_KEY = "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";

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
        try{
            botsApi.registerBot(new ChatGPTMyBot());
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
        while (true){
            
        }
    }
}
