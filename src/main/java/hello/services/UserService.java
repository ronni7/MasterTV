package hello.services;

import hello.entities.User;
import hello.entities.dataObjects.UserLoggedDTO;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User registerNewUser(User u);

    UserLoggedDTO logUserIn(String login, char[] password);


    String routeUserToChannelWithHyperlinkLink(String token, int channelID);

}
