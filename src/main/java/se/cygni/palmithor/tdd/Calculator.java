package se.cygni.palmithor.tdd;

import java.util.Arrays;
import java.util.Optional;


public class Calculator {


    public Optional<Integer> sumAll(final Integer... valuesParam) {
        if (valuesParam == null) {
            return Optional.empty();
        }

        return Optional.of(Arrays.stream(valuesParam).reduce(0, Integer::sum));
    }
}
