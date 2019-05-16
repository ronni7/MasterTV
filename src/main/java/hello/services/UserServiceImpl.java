package hello.services;

import hello.entities.User;

import hello.repositories.UserRepository;

import hello.utilities.Channel;


import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    private ServerServiceImpl serverService;



    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

        List<Channel> mockList=new ArrayList<>();
        mockList.add(new Channel("33398e47yiajsdf",1));
        mockList.add(new Channel("asdasdasd7yiajsdf",2));
        mockList.add(new Channel("1232k4jn23kiajsdf",3));
        this.serverService =new ServerServiceImpl(mockList);

    }

    @Override
    public List<User> findAll() {
      return  userRepository.findAll();
    }

    @Override
    public User registerNewUser(User u) {
        u.setPassword(BCrypt.hashpw(String.valueOf(u.getPassword()),BCrypt.gensalt()).toCharArray());
        return userRepository.save(u);
    }

    @Override
    public boolean logUserIn(String login, char[] password) {

        ArrayList<User> list = new ArrayList<>(userRepository.findByLogin(login));
        for (User u: list)
            if (BCrypt.checkpw(String.valueOf(password), String.valueOf(u.getPassword())))
                return true;
return false;
    }


    @Override
    public String routeUserToChannelWithHyperlinkLink(String token, int channelID) {

        return serverService.getChannelHyperlink(channelID);
    }


  /*  private User getUserByValidationKey(String validationKey) {
        for (User user : userRepository.findAll())
            if (BCrypt.checkpw(validationKey, user.getValidationKey())) return user;
        return null;
    }

    @Override
    public boolean checkValidationKey(String validKey, String login) {
        User user = getUserByValidationKey(validKey);
        if (user != null && !user.getActivated() && user.getLogin().equals(login)) {
            user.setActivated(true);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public String registerNewUser(String name, String login, String nickname) {
        String generatedKey;
        KeyGenerator keyGenerator = new KeyGenerator();
        generatedKey = keyGenerator.generate(6);
        String encrypted = BCrypt.hashpw(generatedKey, BCrypt.gensalt());
        User u = new User(name, login, nickname, encrypted, false);
        userRepository.save(u);
        return generatedKey;
    }*/
}
