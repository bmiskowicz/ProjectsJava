package com.example.main.repository.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Workspace;
import com.example.main.entity.workspace.WorkspaceInvitation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WorkspaceInvitationRepository extends JpaRepository<WorkspaceInvitation, Long> {
    @Override
    List<WorkspaceInvitation> findAll();

    boolean existsByProfile(Profile profile);
    List<WorkspaceInvitation> findAllByProfile(Profile profile);
    void deleteAllByProfile(Profile profile);

    boolean existsByWorkspace(Workspace workspace);
    List<WorkspaceInvitation> findAllByWorkspace(Workspace workspace);
    void deleteAllByWorkspace(Workspace workspace);

    boolean existsByProfileAndWorkspace(Profile profile, Workspace workspace);
    List<WorkspaceInvitation> findByProfileAndWorkspace(Profile profile, Workspace workspace);
    Optional<WorkspaceInvitation> findByWorkspace(Workspace workspace);
    Optional<WorkspaceInvitation> findByProfile(Profile profile);

    @Override
    Optional<WorkspaceInvitation> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}
