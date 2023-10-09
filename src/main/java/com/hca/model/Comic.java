package com.hca.model;

import lombok.*;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Comics")
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String Description;
    private String Status;
    private String Likes;

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    @OneToMany(mappedBy = "comic")
    private Set<Chapter> chapters = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "comic_category",
            joinColumns = @JoinColumn(name = "comic_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "comic")
    private Set<Rating> ratings = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "user_favourite",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "comic_id")
    )
    private Set<Comic> favourites = new HashSet<>();
    //history
    @OneToMany(mappedBy = "comic")
    private Set<History> readingHistory = new HashSet<>();
}
