package com.stduy.membermange.repository;

import com.stduy.membermange.entity.springboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<springboard, Integer> {
}