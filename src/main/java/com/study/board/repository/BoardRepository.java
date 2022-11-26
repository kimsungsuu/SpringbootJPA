package com.study.board.repository;

import com.study.board.entity.SpringBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<SpringBoard, Integer> {

    public Page<SpringBoard> findByTitleContaining(String searchKeyword, Pageable pageable);
}
