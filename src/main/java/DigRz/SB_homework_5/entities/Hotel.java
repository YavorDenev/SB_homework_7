package DigRz.SB_homework_5.entities;

import javax.persistence.*;

@Entity
public class Hotel {     //име, курорт, брой стаи, брой звезди, има ли СПА
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "resort_id", nullable = false)
    private Resort resort;

    @Column(nullable = false)
    private Integer roomsCount;

    @Column(nullable = false)
    private Integer starsCount;

    @Column(nullable = false)
    private Boolean hasSpa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Resort getResort() {
        return resort;
    }

    public void setResort(Resort resort) {
        this.resort = resort;
    }

    public Integer getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(Integer roomsCount) {
        this.roomsCount = roomsCount;
    }

    public Integer getStarsCount() {
        return starsCount;
    }

    public void setStarsCount(Integer starsCount) {
        this.starsCount = starsCount;
    }

    public Boolean getHasSpa() {
        return hasSpa;
    }

    public void setHasSpa(Boolean hasSpa) {
        this.hasSpa = hasSpa;
    }

}
