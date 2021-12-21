package uz.pdp.Bot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import uz.pdp.DB.DB;
import uz.pdp.Model.Stekerlar;
import uz.pdp.Model.TgUser;
import uz.pdp.Model.TwilioVerification;
import uz.pdp.Model.enam.Language;

import java.util.ArrayList;
import java.util.List;

public class BotService {
    private static final String TWILIO_SID = "AC9fb4cfa4ab50ec40540ff531e032f372";
    private static final String TWILIO_TOKEN = "b444944cb27816fc64eee760dbe98d86";
    private static final String TWILIO_PHONE = "+12184322439";
    private static String code = "";

    /***Userni  ChatAydisini  qaytaradi;***/
    public static String getChatId(Update update) {
        if (update.hasMessage()) {
            return update.getMessage().getChatId().toString();
        } else if (update.hasCallbackQuery()) {
            return update.getCallbackQuery().getMessage().getChatId().toString();
        }
        return "";
    }

    /**
     * Ruyhatdan utgan Foydalanuvchilar yoki yangi user qaytaradi
     **/
    public static TgUser getOrCreateTgUser(String chatId) {
        for (TgUser user : DB.tgUserList) {
            if (user.getChatId().equals(chatId)) {
                return user;
            }
        }
        TgUser user = new TgUser(chatId, BotState.SHARE_CONTACT);
        DB.tgUserList.add(user);
        return user;
    }

    /***Foydalanuvchilarni Telfon Raqamini oladi***/
    public static SendMessage getCantakolsh(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(Stekerlar.PITICHKA+"\t\t KANTAKAGINGIZNI  JUNATING \t\t"+Stekerlar.PITICHKA);
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        KeyboardButton button = new KeyboardButton();
        button.setText(Stekerlar.POINT_RIGHT+"\t JUNATISH \t"+Stekerlar.POINT_LEFT);
        button.setRequestContact(true);
        KeyboardRow row = new KeyboardRow();
        row.add(button);
        List<KeyboardRow> keyboardRowList = new ArrayList<>();
        keyboardRowList.add(row);
        markup.setSelective(true);
        markup.setResizeKeyboard(true);
        markup.setKeyboard(keyboardRowList);
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    public static SendMessage start(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(Stekerlar.QOR_PARCHA +"\t\tVALYUTA CONVERTOR BOTGA HUSHKELIBSIZ\t\t"+Stekerlar.QOR_PARCHA);
        sendMessage.setChatId(getChatId(update));
        TgUser user = getOrCreateTgUser(getChatId(update));

        user.setState(BotState.START);
        BotService.saveUserChanges(user);


        if (user.getState().equals(BotState.START)) {
            user.setState(BotState.SHARE_CONTACT);
            BotService.saveUserChanges(user);

            ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
            List<KeyboardRow> rowList = new ArrayList<>();
            KeyboardRow row1 = new KeyboardRow();
            KeyboardButton row1Button1 = new KeyboardButton();
            row1Button1.setText("Jo'natish");
            row1Button1.setRequestContact(true);
            row1.add(row1Button1);
            rowList.add(row1);

            markup.setKeyboard(rowList);
            markup.setSelective(true);
            markup.setResizeKeyboard(true);
            sendMessage.setChatId(getChatId(update));
            sendMessage.setReplyMarkup(markup);
        }
        return sendMessage;
    }

    public static void saveUserChanges(TgUser changedUser) {
        for (TgUser user : DB.tgUserList) {
            if (user.getChatId().equals(changedUser.getChatId())) {
                user = changedUser;
            }
        }
    }

    public static SendMessage showUserMainMunu(TgUser user, Update update) {
        SendMessage sendMessage=new SendMessage();
        String chatId=getChatId(update);
        if (user.getState().equals(BotState.SHARE_CONTACT) ||user.getState().equals(BotState.SHOW_MENU)){
            user.setState(BotState.SHOW_MENU);
            saveUserChanges(user);
            InlineKeyboardMarkup markup=new InlineKeyboardMarkup();
            List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
            List<InlineKeyboardButton> row1 = new ArrayList<>();
            List<InlineKeyboardButton> row2 = new ArrayList<>();
            InlineKeyboardButton row1Button1 = new InlineKeyboardButton();
            InlineKeyboardButton row2Button1 = new InlineKeyboardButton();
            row1Button1.setText("Valyuta tanlash ");
            row2Button1.setText("Curslarni Ayriboshlash");
            row1Button1.setCallbackData(Stekerlar.QOR_PARCHA);
            row2Button1.setCallbackData(Stekerlar.UZB_BAYROQ);
            row1.add(row1Button1);
            row2.add(row2Button1);
            rowList.add(row1);
            rowList.add(row2);
            markup.setKeyboard(rowList);
            sendMessage.setChatId(chatId);
            sendMessage.setReplyMarkup(markup);
        }
        return sendMessage;
    }
}






