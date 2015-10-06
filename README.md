# Java Telegram Bot API

This is a Telegram Bot API for Java. At the time of writing it supports all the features of the HTTP API and follows the same specification. This is a work in progress and currently has very minimal error handling and testing. Any methods or functionality outside of `pro.zackpollard.telegrambot.api.internal` package should remain as they are currently and should work as expected, anything inside the `internal` package is not guaranteed to work as expected and may yield unexpected results if used in a way that is not intended.

Here is an example of how to use this API:

```java

//Main Class
public class MyBot {

    public MyBot() {
    
        TelegramBot telegramBot = TelegramBot.login("APIKey");
        telegramBot.getEventsManager().register(new MyListener());
        
        //Thread would die, do something to keep it alive.
    }
}

//Listener class
public class MyListener implements Listener() {

    public void onTextMessageReceived(TextMessageReceivedEvent event) {

        event.getChat().sendMessage(SendableTextMessage.builder().message("You sent me a text based message!").replyTo(event.getMessage()).build(), telegramBot);
    }
}
```
## Deployment

Currently you can get the latest build of the API from [here.](http://ci.zackpollard.pro/job/JavaTelegram-Bot-API/lastSuccessfulBuild/pro.zackpollard.telegrambot.api$jtelegram-botapi/)  
Maven is used for dependency management and deployment, the API will soon be available on maven central for ease of implementation.

## Licensing

This project is licensed under the GPLv3 licence.
