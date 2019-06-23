package hello.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
public class Movie implements Serializable,Comparable {
    public Movie() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer movieID;
    private String title;
    private String description;
    private int lengthInMinutes;
    private int minimumAge;
    private String startAtTime;
    private String fileName;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channelid")
    @JsonBackReference
    @NotFound(action = NotFoundAction.IGNORE)
    private Channel channel;

    public Movie(String title, String description, int lengthInMinutes, int minimumAge, String startAtTime, String fileName) {
        this.title = title;
        this.description = description;
        this.lengthInMinutes = lengthInMinutes;
        this.minimumAge = minimumAge;
        this.startAtTime = startAtTime;
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

    public String getStartAtTime() {
        return startAtTime;
    }

    public void setStartAtTime(String startAtTime) {
        this.startAtTime = startAtTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }



    @Override
    public int compareTo(Object o) {
        System.out.println("(Time.valueOf(startAtTime)).compareTo(Time.valueOf(((Movie)o).startAtTime)) = " + (Time.valueOf(startAtTime)).compareTo(Time.valueOf(((Movie)o).startAtTime)));
   return (Time.valueOf(startAtTime)).compareTo(Time.valueOf(((Movie)o).startAtTime));
    }


}


