package com.example.main.repository.workspace;

import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceMembers;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface WorkspaceMembersRepository extends JpaRepository<WorkspaceMembers, Long> {

    List<WorkspaceMembers> findAll();

    List<WorkspaceMembers> findAll(Sort sort);

    List<WorkspaceMembers> findAllById(Iterable<Long> longs);

    Optional<WorkspaceMembers> findById(Long aLong);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void delete(WorkspaceMembers entity);

    ArrayList<WorkspaceMembers> findAllByWorkspace(Workspace workspace);

    void deleteAllByWorkspace(Workspace workspace);

}
