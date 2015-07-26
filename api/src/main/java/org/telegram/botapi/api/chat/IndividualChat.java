package org.telegram.botapi.api.chat;

import org.telegram.botapi.api.user.User;

/**
 * @author Zack Pollard
 */
public interface IndividualChat extends Chat {

    User getPartner();
}
