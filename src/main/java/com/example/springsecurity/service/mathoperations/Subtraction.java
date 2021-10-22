package com.example.springsecurity.service.mathoperations;

import com.example.springsecurity.entity.Operation;
import com.example.springsecurity.entity.User;
import org.springframework.stereotype.Component;

@Component
public class Subtraction implements MathOperation {
    @Override
    public Operation getOperation(Operation operation, User user) {
        double num1 = operation.getNum1();
        double num2 = operation.getNum2();
        return Operation.builder().num1(num1).num2(num2)
                .typeOfOperation(operation.getTypeOfOperation())
                .user(user)
                .result(getDouble(num1 - num2))
                .build();
    }
}
