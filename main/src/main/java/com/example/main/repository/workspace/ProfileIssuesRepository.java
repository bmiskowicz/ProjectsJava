package com.example.main.repository.workspace;

import com.example.main.entity.Profile;
import com.example.main.entity.workspace.Issue;
import com.example.main.entity.workspace.ProfileIssues;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileIssuesRepository extends JpaRepository<ProfileIssues, Long> {
    Optional<ProfileIssues> findById(Long aLong);
    Optional<ProfileIssues> findByProfileAndIssue(Profile profile, Issue Issue);

    List<ProfileIssues> findAll();

    List<ProfileIssues> findAllByIssue(Issue issue);
    List<ProfileIssues> findAll(Sort sort);

    List<ProfileIssues> findAllById(Iterable<Long> longs);

    boolean existsById(Long aLong);
    boolean existsByIssue(Issue issue);
    boolean existsByProfileAndIssue(Profile profile, Issue issue);

    void deleteById(Long aLong);

    void deleteByIssue(Issue issue);

    void deleteAllById(Iterable<? extends Long> longs);
}
