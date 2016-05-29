# Changelog
#### Version 1.2.2
* Fixed issue where the API would error when a message was forwarded from a channel
* Added SuperGroupChat#getUsername() as it was missing and is in the spec

#### Version 1.2.1
* Fixed StackOverflowException with TelegramBot#getChat(long)

#### Version 1.2.0
* Added receiving of edited messages
  * New event MessageEditReceivedEvent
* Changed TelegramBot#getChat(String chatID) to use new getChat endpoint from the API
* Implemented Chat#getChatMembersCount()
* Implemented new ChatMember object type
* Implemented Chat#getChatAdministrators()
* Implemented Chat#getChatMember(User/long user)
* Implemented Chat#leaveChat()
* Implemented Message#getEditDate()
* Implemented MessageEntity changes
  * Added MessageEntityType.TEXT_MENTION
  * Added MessageEntity#getUser() for when the type is a mention of a user
* Bugfixes
  * Fixed an issue with Message#getForwardedDate and Message#getTimeStamp() being an int instead of a long
* Other changes
  * Internal restructure of utility methods, they are now in their rightful home, in the Utils class

#### Version 1.1.1
* Fixed forward_from_chat causing an error when it isn't populated

#### Version 1.1.0
* Added Sticker#getEmoji() to meet new API spec
* Added Message#getChatForwardedFrom() to meet new API spec

#### Version 1.0.1
* Bugfix
  * Edited the builder name in InlineQueryResultCacheAudio to include the Cached keyword

#### Version 1.0.0
* Bots 2.0 Update
  * Implemented new CallbackQuery response type in Update object
    * Three events added for this: CallbackQueryReceivedEvent, InlineCallbackQueryReceivedEvent, MessageCallbackQueryReceivedEvent
  * Implemented new MessageEntity object type into a received message with TextContent type
    * You can get access to the MessageEntity's using TextMessageReceivedEvent#getContent()#getEntities()
  * Changed new_chat_participant and left_chat_participant to new_chat_member and left_chat_member respectively
  * Implemented new Venue object type and added it as a new content type for received Message's
  * Implemented new content type pinned_message in Message object
  * Added KeyboardButton and switched ReplyKeyboardMarkup to use KeyboardButton instead of String
  * Added InlineKeyboardButton and InlineKeyboardMarkup for the new inline keyboard functionality
  * Updated TelegramBot#sendMessage to support the new InlineKeyboardMarkup keyboards
  * Added support for sendVideo to handle width, height and duration
  * Added SendableVenueMessage to support sending Venue message types
  * Implemented kickChatMember into GroupChat and SuperGroupChat
  * Implemented unbanChatMember into SuperGroupChat
  * Implemented answerCallbackQuery into CallbackQuery
  * Implemented editMessageText function into TelegramBot for editing inline and normal messages with text content
  * Implemented editMessageReplyMarkup function into TelegramBot for editing ReplyMarkup for any type of inline or normal message
  * Implemented editMessageCaption function into TelegramBot for editing captions for any type of inline or normal message
  * Updated InlineQuery object to add the new Location field
  * Implemented answerInlinequery changes into the InlineQueryResponse object
  * Added the new InputMessageContent objects for use when sending inline messages
  * Updated the current InlineQueryResult objects to follow the new API spec and use the InputMessageContent objects
  * Implemented all new and changed InlineQueryResult objects
  * Implemented location and inline_message_id into ChosenInlineResult
* Bugfix:
  * Added missing caption to Document content type for received Message's
  * Fixed an incorrect method name and empty method in ReplyKeyboardMarkup
  * Fixed a bug where duration was never sent with a voice message, even when it was provided
* Changes:
  * Chats now contain an instance of TelegramBot within them
    * TelegramBot.getChat(long/String) is now TelegramBot#getChat(long/String) and therefore requires an instance of TelegramBot to use
    * Chat#sendMessage(SendableMessage/String, TelegramBot) is now Chat#sendMessage(SendableMessage/String)
  * Message IDs are now stored as a long instead of an int
    * This change is being made solely as a precaution for very large chats where message counts could get very high in the long term
  * Make SuperGroupChat extend GroupChat instead of Chat
  * Removed deprecated ReplyKeyboardMarkup String based methods to be replaced with KeyboardButton methods
  * Added in toString methods to all classes and builders that should have them
    * This will make debugging easier and allow bug reports to be more informative
    
   
#### Version 0.8.3
* Added checks to avoid errors with cacheing if the servers responds with an unexpected content type

#### Version 0.8.2
* Fixed a bug where the ChannelChatCreatedEvent wasn't ever fired
* Changed all public Constructors with Builder counterparts to private to reduce the amount of breaking changes in future updates 

#### Version 0.8.1
* Added support for giving documents captions as this is now supported in the Telegram API

#### Version 0.8.0
* Added support for disabling notifications for  receivers when sending messages

#### Version 0.7.8
* Changed MessageReceivedEvent so that it only fires when a "Message" is received, not when inline queries are received

#### Version 0.7.7
* Added a Chat#getName() method, for groups it returns the group name, for private chats it returns the users full name
* Bugfix:
  * Change User#getId() to return a long instead of an int

#### Version 0.7.6
* Added support for the new HTML parse mode 
  * You can find information about it here https://core.telegram.org/bots/api#html-style

#### Version 0.7.5
* Removed random debug messages

#### Version 0.7.4
* Bugfixes:
  * TelegramBot#sendInlineQuery() would always return false, even if sending succeeded
  * InlineResultChosenEvent was never called and so the Chosen Result functionality was broken

#### Version 0.7.3
* Fixed an issue with ignoring previous updates when doing TelegramBot#startUpdates(false)
  * The issue was due to an inconsistency between the unix time on the server and telegrams servers which meant either some messages weren't ignored or messages were ignored long after startup
    * The clearing method no longer uses unix time so this is no longer an issue
    
#### Version 0.7.2
* Added Message#asJson(), InlineQuery#asJson() and ChosenInlineResult#asJson()
  * These methods simply return a JSONObject of the json data that the TelegramAPI originally sent to the API

#### Version 0.7.1
* Implemented extra Inline Bot functionality
  * Re-implemented the ChosenInlineResult function that was removed from the API spec originally
    * To use this functionality you must enable it from @BotFather by typing /setinlinefeedback

#### Version 0.7.0
* Implemented Inline Bot functionality
  * Implementing this has two simple steps
    * 1.) Listen to the InlineQueryReceivedEvent
    * 2.) Use the answer method within this event to reply to the request

#### Version 0.6.5
* Bugfix: TelegramBot.getChat(String chatID) wasn't accepting supergroup IDs as they are to long for Integer conversion

#### Version 0.6.4
* Bugfix: Replies would not work on un-cached files

#### Version 0.6.3
* Adding replies to SendableMessages and ForwardedMessage can be done with IDs as well as with Message objects now

#### Version 0.6.2
* Bugfix: SuperGrouChat objects were broken when receiving messages due to hitting the integer limit at one point down the chain

#### Version 0.6.1
* Added events for new Message types that were implemented
  * ChannelChatCreatedEvent
  * MigrateFromChatEvent
  * MigrateToChatEvent
  * SuperGroupChatCreatedEvent
* Added in TelegramBot.getChat(long chatID) to replace TelegramBot.getChat(int chatID) which has now been deprecated

#### Version 0.6
* Added support for supergroups.
  * Extra ChatType in Chat object.
  * Extra fields (Content Types) in the Message object.
  
#### Version 0.5.1
* Bugfix: If you used ReplyKeyboardMarkup.builder().addRow(List<String> cellValues) duplication of values could occur.
  * This would happen if the same list was used and cleared for each addRow(List<String>) call that was made.
  
#### Version 0.5
* Provided API key is now checked to see if it's invalid.
  * TelegramBot.login(String key) will return null if the key is invalid and will print an error to the console.
* Bugfix: When the API returns a status code other than 200, the bot will print out a more detailed error if one is available.

#### Version 0.4.5
* Bugfix: When sending a file via URL without GET variables in the URL, the API would throw an error.

#### Version 0.4.4
* Bugfix: Sometimes when sending a document, the API will return an audio message if it detects the sent file was MPEG-3 format.

#### Version 0.4.3
* Bugfix: Proper handling for occasions were the API returns non-json responses.
* Bugfix: Fixed an issue where URL InputFiles would not send correctly due to variables at the end of the URL.

#### Version 0.4.1
* Bugfix: In version 0.4.0 sending any messages without specifying the parse mode would result in a NullPointerException, this has now been corrected.

#### Version 0.4.0
* Feature: Added ability to use markdown in messages as specified in the API here https://core.telegram.org/bots/api#using-markdown
  * You can do this for SendableTextMessage's by setting the parse mode to ParseMode.MARKDOWN.
  * This feature is currently only supported by a few clients such as the android client, desktop client does not have support just yet.

#### Version 0.3.3
* Bugfix: Change URL InputFiles download location to the system temporary file directory to fix issues with detecting jar folder when using the API.
  * Will make the temp folder configurable in future versions.

#### Version 0.3.2
* Bugfix: Force telegram to use the correct filename for files downloaded through this API.

#### Version 0.3.1
* Bugfix: Catch any errors that occur during events as to not break incoming updates.

#### Version 0.3.0
* Supported downloading files from URL for sending in messages.
  * Added InputFile(URL url) to support this.
  * Automatic cacheing of downloaded files is implemented.
#### Version 0.2.5
* Added in more error handling to stop Exceptions being thrown when sending Photo/Audio/Document/Sticker/Video/Voice message types and the sending fails for some reason.

#### Version 0.2.4
* Bugfix: Made user_id optional in Contact content type to fix an error when a user_id is not included in the reply due to the contact not being a Telegram contact.

#### Version 0.2.3
* Added error handling to message sending, the API will no longer throw JSON errors and will print out a nice description of the error.
* Added error printing to the Update Manager so that it doesn't just fail silently if the telegram API is erroring.
* Fixed error when TelegramBot.getChat(String chatID) was provided with a null or zero-length chatID.

#### Version 0.2.2
* Fixed ChannelChat#sendMessage() always returning null and not sending the message.

#### Version 0.2.1
* Made the from field in the Message type optional due to channels not providing that field.
  * Thanks for mentioning you were changing that in your changelog Telegram.

#### Version 0.2
* Implemented Channels (Telegram HTTP API Updated on 8/10/2015)
  * This required changing the Chat#getID() method to return a String rather than an int, this will break some bots if this method was used.

#### Version 0.1
* First Alpha Release
  * Includes all features excluding the webhook message request method
