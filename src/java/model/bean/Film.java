package model.bean;


public class Film {
    
    private int film_id;
    private String title;
    private String description;
    private int release_year;

    public Film() {
    }

    public Film(int film_id, String title, String description, int release_year) {
        this.film_id = film_id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
    }

    public int getFilm_id() {
        return film_id;
    }

    public void setFilm_id(int film_id) {
        this.film_id = film_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    
    
    
    
}
