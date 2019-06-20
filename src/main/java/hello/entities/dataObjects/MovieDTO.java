package hello.entities.dataObjects;

public class MovieDTO {
    private Integer id;
    private String title;
    private String description;
    private int lengthInMinutes;
    private int minimumAge;

    public MovieDTO(Integer id, String title, String description, int lengthInMinutes, int minimumAge) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lengthInMinutes = lengthInMinutes;
        this.minimumAge = minimumAge;
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
}
