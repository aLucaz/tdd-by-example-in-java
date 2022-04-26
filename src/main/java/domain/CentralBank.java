package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public final class CentralBank {
    private final HashMap<Pair, Double> exchangeRateMap = new HashMap<>();

    public void add(Pair pair, Double rate) {
        exchangeRateMap.put(pair, rate);
    }

    public double getExchangeRate(Pair pair){
        return exchangeRateMap.get(pair);
    }
}
