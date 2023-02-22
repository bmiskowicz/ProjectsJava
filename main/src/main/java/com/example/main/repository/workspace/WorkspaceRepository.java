package com.example.main.repository.workspace;

import com.example.main.entity.workspace.Workspace;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    Optional<Workspace> findById(Long aLong);

    List<Workspace> findAll();

    List<Workspace> findAll(Sort sort);

    List<Workspace> findAllById(Iterable<Long> longs);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void delete(Workspace entity);
}
