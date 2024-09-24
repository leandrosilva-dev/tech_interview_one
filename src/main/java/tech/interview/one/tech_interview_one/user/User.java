package tech.interview.one.tech_interview_one.user;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

@Table("USERS")
public record User(
    @Id Long id,
    String fullName,
    String document,
    String email,
    Integer type,
    String password,
    @CreatedDate LocalDateTime createdAt,
    @LastModifiedDate LocalDateTime updatedAt
) {
}
