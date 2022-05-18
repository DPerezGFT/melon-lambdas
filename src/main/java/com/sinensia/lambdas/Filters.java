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

    public static List<Melon> filterByWeight(List<Melon> melons, int weight){
        if (melons == null || weight <= 0){
            throw new IllegalArgumentException("melon cannot be null and weight cannot be 0");
        }
        if (melons.isEmpty()){
            return melons;
        }
        List<Melon> Result = new ArrayList<Melon>();
        for (Melon melon : melons){
            if (melon != null && melon.getWeight() == weight){
                Result.add(melon);
            }
        }
        return Result;
    }

    public static List<Melon> filterByHeavier(List<Melon> melons, int limit){
        if (melons == null || limit <= 0){
            throw new IllegalArgumentException("melon cannot be null and weight cannot be 0");
        }
        if (melons.isEmpty()){
            return melons;
        }
        List<Melon> Result = new ArrayList<Melon>();
        for (Melon melon : melons){
            if (melon != null && melon.getWeight() >= limit){
                Result.add(melon);
            }
        }
        return Result;
    }

    public static List<Melon> filterByLighter(List<Melon> melons, int limit){
        if (melons == null || limit <= 0){
            throw new IllegalArgumentException("melon cannot be null and weight cannot be 0");
        }
        if (melons.isEmpty()){
            return melons;
        }
        List<Melon> Result = new ArrayList<Melon>();
        for (Melon melon : melons){
            if (melon != null && melon.getWeight() == limit){
                Result.add(melon);
            }
        }
        return Result;
    }

    public static List<Melon> filterMelon(List<Melon> melons, MelonPredicate predicate){
        if(melons == null){
            //peto
        }

        List<Melon> result = new ArrayList<>();
        for (Melon melon : melons){
            if (melon != null && predicate.test(melon)){
                result.add(melon);
            }
        }
        return result;
    }

}
