package com.example.main.repository.workspace;

import com.example.main.entity.workspace.ProfileIssues;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProfileIssuesRepository extends JpaRepository<ProfileIssues, Long> {

    Optional<ProfileIssues> findById(Long aLong);

    List<ProfileIssues> findAll();

    List<ProfileIssues> findAll(Sort sort);

    List<ProfileIssues> findAllById(Iterable<Long> longs);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void deleteAllById(Iterable<? extends Long> longs);
}
