import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;

public class Main {
    public static void main(String[] args) {
        ApiContextInitializer.init();

        DefaultBotOptions botOptions= ApiContext.getInstance(DefaultBotOptions.class);
        //для обхода блокирвки телеграмма, использую прокси
        botOptions.setProxyType(DefaultBotOptions.ProxyType.SOCKS5);
        botOptions.setProxyHost("localhost");
        botOptions.setProxyPort(9150);

        Bot myBot=new Bot(botOptions);
        TelegramBotsApi botsApi=new TelegramBotsApi();

        try{
            botsApi.registerBot(myBot);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
