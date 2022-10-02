import jakarta.persistence.*;

@Entity
@Table(name = "url")
public class UrlEntity {

    private int id;
    private String original_url;
    private String hash;
    private String createdAt;

    public UrlEntity() {
    }

    UrlEntity(String original_url, String hash, String createdAt){
        this.original_url = original_url;
        this.hash = hash;
        this.createdAt = createdAt;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @jakarta.persistence.Column

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @jakarta.persistence.Column
    public String getOriginal_url() {
        return original_url;
    }

    public void setOriginal_url(String original_url) {
        this.original_url = original_url;
    }

    @jakarta.persistence.Column
    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    @Column
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "url{" +
                "id= " + id +
                ", original_url = '" + original_url + '\'' +
                ", hash = " + hash +
                ", createdAt = " + createdAt +
                '}';
    }
}
