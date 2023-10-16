package com.hca.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "categories")
    private Set<Comic> comics = new HashSet<>();

    @CreationTimestamp
    private Timestamp createdAt;

    @CreationTimestamp
    private Timestamp updateAt;

    @CreationTimestamp
    private Timestamp deletedAt;

    private boolean isDeleted;

    private Long creatorUserID;

    private Long updaterUserID;

    private Long deleterUserID;
}
