package hello.services;

import hello.utilities.Channel;


import java.util.List;


public class ServerServiceImpl implements ServerService {
    private List<Channel> hyperlinks;

    public ServerServiceImpl(List<Channel> hyperlinks) {
        this.hyperlinks = hyperlinks;
    }

    @Override
    public String getChannelHyperlink(int channelID) {
       return hyperlinks.stream().filter(channel -> channel.getID()==channelID).findFirst().get().getHyperlink();
    }
}
