package com.example.albumCollection.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String Title;

    @Column(name = "artist")
    private String Artist;

    @Column(name = "year")
    private int Year;

    @Column(name = "genre")
    private String Genre;

    @Column(name = "rating")
    private Integer Rating;



    public Album() {
    }


    public Album(String title, String artist, int year, String genre, Integer rating) {
        Title = title;
        Artist = artist;
        Year = year;
        Genre = genre;
        Rating = rating;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }


    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        if (year > 2024) {
            throw new IllegalArgumentException();
        }
        Year = year;
    }


    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Integer getRating() {
        return Rating;
    }

    public void setRating(Integer rating) {
        if (rating != null && (rating < 0 || rating > 10)) {
            throw new IllegalArgumentException();
        }
        Rating = rating;
    }

}
