package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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
        List<Melon> gac = Filters.filterMelon(melons, new GacMelonPredicate());
        for (Melon m : gac){
            System.out.println(m);
        }

        System.out.println("Lista de melones pesados:");
        List<Melon> heavy = Filters.filterMelon(melons, new HeavyMelonPredicate());
        for (Melon m : heavy){
            System.out.println(m);
        }

        System.out.println("Lista de melones super-pesados:");
        List<Melon> superheavy = Filters.filterMelon(melons, melon -> melon != null && melon.getWeight()>=6000);
        for (Melon m : superheavy){
            System.out.println(m);
        }

        System.out.println("Lista de melones europeos:");
        List<Melon> european = Filters.filterMelon(melons, melon -> melon != null && melon.getOrigin().equalsIgnoreCase("Europe"));
        for (Melon m : european){
            System.out.println(m);
        }

        System.out.println("Lista de sandias:");
        for (Melon m : Filters.filter(melons, (Melon m) -> m.getType().equalsIgnoreCase("Watermelon"))){
            System.out.println(m);
        }

        System.out.println("Stream de melones:");
        melons.stream()
                .forEach(melon->System.out.println(melon));

        System.out.println("Stream de melones gac filtrados:");
        melons.stream()
                .filter(melon->"gac".equalsIgnoreCase(melon.getType()))
                .forEach(melon -> System.out.println(melon));

        System.out.println("Primer melon del stream:");
        Optional<Melon> primero = melons.stream()
                .findFirst();
        if (primero.isPresent()){
            System.out.println(primero.get());
        }

        System.out.println("Primer melon del stream v2:");
        primero.ifPresent(melon->System.out.println(melon));

        System.out.println("Primer melon del stream v3:");
        melons.stream()
                .findFirst()
                .ifPresent(melon -> System.out.println(melon));

        melons.stream()
                .mapToInt(melon->melon.getWeight())
                .average()
                .ifPresent(average->System.out.println("Peso promedio: "+average));
    }
}
