package domain;/*
 * We need
 * to be able to add amounts in two different currencies
 * to convert the result given a set of exchange rates
 * to be able to multiply an amount by a number and receive an amount
 * We test
 * add 5USD and 10CHF
 *
 * */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MoneyTest {

    @Test
    void testAddGiven5USDAnd10CHFExpect10USD() {
        Money base = new Money(5, "USD");
        Money other = new Money(10, "CHF");
        double result = base.add(other);
        assertEquals(10, result);
    }

    @Test
    void testMultiplyGiven5USDExpect10USD(){
        Money base = new Money(5, "USD");
        double result = base.times(2);
        assertEquals(10, result);
    }
}
