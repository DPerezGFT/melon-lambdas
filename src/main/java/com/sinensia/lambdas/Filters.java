package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.List;

public final class Filters {

    public Filters(){
        throw new AssertionError("Utility class cannot be instantiated");
    }

    public static List<Melon> filterByType(List<Melon> melons, String type){
        if (melons == null || type == null){
            throw new IllegalArgumentException("melons or type cannot be null");
        }
        if (melons.isEmpty()){
            return melons;
        }
        List<Melon> Result = new ArrayList<Melon>();
        for (Melon melon : melons){
            if (melon != null && melon.getType().equals(type)){
                Result.add(melon);
            }
        }
        return Result;
    }

}
