package escuelaing.edu.co.juntate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "arenas")
public class Arena {

    @Id
    private String id;
    private double latitude;
    private double longitude;
    private String neighborhood;
    private String image;
    private List<String> sportsTypes;
    private List<String> images;

    public Arena() {}

    public Arena(double latitude, double longitude, String neighborhood, String image, List<String> sportsTypes, List<String> images) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.neighborhood = neighborhood;
        this.image = image;
        this.sportsTypes = sportsTypes;
        this.images = images;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getSportsTypes() {
        return sportsTypes;
    }

    public void setSportsTypes(List<String> sportsTypes) {
        this.sportsTypes = sportsTypes;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }
}