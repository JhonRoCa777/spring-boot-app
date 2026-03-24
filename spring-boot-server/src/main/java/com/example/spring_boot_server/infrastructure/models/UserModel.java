package com.example.spring_boot_server.infrastructure.models;

import com.example.spring_boot_server.domain.enums.DocumentTypeEnum;
import com.example.spring_boot_server.domain.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String names;

    @Column(nullable = false)
    private String lastNames;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "document_type_enum")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private DocumentTypeEnum documentType;

    @Column(nullable = false)
    private String document;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "role_enum")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private RoleEnum role;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", updatable = false)
    private UUID createdById;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", insertable = false, updatable = false)
    private UserModel createdUser;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private UUID updatedById;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", insertable = false, updatable = false)
    private UserModel updatedUser;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @Column(name = "deleted_by")
    private UUID deletedById;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deleted_by", insertable = false, updatable = false)
    private UserModel deletedUser;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "createdUser", fetch = FetchType.LAZY)
    private List<ProductModel> products;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}