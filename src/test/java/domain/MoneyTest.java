package domain;
/*
 * 1. We need [TO DO LIST AND TESTS WE NEED]
 * to be able to add amounts in two different currencies
 * to convert the result given a set of exchange rates
 * to be able to multiply an amount by a number and receive an amount
 * 2. We test [STORY ABOUT HOW I WANT TO VIEW MY OPERATIONS]
 * add 5USD and 10CHF -> I want 10 as result
 * multiply 5USD by 2 -> I want 10 as result
 * 3. workflow
 * write failing test
 * write awful code to make tests pass
 * gradually update working code and refactor
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
    void testTimesGiven5USD2TimesExpect10USD() {
        Money base = new Money(5, "USD");
        double result = base.times(2);
        assertEquals(10, result);
    }
}
