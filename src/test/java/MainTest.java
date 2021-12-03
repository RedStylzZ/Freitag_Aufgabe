import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void checkMinLengthTrue() {
        assertTrue(Main.validateLength("IlikeTurtles"));
    }

    @Test
    void checkMinLengthFalse() {
        assertFalse(Main.validateLength("IlikeTu"));
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

    @Test
    void checkSpecialCharTrue() {
        assertTrue(Main.hasSpecialChar("password_"));
    }

    @Test
    void testRenamingBoolean() {
        assertEquals("Yes", Main.renameBoolean(true));
        assertEquals("No", Main.renameBoolean(false));
    }
}