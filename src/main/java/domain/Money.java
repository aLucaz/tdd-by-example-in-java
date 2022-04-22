package domain;

import lombok.Getter;

import java.util.Objects;

@Getter
public final class Money {
    private final double value;
    private final String currency;

    public Money(double value, String currency) {
        this.value = value;
        this.currency = currency;
    }

    public double add(Money other, double exchange) {
        return value + (other.getValue() * exchange);
    }

    public double times(int multiplier) {
        return value * multiplier;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        Money other = (Money) object;
        return value == other.getValue() && Objects.equals(currency, other.getCurrency());
    }
}
