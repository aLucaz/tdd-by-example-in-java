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
 * I don't want to change the attributes of a class when I do operations add or times
 * */

/*
 * 1. going deep to the object behavior now we need to compare two Money objects
 * 2. when a Money object is equal to another?
 * Money is called a value object
 * */

/*
 * In chapter 5 kent creates a new class called Franc and because he was working with
 * a Dollar class. In my case I started the development using a Money class because it
 * has more sense to me.
 * */

/*
 * Improving equality comparison between classes: "currency"
 * In chapter 9 the author improves the code deleting repeated lines and repetitive behavior
 * */

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


class MoneyTest {
    static Currency dollar;
    static Currency franc;
    static CentralBank centralBank;
    static Pair pDollarFranc;
    static Pair pFrancDollar;

    @BeforeAll
    static void init() {
        dollar = new Currency("USD");
        franc = new Currency("CHF");
        centralBank = new CentralBank();
        pFrancDollar = new Pair(franc, dollar);
        pDollarFranc = new Pair(dollar, franc);
        centralBank.add(pFrancDollar, 2.0);
        centralBank.add(pDollarFranc, 0.5);
    }

    @Test
    void testAddGiven5USDAnd10CHFExpect10USD() {
        Money base = new Money(5, dollar);
        Money other = new Money(10, franc);
        double rate = centralBank.getExchangeRate(pFrancDollar);
        double result = base.add(other, rate);
        assertEquals(25, result);
    }

    @Test
    void testAddGiven10USDand8CHFExpect14USD() {
        Money base = new Money(10, new Currency("USD"));
        Money other = new Money(8, new Currency("CHF"));
        double rate = centralBank.getExchangeRate(pFrancDollar);
        double result = base.add(other, rate);
        assertEquals(26, result);
    }

    @Test
    void testTimesGiven5USD2TimesExpect10USD() {
        Money base = new Money(5, new Currency("USD"));
        double result = base.times(2);
        assertEquals(10, result);
    }

    @Test
    void testTimesGiven4USD2TimesExpect8USD() {
        Money base = new Money(4, new Currency("USD"));
        double result = base.times(2);
        assertEquals(8, result);
    }

    @Test
    void testEqualsGiven5USDAnd5USDExpectSuccess() {
        Money base = new Money(5, new Currency("USD"));
        Money other = new Money(5, new Currency("USD"));
        assertEquals(base, other);
    }

    @Test
    void testEqualsGiven5USDAnd6USDExpectFail() {
        Money base = new Money(5, new Currency("USD"));
        Money other = new Money(6, new Currency("USD"));
        assertNotEquals(base, other);
    }

    @Test
    void testEqualsGiven5USDAnd5CHFExpectFail() {
        Money base = new Money(5, new Currency("USD"));
        Money other = new Money(5, new Currency("CHF"));
        assertNotEquals(base, other);
    }
}
