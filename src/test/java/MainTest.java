import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkMinLengthTrue() {
        assertTrue(Main.validatePasswordLength("IlikeTurtles"));
    }

    @Test
    void checkMinLengthFalse() {
        assertFalse(Main.validatePasswordLength("IlikeTu"));
    }

    @Test
    void checkHasNumbersTrue() {
        assertTrue(Main.hasNumbers("IlikeTurtles1"));
    }

    @Test
    void checkHasNumbersFalse() {
        assertFalse(Main.hasNumbers("IlikeTurtles"));
    }

    @Test
    void hasLowerCaseTrue() {
        assertTrue(Main.hasLowerCase("IlikeTurtles"));
    }

    @Test
    void hasLowerCaseFalse() {
        assertFalse(Main.hasLowerCase("ILIKETURTLES"));
    }

    @Test
    void hasUpperCaseTrue() {
        assertTrue(Main.hasUpperCase("IlikeTurtles"));
    }

    @Test
    void hasUpperCaseFalse() {
        assertFalse(Main.hasUpperCase("iliketurtles"));
    }

    @Test
    void checkBadPasswordTrue() {
        assertTrue(Main.checkForBadPassword("password"));
    }

    @Test
    void checkBadPasswordFalse() {
        assertFalse(Main.checkForBadPassword("fjghu1!k"));
    }

}