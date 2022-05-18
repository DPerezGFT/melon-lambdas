package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"),
                new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"),
                new Melon("Gac", 3400, "US"),
                new Melon("Bailan", 1300, "China")
        );

        for (int i = 0; i < melons.size(); ++i) {
            System.out.println(melons.get(i).toString());
        }

        List<Melon> bailans = filterByType(melons, "Bailan");
        System.out.println("Lista filtrada de bailan:");
        for (Melon bailan : bailans){
            System.out.println(bailan);
        }

    }

    private static List<Melon> filterByType(List<Melon> melons, String type){
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
