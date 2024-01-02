import com.google.gson.annotations.SerializedName;

public class Movie {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setDuration(int year) {
        this.year = year;
    }
    @SerializedName("Title")
    private String name;
    @SerializedName("Director")
    private String director;
    @SerializedName("Year")
    private int year;


}