package org.telegram.botapi.api.internal.chat.message.content;

import org.json.JSONObject;
import org.telegram.botapi.api.chat.message.content.ContactContent;
import org.telegram.botapi.api.chat.message.content.type.Contact;
import org.telegram.botapi.api.internal.chat.message.content.type.ContactImpl;

/**
 * @author Zack Pollard
 */
public class ContactContentImpl implements ContactContent {

    private final Contact content;

    private ContactContentImpl(JSONObject jsonObject) {

        this.content = ContactImpl.createContact(jsonObject);
    }

	public static ContactContent createContactContent(JSONObject jsonObject) {

		return jsonObject != null ? new ContactContentImpl(jsonObject) : null;
	}

    @Override
    public Contact getContent() {

        return content;
    }
}
