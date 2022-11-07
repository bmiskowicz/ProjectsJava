package com.example.main.repository.workspace;

import com.example.main.entity.workspace.Message;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAll();

    List<Message> findAll(Sort sort);

    List<Message> findAllById(Iterable<Long> longs);

    Optional<Message> findById(Long aLong);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void deleteAllById(Iterable<? extends Long> longs);
}
