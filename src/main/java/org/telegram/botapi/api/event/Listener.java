package org.telegram.botapi.api.event;

import org.telegram.botapi.api.event.chat.*;
import org.telegram.botapi.api.event.chat.message.*;

/**
 * @author DarkSeraphim.
 */
public interface Listener {

	default void onAudioMessageReceived(AudioMessageReceivedEvent event) {
	}
	default void onContactMessageReceived(ContactMessageReceivedEvent event) {
	}
	default void onDocumentMessageReceived(DocumentMessageReceivedEvent event) {
	}
	default void onLocationMessageReceived(LocationMessageReceivedEvent event) {
	}
	default void onMessageReceived(MessageReceivedEvent event) {
	}
	default void onPhotoMessageReceived(PhotoMessageReceivedEvent event) {
	}
	default void onStickerMessageReceived(StickerMessageReceivedEvent event) {
	}
	default void onTextMessageReceived(TextMessageReceivedEvent event) {
	}
	default void onVideoMessageReceived(VideoMessageReceivedEvent event) {
	}
	default void onVoiceMessageReceived(VoiceMessageReceivedEvent event) {
	}

	default void onDeleteGroupChatPhoto(DeleteGroupChatPhotoEvent event) {
	}
	default void onGroupChatCreated(GroupChatCreatedEvent event) {
	}
	default void onNewGroupChatPhoto(NewGroupChatPhotoEvent event) {
	}
	default void onNewGroupChatTitle(NewGroupChatTitleEvent event) {
	}
	default void onParticipantJoinGroupChat(ParticipantJoinGroupChatEvent event) {
	}
	default void onParticipantLeaveGroupChat(ParticipantLeaveGroupChatEvent event) {
	}
}