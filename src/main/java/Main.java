import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import uz.pdp.Bot.Valuta_Bot;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
        try {
            telegramBotsApi.registerBot(new Valuta_Bot());

        }catch (TelegramApiRequestException e){
            e.printStackTrace();
        }catch (TelegramApiException e){
            e.printStackTrace();
        }
    }
}
