package com.hca.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

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
