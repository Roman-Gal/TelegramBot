import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class TestBot extends DefaultAbsSender {

    protected TestBot(DefaultBotOptions options) {
        super(options);
    }

    @Override
    public String getBotToken() {
        return "your token";
    }
   @SneakyThrows
    public static void main(String[] args) {
        TestBot bot = new TestBot(new DefaultBotOptions());
        bot.execute(SendMessage.builder().chatId("374079938").text("hello world from JAva").build());

    }
}
