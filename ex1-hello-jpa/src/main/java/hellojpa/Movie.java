package hellojpa;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
//default는 엔티티명이고 이거를 해야지 DTYPE에 어떻게 들어갈지 정할수 있음
@DiscriminatorValue("M")
public class Movie extends Item{

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    private String actor;
}
