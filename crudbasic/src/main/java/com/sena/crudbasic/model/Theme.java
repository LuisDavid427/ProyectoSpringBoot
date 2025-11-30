package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity(name = "theme")
public class Theme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_theme")
    private int idTheme;

    @Column(name = "theme_name", length = 20)
    private String themeName;

    @OneToMany(mappedBy = "theme")
    private List<Pavilion> pavilions;

    public Theme() {
    }

    public Theme(int idTheme, String themeName, List<Pavilion> pavilions) {
        this.idTheme = idTheme;
        this.themeName = themeName;
        this.pavilions = pavilions;
    }

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public List<Pavilion> getPavilions() {
        return pavilions;
    }

    public void setPavilions(List<Pavilion> pavilions) {
        this.pavilions = pavilions;
    }
}