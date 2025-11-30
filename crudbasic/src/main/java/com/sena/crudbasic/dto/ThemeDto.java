package com.sena.crudbasic.dto;

public class ThemeDto {

    private int idTheme;
    private String themeName;

    
    public ThemeDto() {}

    public ThemeDto(int idTheme, String themeName) {
        this.idTheme = idTheme;
        this.themeName = themeName;
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
}