import Arquitecture.controler.passwordEvaluator;
import Arquitecture.model.Toughness;
import Arquitecture.model.password;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordEvaluatorTests {

    @Test
    void HasLessThan8characters() {
        password password = new password("inge");
        passwordEvaluator evaluator = new passwordEvaluator();

        Toughness isValid = evaluator.evaluate_password(password.getPassword());

        assertEquals(Toughness.Very_bad, isValid);
    }

    @Test
    void Has8characters() {
        password password = new password("ingenieria");
        passwordEvaluator evaluator = new passwordEvaluator();

        Toughness isValid = evaluator.evaluate_password(password.getPassword());

        assertEquals(Toughness.Bad, isValid);
    }

    @Test
    void IncludesLowercaseAndUppercase() {
        password password = new password("InGENIeria");
        passwordEvaluator evaluator = new passwordEvaluator();

        Toughness isValid = evaluator.evaluate_password(password.getPassword());

        assertEquals(Toughness.Acceptable, isValid);
    }
    @Test
    void IncludesAtLeastOneNumber() {
        password password = new password("1nGEN1eriA");
        passwordEvaluator evaluator = new passwordEvaluator();

        Toughness isValid = evaluator.evaluate_password(password.getPassword());

        assertEquals(Toughness.Good, isValid);
    }

    @Test
    void IncludesEspecialCharacters() {
        password password = new password("1nGEN1eri@");
        passwordEvaluator evaluator = new passwordEvaluator();

        Toughness isValid = evaluator.evaluate_password(password.getPassword());

        assertEquals(Toughness.Very_good, isValid);
    }

    @Test
    void HasConsecutiveCharacters() {
        password password = new password("1nGEEN1eri@");
        passwordEvaluator evaluator = new passwordEvaluator();

        Toughness isValid = evaluator.evaluate_password(password.getPassword());

        assertEquals(Toughness.Good, isValid);
    }
}

