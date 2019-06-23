package hello.services;

import hello.entities.Channel;
import hello.repositories.ChannelRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChannelServiceImpl implements ChannelService {
    private ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public Channel save(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel getChannelByChannelID(int channelID) {
        return channelRepository.findByChannelID(channelID);
    }
}
