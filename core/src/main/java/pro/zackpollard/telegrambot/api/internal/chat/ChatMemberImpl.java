package pro.zackpollard.telegrambot.api.internal.chat;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.ChatMember;
import pro.zackpollard.telegrambot.api.chat.ChatMemberStatus;
import pro.zackpollard.telegrambot.api.internal.user.UserImpl;
import pro.zackpollard.telegrambot.api.user.User;

/**
 * @author Zack Pollard
 */
public class ChatMemberImpl implements ChatMember {

    private final User user;
    private final ChatMemberStatus status;
    private final Long until_date;
    private final boolean can_be_edited;
    private final boolean can_change_info;
    private final boolean can_post_messages;
    private final boolean can_edit_messages;
    private final boolean can_delete_messages;
    private final boolean can_invite_users;
    private final boolean can_restrict_members;
    private final boolean can_pin_messages;
    private final boolean can_promote_members;
    private final boolean can_send_messages;
    private final boolean can_send_media_messages;
    private final boolean can_send_other_messages;
    private final boolean can_add_web_page_previews;


    private ChatMemberImpl(JSONObject jsonObject) {

        this.user = UserImpl.createUser(jsonObject.getJSONObject("user"));
        this.status = ChatMemberStatus.getType(jsonObject.getString("status"));
        this.until_date = jsonObject.optLong("until_date");
        this.can_be_edited = jsonObject.optBoolean("can_be_edited");
        this.can_change_info = jsonObject.optBoolean("can_change_info");
        this.can_post_messages = jsonObject.optBoolean("can_post_messages");
        this.can_edit_messages = jsonObject.optBoolean("can_edt_messages");
        this.can_delete_messages = jsonObject.optBoolean("can_delete_messages");
        this.can_invite_users = jsonObject.optBoolean("can_invite_users");
        this.can_restrict_members = jsonObject.optBoolean("can_restrict_members");
        this.can_pin_messages = jsonObject.optBoolean("can_pin_members");
        this.can_promote_members = jsonObject.optBoolean("can_promote_members");
        this.can_send_messages = jsonObject.optBoolean("can_send_messages");
        this.can_send_media_messages = jsonObject.optBoolean("can_send_media_messages");
        this.can_send_other_messages = jsonObject.optBoolean("can_send_other_messages");
        this.can_add_web_page_previews = jsonObject.optBoolean("can_add_web_page_previews");
    }

    public static ChatMember createChatMember(JSONObject jsonObject) {

        return new ChatMemberImpl(jsonObject);
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public ChatMemberStatus getStatus() {
        return status;
    }

    @Override
    public Long getUntilDate() {
        return until_date;
    }

    @Override
    public boolean getCanBeEdited() {
        return can_be_edited;
    }

    @Override
    public boolean getCanChangeInfo() {
        return can_change_info;
    }

    @Override
    public boolean getCanPostMessages() {
        return can_post_messages;
    }

    @Override
    public boolean getCanEditMessages() {
        return can_edit_messages;
    }

    @Override
    public boolean getCanDeleteMessages() {
        return can_delete_messages;
    }

    @Override
    public boolean getCanInviteUsers() {
        return can_invite_users;
    }

    @Override
    public boolean getCanRestrictMembers() {
        return can_restrict_members;
    }

    @Override
    public boolean getCanPinMessages() {
        return can_pin_messages;
    }

    @Override
    public boolean getCanPromoteMembers() {
        return can_promote_members;
    }

    @Override
    public boolean getCanSendMessages() {
        return can_send_messages;
    }

    @Override
    public boolean getCanSendMediaMessages() {
        return can_send_media_messages;
    }

    @Override
    public boolean getCanSendOtherMessages() {
        return can_send_other_messages;
    }

    @Override
    public boolean getCanAddWebPagePreviews() {
        return can_add_web_page_previews;
    }
}
