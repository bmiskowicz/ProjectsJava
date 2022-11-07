package com.example.main.repository.workspace;

import com.example.main.entity.workspace.Chat;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

    List<Chat> findAll();

    List<Chat> findAll(Sort sort);

    List<Chat> findAllById(Iterable<Long> longs);

    Optional<Chat> findById(Long aLong);

    boolean existsById(Long aLong);

    void deleteById(Long aLong);

    void deleteAllById(Iterable<? extends Long> longs);
}
