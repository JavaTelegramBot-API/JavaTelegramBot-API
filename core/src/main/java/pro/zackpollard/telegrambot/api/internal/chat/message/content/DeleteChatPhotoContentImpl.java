package pro.zackpollard.telegrambot.api.internal.chat.message.content;

import pro.zackpollard.telegrambot.api.chat.message.content.DeleteChatPhotoContent;

/**
 * @author Zack Pollard
 */
public class DeleteChatPhotoContentImpl implements DeleteChatPhotoContent {

    private DeleteChatPhotoContentImpl() {
    }

    public static DeleteChatPhotoContent createDeleteChatPhotoContent() {

        return new DeleteChatPhotoContentImpl();
    }
}
