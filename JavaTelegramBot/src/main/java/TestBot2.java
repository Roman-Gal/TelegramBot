import javassist.Translator;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TestBot2 extends TelegramLongPollingBot {



    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()){
            Message message = update.getMessage();

            if (message.hasText()) {
                execute(
                         SendMessage.builder()
                        .chatId(message.getChatId().toString())
                        .text("Ваше слово: \n\n" + message.getText() + "Переклад" )
                        .build());
            }
        }
    }
    @Override
    public String getBotUsername() {
        return "Lang_POL_UKR_bot";
    }
    @Override
    public String getBotToken() {
        return "1976862242:AAEwCGbsw6TVVJNJmooryRj3vBovGxfYulQ";
    }
    @SneakyThrows
    public static void main(String[] args) {
        TestBot2 bot = new TestBot2();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi((DefaultBotSession.class));
        telegramBotsApi.registerBot(bot);
    }


}