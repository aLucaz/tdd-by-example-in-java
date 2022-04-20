package domain;

import lombok.Getter;

@Getter
public final class Money {
    private final double value;
    private final String currency;

    public Money(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double add(Money other){
        return 10;
    }
}
