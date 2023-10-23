package edu.hw2.Task1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExprTest {
    @DisplayName("Expr - константа")
    @Test
    void exprConst() {
        var x = new Expr.Constant(12);
        Assertions
            .assertThat(x.evaluate()).isEqualTo(12);
    }

    @DisplayName("Expr - сложение")
    @Test
    void exprAddition() {
        var left = new Expr.Constant(12);
        var right = new Expr.Constant(8);
        var res = new Expr.Addition(left, right);
        Assertions
            .assertThat(res.evaluate()).isEqualTo(20);
    }

    @DisplayName("Expr - умножение")
    @Test
    void exprMultiplication() {
        var left = new Expr.Constant(5);
        var right = new Expr.Constant(9);
        var res = new Expr.Multiplication(left, right);
        Assertions
            .assertThat(res.evaluate()).isEqualTo(45);
    }

    @DisplayName("Expr - возведение в степень")
    @Test
    void exprExponent() {
        var left = new Expr.Constant(2);
        var right = new Expr.Constant(10);
        var res = new Expr.Exponent(left, right);
        Assertions
            .assertThat(res.evaluate()).isEqualTo(1024);
    }

    @DisplayName("Expr - Отрицание")
    @Test
    void exprNegation() {
        var x = new Expr.Constant(12);
        var neg = new Expr.Negate(x);
        Assertions
            .assertThat(neg.evaluate()).isEqualTo(-12);
    }

    @DisplayName("Expr - Композиция операций")
    @Test
    void exprComposition() {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var multiplication = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(multiplication, new Expr.Constant(2));
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        Assertions
            .assertThat(res.evaluate()).isEqualTo(37);
    }
}
