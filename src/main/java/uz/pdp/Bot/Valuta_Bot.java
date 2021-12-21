package uz.pdp.Bot;

import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardRemove;
import uz.pdp.Model.TgUser;
import uz.pdp.Model.enam.Language;
public  class Valuta_Bot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "Firuzjonbot";
    }

    @Override
    public String getBotToken() {
        return "5084840361:AAH06OmBkoFJ_VtEMmH9YKW0DXUSm8KQLV4";
    }


    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        String inputText=update.getMessage().getText();
        SendMessage sendMessage=new SendMessage();
        String chatId = BotService.getChatId(update);
        TgUser user=BotService.getOrCreateTgUser(chatId);
        if (update.getMessage().hasContact()){
            if (inputText.equals("/start")){
                SendMessage message = BotService.start(update);
                execute(message);
            }
            else if (update.getMessage().hasContact()){
                Contact contact=update.getMessage().getContact();
                if (contact.getPhoneNumber().equals("+998932101600")){
                    //TODO admin MENU
                }else {
                    deleteMessage(user);
                    sendMessage=BotService.showUserMainMunu(user,update);
                    execute(sendMessage);
                }
            }
            else if (update.hasCallbackQuery()){
                TgUser tgUserCallBackMenu=BotService.getOrCreateTgUser(BotService.getChatId(update));
                String data =update.getCallbackQuery().getData();


            }
        }

            else if (user.getState().equals(BotState.SHARE_CONTACT)){
                execute(BotService.getCantakolsh(update));
            }
           else if (inputText.equals("/adminjon") && user.isAdmin()){
                //TODO  admin menu
            }
            if (user.getState().equals(BotState.SHOW_MENU)){
                execute(sendMessage);
            }
        }
        @SneakyThrows
    private void deleteMessage(TgUser user) {
        SendMessage sendMessageRemove =new SendMessage();
        sendMessageRemove.setChatId(user.getChatId());
        sendMessageRemove.setText(".");
        sendMessageRemove.setReplyMarkup(new ReplyKeyboardRemove(true));
        Message message=execute(sendMessageRemove);
        DeleteMessage deleteMessage =new DeleteMessage(user.getChatId(),message.getMessageId());
        execute(deleteMessage);
    }
}
