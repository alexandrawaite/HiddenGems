package me.alex;

public class Artist {
    private int id;
    private String name;
    private String country;
    private String genre;
    private String bio;

    public Artist() {  }

    public Artist(int id, String name, String country, String genre, String bio) {
        this.setId(id);
        this.setName(name);
        this.setCountry(country);
        this.setGenre(genre);
        this.setBio(bio);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    @Override
    public String toString() {
        return "Artist {" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", country=" + country + '\'' +
                ", genre=" + genre + '\'' +
                ", bio=" + bio + '\'' +
                "}";
    }
}
