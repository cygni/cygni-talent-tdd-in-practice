package se.cygni.palmithor.tdd;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;


public class Calculator {


    public Optional<Integer> sumAll(final Integer... valuesParam) {
        if (valuesParam == null) {
            return Optional.empty();
        } else if (valuesParam.length < 1) {
            return Optional.of(0);
        } else {
            return Optional.of(Arrays.stream(valuesParam)
                    .filter(Objects::nonNull)
                    .reduce(0, Integer::sum));
        }
    }
}
