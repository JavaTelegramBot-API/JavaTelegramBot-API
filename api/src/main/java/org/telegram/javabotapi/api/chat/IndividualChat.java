package org.telegram.javabotapi.api.chat;

import org.telegram.javabotapi.api.user.User;

/**
 * @author Zack Pollard
 */
public interface IndividualChat extends Chat {

    User getPartner();
}
