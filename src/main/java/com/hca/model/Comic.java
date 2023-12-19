package com.hca.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
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

    public Comic(BigInteger id) {
        this.id = id.longValue();
    }
    public String name;
    private String description;
    private String status;
    private String likes;
    private String thumbnail;

    @CreationTimestamp
    @JoinColumn(name = "created_at")
    private Timestamp createdAt;

    @UpdateTimestamp
    @JoinColumn(name = "updated_at")
    private Timestamp updatedAt;

    @JoinColumn(name = "deleted_at")
    private Timestamp deletedAt;

    private boolean isDeleted;
}
