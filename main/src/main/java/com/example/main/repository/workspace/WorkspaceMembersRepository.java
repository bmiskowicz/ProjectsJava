package com.example.main.repository.workspace;

import com.example.main.entity.workspace.WorkspaceMembers;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkspaceMembersRepository extends JpaRepository<WorkspaceMembers, Long> {

    List<WorkspaceMembers> findAll();

    List<WorkspaceMembers> findAll(Sort sort);

    List<WorkspaceMembers> findAllById(Iterable<Long> longs);

    Optional<WorkspaceMembers> findById(Long aLong);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void delete(WorkspaceMembers entity);
}
