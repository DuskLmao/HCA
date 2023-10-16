package com.hca.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Chapters")
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String title;

    private String content;

    private Time ReleaseDate;

    private String View;

    @ManyToOne
    @JoinColumn(name = "comic_id")
    private Comic comic;

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

