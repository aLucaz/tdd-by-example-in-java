package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CentralBankTest {
    CentralBank centralBank;

    @BeforeEach
    void init() {
        centralBank = new CentralBank();
    }

    @Test
    void testAddExchangeRateGivenUSDAndCHFExpectPairExistsInList() {
        Pair pair = new Pair(new Currency("CHF"), new Currency("USD"));
        double rate = 2.0;
        centralBank.add(pair, rate);
        HashMap<Pair, Double> exchangeRateMap = centralBank.getExchangeRateMap();
        boolean pairExists = false;
        for (Map.Entry<Pair, Double> entry : exchangeRateMap.entrySet()) {
            Pair key = entry.getKey();
            Double value = entry.getValue();
            if (pair.equals(key) && rate == value) {
                pairExists = true;
                break;
            }
        }
        assertTrue(pairExists);
    }

    @Test
    void testAddExchangeRateGivenMultipleObjectsExpectPairExistsInList() {
        Pair pair = new Pair(new Currency("CHF"), new Currency("USD"));
        double rate = 2.0;
        centralBank.add(pair, rate);
        HashMap<Pair, Double> exchangeRateMap = centralBank.getExchangeRateMap();
        Pair pairToSearch = new Pair(new Currency("CHF"), new Currency("USD"));
        boolean pairExists = false;
        for (Map.Entry<Pair, Double> entry : exchangeRateMap.entrySet()) {
            Pair key = entry.getKey();
            Double value = entry.getValue();
            if (pairToSearch.equals(key) && rate == value) {
                pairExists = true;
                break;
            }
        }
        assertTrue(pairExists);
    }

    @Test
    void testGetExchangeRateGivenUSDAndCHFExpectValue() {
        Pair pair = new Pair(new Currency("CHF"), new Currency("USD"));
        double rate = 2.0;
        centralBank.add(pair, rate);
        assertEquals(rate, centralBank.getExchangeRate(pair));
    }
}
