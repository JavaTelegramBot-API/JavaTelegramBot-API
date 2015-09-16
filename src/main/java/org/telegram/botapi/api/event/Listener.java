package org.telegram.botapi.api.event;

import org.telegram.botapi.api.event.chat.*;
import org.telegram.botapi.api.event.chat.message.*;

/**
 * @author DarkSeraphim.
 */
public interface Listener {

	default void on(AudioMessageReceivedEvent e) {
	}
	default void on(ContactMessageReceivedEvent e) {
	}
	default void on(DocumentMessageReceivedEvent e) {
	}
	default void on(LocationMessageReceivedEvent e) {
	}
	default void on(MessageReceivedEvent e) {
	}
	default void on(PhotoMessageReceivedEvent e) {
	}
	default void on(StickerMessageReceivedEvent e) {
	}
	default void on(TextMessageReceivedEvent e) {
	}
	default void on(VideoMessageReceivedEvent e) {
	}
	default void on(VoiceMessageReceivedEvent e) {
	}

	default void on(DeleteGroupChatPhotoEvent e) {
	}
	default void on(GroupChatCreatedEvent e) {
	}
	default void on(NewGroupChatPhotoEvent e) {
	}
	default void on(NewGroupChatTitleEvent e) {
	}
	default void on(ParticipantJoinGroupChatEvent e) {
	}
	default void on(ParticipantLeaveGroupChatEvent e) {
	}
}