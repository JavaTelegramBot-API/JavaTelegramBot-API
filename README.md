# Java Telegram Bot API

Telegram Channel for this API available at https://telegram.me/javatelegrambotapi   
Please join this channel for information about updates to this bot.   
You can also contact me at https://telegram.me/zackpollard   
If you need help in Persian(فارسی) you can contact https://telegram.me/aaomidi

This is a Telegram Bot API for Java. At the time of writing it supports all the features of the HTTP API and follows the same specification. This is a work in progress and currently has very minimal error handling and testing. Any methods or functionality outside of `pro.zackpollard.telegrambot.api.internal` package should remain as they are currently and should work as expected, anything inside the `internal` package is not guaranteed to work as expected and may yield unexpected results if used in a way that is not intended.

Here is an example of how to use this API:

```java

//Main Class
public class MyBot {

    public MyBot() {
    
        TelegramBot telegramBot = TelegramBot.login("APIKey");
        telegramBot.getEventsManager().register(new MyListener());
        
        //This will tell the API to start polling the servers for updates
        //If you specify true as the argument you will receive any previous messages before the bot started.
        //If you specify false the API will discard any messages from before the bot was started.
        telegramBot.startUpdates(false);
        
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

The API is available on Maven or through the CI.
### Maven
Maven is used for dependency management and deployment.
```xml
<dependencies>
    <dependency>
        <groupId>pro.zackpollard.telegrambot.api</groupId>
        <artifactId>jtelegram-botapi</artifactId>
        <version>0.4.1</version>
    </dependency>
</dependencies>
```
### CI Builds
Latest Release Build [![Build Status](http://ci.zackpollard.pro/job/JavaTelegramBot-API/badge/icon)](http://ci.zackpollard.pro/job/JavaTelegram-Bot-API/)   
Latest Development Build [![Build Status](http://ci.zackpollard.pro/job/JavaTelegramBot-API%20Development%20Builds/badge/icon)](http://ci.zackpollard.pro/job/JavaTelegramBot-API%20Development%20Builds/)

## Licensing

This project is licensed under the GPLv3 licence.
