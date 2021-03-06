package hello.services;

import hello.entities.Channel;

import java.util.List;

public interface ChannelService {
    List<Channel> getAllChannels();

    Channel save(Channel channel);

    Channel getChannelByChannelID(int channelID);

    void deleteChannelByChannelID(int channelID);
}
