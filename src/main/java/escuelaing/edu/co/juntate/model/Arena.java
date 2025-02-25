package escuelaing.edu.co.juntate.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "arenas")
public class Arena {

    @Id
    private String id;
    private String neighborhood;
    private String address;
    private String image;
    private List<String> sportsTypes;
    private List<String> images;


    public Arena() {}

    public Arena(String neighborhood,String address, String image, List<String> sportsTypes, List<String> images) {
        this.neighborhood = neighborhood;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}