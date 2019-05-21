package entity;

import javax.persistence.*;


@Entity
@Table(name = "video")
public class Video {
    @Id
    @Column(name = "id")
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "description", length = 64)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
