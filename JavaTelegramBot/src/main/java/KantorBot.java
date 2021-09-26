import javassist.Translator;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class KantorBot extends TelegramLongPollingBot {



    @Override
    @SneakyThrows
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            handleMessage(update.getMessage());
        }


    }
@SneakyThrows
    private void handleMessage(Message message) {
        if (message.hasText() && message.hasEntities()) {
            Optional<MessageEntity> commandEntity =
                    message.getEntities()
                    .stream()
                    .filter(e -> "bot_command"
                    .equals(e.getType()))
                    .findFirst();
            if (commandEntity.isPresent()) {
                String command = message.getText()
                        .substring(commandEntity.get()
                        .getOffset(), commandEntity.get().getLength());
                switch (command) {
                    case "/set_currnecy":
                        List<List<InlineKeyboardButton>> buttons = new ArrayList<>();
                        execute(
                         SendMessage.builder()
                         .text("Оберіть Валюту")
                        .chatId(message.getChatId().toString())
                        .replyMarkup(InlineKeyboardMarkup.builder().build())
                        .build());
                    return;
                }
            }
        }
    }

    @Override
    public String getBotUsername() {
        return "Lang_POL_UKR_bot";
    }
    @Override
    public String getBotToken() {
        return "your token";
    }
    @SneakyThrows
    public static void main(String[] args) {
        KantorBot bot = new KantorBot();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi((DefaultBotSession.class));
        telegramBotsApi.registerBot(bot);
    }


}
