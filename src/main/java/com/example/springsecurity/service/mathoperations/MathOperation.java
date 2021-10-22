package com.example.springsecurity.service.mathoperations;

import com.example.springsecurity.entity.Operation;
import com.example.springsecurity.entity.User;

import java.math.BigDecimal;
import java.math.RoundingMode;

public interface MathOperation {

    Operation getOperation(Operation operation, User user);
    default double getDouble(double result){
        BigDecimal resultBD = new BigDecimal(result).setScale(2, RoundingMode.DOWN);
        return resultBD.doubleValue();
    }
}
