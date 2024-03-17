package jh.naverwebtoon.db.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jh.naverwebtoon.db.domain.enums.GenreEnum;

@Entity
public class Genre {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id ")
    private Long id;

    @Enumerated(EnumType.STRING)
    private GenreEnum genreEnum;

    public static Genre create(GenreEnum genreEnum) {
        Genre genre = new Genre();
        genre.genreEnum = genreEnum;
        return genre;
    }
}
