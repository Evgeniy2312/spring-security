package com.example.springsecurity.service;

import com.example.springsecurity.entity.Operation;
import com.example.springsecurity.entity.User;
import com.example.springsecurity.repository.OperationRepository;
import com.example.springsecurity.service.mathoperations.MathOperation;
import com.example.springsecurity.util.OperationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OperationService {

    private final OperationRepository operationRepository;

    private final OperationManager operationManager;


    public OperationService(OperationRepository operationRepository, OperationManager operationManager) {
        this.operationRepository = operationRepository;
        this.operationManager = operationManager;
    }

    public Optional<Operation> add(Operation operation) {
        MathOperation mathOperation = operationManager.getOperationByName(operation.getTypeOfOperation());
        Operation operation1 = mathOperation.getOperation(operation, getUser());
        operationRepository.save(operation1);
        return Optional.of(operation1);
    }

    public List<Operation> getByUser(User user) {
        return operationRepository.findByUserId(user.getId());
    }

    public List<Operation> getByUserAndTypeOfOperation(User user, String type) {
        return operationRepository.findByUserIdAndTypeOfOperation(user.getId(), type);
    }

    public OperationManager getOperationManager() {
        return operationManager;
    }

    private User getUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
