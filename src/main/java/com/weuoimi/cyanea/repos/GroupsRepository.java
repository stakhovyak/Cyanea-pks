package com.weuoimi.cyanea.repos;

import com.weuoimi.cyanea.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupsRepository extends JpaRepository<Group, UUID> {
}
