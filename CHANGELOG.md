# Changelog
#### Version 0.2.1
* Made the from field in the Message type optional due to channels not providing that field.
  * Thanks for mentioning you were changing that in your changelog Telegram.

#### Version 0.2
* Implemented Channels (Telegram HTTP API Updated on 8/10/2015)
  * This required changing the Chat#getID() method to return a String rather than an int, this will break some bots if this method was used.

#### Version 0.1
* First Alpha Release
  * Includes all features excluding the webhook message request method
