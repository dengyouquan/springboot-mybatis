package com.hand.domain.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Table(name = "actor")
public class Actor extends BaseEntity {
    @Id
    @Column(name = "actor_id")
    private Short actorId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private List<Film> films;

    /**
     * @return actor_id
     */
    public Short getActorId() {
        return actorId;
    }

    /**
     * @param actorId
     */
    public void setActorId(Short actorId) {
        this.actorId = actorId;
    }

    /**
     * @return first_name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return last_name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "actorId=" + actorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", lastUpdate=" + getLastUpdate() +
                ", films=" + films +
                '}';
    }
}