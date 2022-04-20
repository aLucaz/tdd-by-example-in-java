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

/*
 * 1. look at the objects side effects
 * 2. now I want to test some variations of the code
 * */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MoneyTest {

    @Test
    void testAddGiven5USDAnd10CHFExpect10USD() {
        Money base = new Money(5, "USD");
        Money other = new Money(10, "CHF");
        double result = base.add(other, 0.5);
        assertEquals(10, result);
    }

    @Test
    void testAddGiven10USDand8CHFExpect14USD() {
        Money base = new Money(10, "USD");
        Money other = new Money(8, "CHF");
        double result = base.add(other, 0.5);
        assertEquals(14, result);
    }

    @Test
    void testTimesGiven5USD2TimesExpect10USD() {
        Money base = new Money(5, "USD");
        double result = base.times(2);
        assertEquals(10, result);
    }

    @Test
    void testTimesGiven4USD2TimesExpect8USD() {
        Money base = new Money(4, "USD");
        double result = base.times(2);
        assertEquals(8, result);
    }

}
