package com.example.springsecurity.util;

import com.example.springsecurity.service.mathoperations.MathOperation;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OperationManager{

    private List<MathOperation> mathOperations;

    public OperationManager(List<MathOperation> mathOperations) {
        this.mathOperations = mathOperations;
    }

    public List<String> getNameOperations(){
        List<String> names = new ArrayList<>();
        for (MathOperation maths: mathOperations){
            names.add(maths.getClass().getSimpleName());
        }
        return names;
    }

    public MathOperation getOperationByName(String name){
        return  mathOperations.stream().filter(math -> math.getClass().getSimpleName().equals(name)).findFirst().get();
    }
}
