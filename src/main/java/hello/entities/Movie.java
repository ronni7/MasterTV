package hello.entities;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Movie implements Serializable {
    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieID;
    private String title;
    private String description;
    private int lengthInMinutes;
    private int minimumAge;
    private String fileName;
    @ManyToOne
    @JoinColumn(name = "channelID")
    private Channel channel;

    public Movie(String title, String description, int lengthInMinutes, int minimumAge, String fileName) {
        this.title = title;
        this.description = description;
        this.lengthInMinutes = lengthInMinutes;
        this.minimumAge = minimumAge;
        this.fileName = fileName;
    }

    public Integer getMovieID() {
        return movieID;
    }

    public void setMovieID(Integer movieID) {
        this.movieID = movieID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLengthInMinutes() {
        return lengthInMinutes;
    }

    public void setLengthInMinutes(int lengthInMinutes) {
        this.lengthInMinutes = lengthInMinutes;
    }

    public int getMinimumAge() {
        return minimumAge;
    }

    public void setMinimumAge(int minimumAge) {
        this.minimumAge = minimumAge;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + movieID +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                ", minimumAge=" + minimumAge +
                ", fileName='" + fileName + '\'' +
                '}';
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
