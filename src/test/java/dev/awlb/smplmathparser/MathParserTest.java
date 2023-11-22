package dev.awlb.smplmathparser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathParserTest {
    private final MathParser parser = new MathParser();

    @Test
    void constant() throws MathParserException {
        String function = "y = 5";
        EvaluationTree tree = parser.parse(function);
        assertEquals(5.0, tree.evaluate());
        assertTrue(tree.isConstant());
    }

    @Test
    void variable() throws MathParserException {
        String function = "y = x";
        EvaluationTree tree = parser.parse(function);
        tree.setVariable("x", 10.5);
        assertEquals(10.5, tree.evaluate());
        assertFalse(tree.isConstant());
    }

    @Test
    void unary() throws MathParserException {
        String function = "y = sin(x)";
        EvaluationTree tree = parser.parse(function);
        tree.setVariable("x", 20);
        assertEquals(Math.sin(20), tree.evaluate());
        assertFalse(tree.isConstant());
    }

    @Test
    void binary() throws MathParserException {
        String function = "y = x + 5";
        EvaluationTree tree = parser.parse(function);
        tree.setVariable("x", 40);
        assertEquals(45, tree.evaluate());
        assertFalse(tree.isConstant());
    }

    @Test
    void exception() {
        String function = "y =";
        assertThrows(MathParserException.class, () -> {parser.parse(function);});
    }
}