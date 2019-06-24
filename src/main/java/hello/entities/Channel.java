package hello.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Channel implements Serializable {
    public Channel() {

    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int channelID;
    private String hyperlink;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "channel",cascade=CascadeType.ALL,fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JsonManagedReference
    @OrderBy(value = "startAtTime")
    private List<Movie> playlist = new ArrayList<>();

    public Channel(String hyperlink, String name) {
        this.hyperlink = hyperlink;
        this.name = name;
    }

    public void addMovieToPlaylist(Movie movie) {
        movie.setChannel(this);
        this.playlist.add(movie);

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

    @Override
    public String toString() {
        return "Channel{" +
                "channelID=" + channelID +
                ", hyperlink='" + hyperlink + '\'' +
                ", name='" + name + '\'' +
                ", playlist=" + playlist +
                '}';
    }
}
