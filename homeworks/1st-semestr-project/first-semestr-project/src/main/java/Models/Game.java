package Models;

import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Objects;

public class Game {
    private Integer id;
    private String title;
    private String genre;
    private String description;
    private Integer price;
    private byte[] image;
    private String imageName;

    public Game(String title, String genre, String description, Integer price, byte[] image, String imageName) {
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.image = image;
        this.imageName = imageName;

    }

    public Game(Integer id, String title, String genre, String description, Integer price, String imageName, byte[] image) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.description = description;
        this.price = price;
        this.image = image;
        this.imageName = imageName;
    }

    public Game() {
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", imageName='" + imageName + '\'' +
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (!id.equals(game.id)) return false;
        if (!Objects.equals(title, game.title)) return false;
        if (!Objects.equals(genre, game.genre)) return false;
        if (!Objects.equals(description, game.description)) return false;
        if (!price.equals(game.price)) return false;
        if (!Arrays.equals(image, game.image)) return false;
        return Objects.equals(imageName, game.imageName);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + price.hashCode();
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + (imageName != null ? imageName.hashCode() : 0);
        return result;
    }
}
