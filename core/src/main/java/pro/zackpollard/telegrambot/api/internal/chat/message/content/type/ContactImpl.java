package pro.zackpollard.telegrambot.api.internal.chat.message.content.type;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.content.type.Contact;

/**
 * @author Zack Pollard
 */
public class ContactImpl implements Contact {

    private final String phone_number;
    private final String first_name;
    private final String last_name;
    private final int user_id;

    private ContactImpl(JSONObject jsonObject) {

        this.phone_number = jsonObject.getString("phone_number");
        this.first_name = jsonObject.getString("first_name");
        this.last_name = jsonObject.optString("last_name");
        this.user_id = jsonObject.optInt("user_id");
    }

    public static Contact createContact(JSONObject jsonObject) {

        return jsonObject != null ? new ContactImpl(jsonObject) : null;
    }

    @Override
    public String getPhoneNumber() {

        return phone_number;
    }

    @Override
    public String getFirstName() {

        return first_name;
    }

    @Override
    public String getLastName() {

        return last_name;
    }

    @Override
    public int getUserId() {

        return user_id;
    }
}