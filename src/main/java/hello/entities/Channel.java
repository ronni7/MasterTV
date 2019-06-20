package hello.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Channel implements Serializable {
    public Channel() {
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int channelID;
    private String hyperlink;
    @OneToMany
    @JoinColumn(name = "movieID")
    @OrderBy(value = "channelID")
    private List<Movie> playlist;
    private String startsAtTime;

    public Channel(String hyperlink, List<Movie> playlist, String startsAtTime) {
        this.hyperlink = hyperlink;
        this.playlist = playlist;
        this.startsAtTime = startsAtTime;
    }


    public int getChannelID() {
        return channelID;
    }

    public void setChannelID(int channelID) {
        this.channelID = channelID;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }

    public List<Movie> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Movie> playlist) {
        this.playlist = playlist;
    }

    public String getStartsAtTime() {
        return startsAtTime;
    }

    public void setStartsAtTime(String startsAtTime) {
        this.startsAtTime = startsAtTime;
    }

    @Override
    public String toString() {
        return "Channel{" +
                "channelID=" + channelID +
                ", hyperlink='" + hyperlink + '\'' +
                ", playlist=" + playlist +
                ", startsAtTime='" + startsAtTime + '\'' +
                '}';
    }
}
