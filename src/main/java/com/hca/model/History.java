package com.hca.model;


import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime readDateTime;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne
//    @JoinColumn(name = "comic_id")
//    private Comic comic;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    private Timestamp deletedAt;

    private boolean isDeleted;

    private Long creatorUserID;

    private Long updaterUserID;

    private Long deleterUserID;

}
