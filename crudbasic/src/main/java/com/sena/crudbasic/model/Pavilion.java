package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity(name = "pavilion")
public class Pavilion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pavilion")
    private int idPavilion;

    @Column(name = "name", length = 60)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_theme")
    private Theme theme;

    @ManyToOne
    @JoinColumn(name = "id_fair")
    private Fair fair;

    @OneToMany(mappedBy = "pavilion")
    private List<Stand> stands;

    public Pavilion(int idPavilion, String name, Theme theme, Fair fair, List<Stand> stands) {
        this.idPavilion = idPavilion;
        this.name = name;
        this.theme = theme;
        this.fair = fair;
        this.stands = stands;
    }

    public Pavilion() {
    }

    public int getIdPavilion() {
        return idPavilion;
    }

    public void setIdPavilion(int idPavilion) {
        this.idPavilion = idPavilion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public Fair getFair() {
        return fair;
    }

    public void setFair(Fair fair) {
        this.fair = fair;
    }

    public List<Stand> getStands() {
        return stands;
    }

    public void setStands(List<Stand> stands) {
        this.stands = stands;
    }
}