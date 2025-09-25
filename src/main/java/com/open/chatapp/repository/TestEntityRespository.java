package com.open.chatapp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.open.chatapp.domain.TestEntity;

@Repository
public interface TestEntityRespository extends JpaRepository<TestEntity, Long>{

	Optional<TestEntity> findById(Long id);
}
