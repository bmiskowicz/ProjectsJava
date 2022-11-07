package com.example.main.repository.workspace;

import com.example.main.entity.workspace.Issue;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {

    List<Issue> findAll();

    List<Issue> findAll(Sort sort);

    List<Issue> findAllById(Iterable<Long> longs);

    Optional<Issue> findById(Long aLong);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void deleteAllById(Iterable<? extends Long> longs);
}
