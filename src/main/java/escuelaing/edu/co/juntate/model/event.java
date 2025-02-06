package escuelaing.edu.co.juntate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document(collection = "events")
public class Event {

    @Id
    private String id;
    private String name;
    private String gameType;
    private Arena location; // Referencia embebida a Arena
    private LocalDateTime creationDate;
    private LocalDateTime expirationDate;
    private int numberOfPlayers;

    // Constructor vacío y con parámetros
    public Event() {}
    public Event(String name, String gameType, Arena location, LocalDateTime creationDate, LocalDateTime expirationDate, int numberOfPlayers) {
        this.name = name;
        this.gameType = gameType;
        this.location = location;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.numberOfPlayers = numberOfPlayers;
    }

    // Getters y setters
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

    public Arena getLocation() {
        return location;
    }
    public void setLocation(Arena location) {
        this.location = location;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
}
