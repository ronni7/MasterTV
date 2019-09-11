package hello.entities.dataObjects;

import hello.entities.Channel;

public class MovieDTO {
    private Integer id;
    private String title;
    private String description;
    private String startAtTime;
    private int lengthInMinutes;
    private int minimumAge;
    private Channel channelID;

    public MovieDTO(Integer id, String title, String description, String startAtTime, int lengthInMinutes, int minimumAge, Channel channelID) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startAtTime = startAtTime;
        this.lengthInMinutes = lengthInMinutes;
        this.minimumAge = minimumAge;
        this.channelID = channelID;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", lengthInMinutes=" + lengthInMinutes +
                ", minimumAge=" + minimumAge +
                '}';
    }

    public String getStartAtTime() {
        return startAtTime;
    }

    public void setStartAtTime(String startAtTime) {
        this.startAtTime = startAtTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Channel getChannelID() {
        return channelID;
    }

    public void setChannelID(Channel channelID) {
        this.channelID = channelID;
    }
}
