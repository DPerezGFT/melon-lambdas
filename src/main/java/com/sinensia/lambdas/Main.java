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

        List<Melon> bailans = Filters.filterByType(melons, "Bailan");
        System.out.println("Lista filtrada de bailan:");
        for (Melon bailan : bailans){
            System.out.println(bailan);
        }

        List<Melon> found = Filters.filterByWeight(melons, 1200);
        System.out.println("Lista filtrada de peso 1200:");
        for (Melon founds : found){
            System.out.println(founds);
        }

        List<Melon> heavier = Filters.filterByHeavier(melons, 1200);
        System.out.println("Lista filtrada de peso mayor o igual a 1200:");
        for (Melon heavy : heavier){
            System.out.println(heavy);
        }

        List<Melon> lighter = Filters.filterByLighter(melons, 1200);
        System.out.println("Lista filtrada de peso menor o igual a 1200:");
        for (Melon light : lighter){
            System.out.println(light);
        }

        System.out.println("Lista de melones gac:");
        GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        List<Melon> gac = Filters.filterMelon(melons, gacMelonPredicate);
        for (Melon m : gac){
            System.out.println(m);
        }
    }


}
