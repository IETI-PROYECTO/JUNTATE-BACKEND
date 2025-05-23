package escuelaing.edu.co.juntate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "events")
public class Event {

    @Id
    private String id;
    private String name;
    private String gameType;
    private String location; 
    private Date creationDate;
    private Date expirationDate;
    private int numberOfPlayers;

    public Event() {}

    public Event(String name, String gameType, String location, Date creationDate, Date expirationDate, int numberOfPlayers) {
        this.name = name;
        this.gameType = gameType;
        this.location = location;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.numberOfPlayers = numberOfPlayers;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getGameType() {
        return gameType;
    }
    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
