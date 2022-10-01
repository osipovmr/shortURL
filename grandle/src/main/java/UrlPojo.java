import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
//@Table (name = "url")
public class UrlPojo {
    @Id
    @Column
    private int id;
    @Column
    private String original_url;
    @Column
    private String hash;
    @Column
    private String createdAt;

    public UrlPojo(String original_url, String hash, String createdAt){
        this.original_url = original_url;
        this.hash = hash;
        this.createdAt = createdAt;
    }


    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getOriginal_url() {return original_url;}
    public void setOriginal_url(String original_url) {this.original_url = original_url;}

    public String getHash() {return hash;}
    public void setHash(String hash) {this.hash = hash;}

    public String getCreatedAt() {return createdAt;}
    public void setCreatedAt(String createdAt) {this.createdAt = createdAt;}

    @Override
    public String toString() {
        return "url{" +
                "id=" + id +
                ", original_url='" + original_url + '\'' +
                ", hash=" + hash +
                ", createdAt=" + createdAt +
                '}';
}}
