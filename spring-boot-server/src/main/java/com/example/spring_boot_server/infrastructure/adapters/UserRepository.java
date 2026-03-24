package com.example.spring_boot_server.infrastructure.adapters;

import com.example.spring_boot_server.domain.enums.DocumentTypeEnum;
import com.example.spring_boot_server.infrastructure.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    Optional<UserModel> findByDocumentTypeAndDocument(DocumentTypeEnum documentType, String document);
}