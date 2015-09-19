package pro.zackpollard.telegrambot.api.internal.chat.updates;

import org.json.JSONObject;
import pro.zackpollard.telegrambot.api.chat.message.Message;
import pro.zackpollard.telegrambot.api.internal.chat.message.MessageImpl;
import pro.zackpollard.telegrambot.api.updates.Update;

/**
 * @author Zack Pollard
 */
public class UpdateImpl implements Update {

	private final int update_id;
	private final Message message;

	private UpdateImpl(JSONObject jsonObject) {

		this.update_id = jsonObject.getInt("update_id");
		this.message = MessageImpl.createMessage(jsonObject.getJSONObject("message"));
	}

	public static Update createUpdate(JSONObject jsonObject) {

		return new UpdateImpl(jsonObject);
	}

	@Override
	public int getId() {

		return update_id;
	}

	@Override
	public Message getMessage() {

		return message;
	}
}
