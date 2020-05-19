import com.pengrad.telegrambot.TelegramException;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private static final String TOKEN="1230356436:AAEOtE6346iy3HwGw3Mg6lcAuwKYQkJ7Pzk";
    private static final String BOTNAME="MyFirstSimpleJava_bot";

    public Bot(DefaultBotOptions options){
        super(options);
    }
    public String getBotToken(){
        return TOKEN;
    }

    public String getBotUsername(){
        return BOTNAME;
    }

    @Override
    //На каждое сообщение бот будет отвечать этим же сообщение +Hi
    public void onUpdateReceived(Update update) {
        if(update.getMessage() !=null && update.getMessage().hasText()){
            long chat_id=update.getMessage().getChatId();

            try{
                execute(new SendMessage(chat_id,"Hi "+update.getMessage().getText()));
            }catch (TelegramApiException ex){
                ex.printStackTrace();
            }
        }
    }
}
