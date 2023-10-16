package com.hca.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "publisher")
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
