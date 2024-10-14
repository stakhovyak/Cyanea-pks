package com.weuoimi.cyanea.repos;

import com.weuoimi.cyanea.entity.Noteable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface NotesRepository extends JpaRepository<Noteable, UUID> {

    List<Noteable> findByGroupId(UUID groupId);
}
