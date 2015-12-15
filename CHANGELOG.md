# Changelog
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
