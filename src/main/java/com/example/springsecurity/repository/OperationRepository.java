package com.example.springsecurity.repository;

import com.example.springsecurity.entity.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findByUserId(long id);
    List<Operation> findByUserIdAndTypeOfOperation(long id, String typeOfOperation);
    boolean existsByTypeOfOperation(String typeOfOperation);
}
