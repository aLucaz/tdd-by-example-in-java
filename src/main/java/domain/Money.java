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

    public double add(Money other, double exchange){
        return value + (other.getValue() * exchange);
    }

    public double times(int multiplier){
        return value * multiplier;
    }
}
