package io.cucumber.tagexpressions;

import com.urbanairship.json.JsonPredicate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class TagExpressionParser {
    private static Map ASSOC = new HashMap() { // from class: io.cucumber.tagexpressions.TagExpressionParser.1
        {
            Assoc assoc = Assoc.LEFT;
            put(JsonPredicate.OR_PREDICATE_TYPE, assoc);
            put(JsonPredicate.AND_PREDICATE_TYPE, assoc);
            put(JsonPredicate.NOT_PREDICATE_TYPE, Assoc.RIGHT);
        }
    };
    private static Map PREC = new HashMap() { // from class: io.cucumber.tagexpressions.TagExpressionParser.2
        {
            put("(", -2);
            put(")", -1);
            put(JsonPredicate.OR_PREDICATE_TYPE, 0);
            put(JsonPredicate.AND_PREDICATE_TYPE, 1);
            put(JsonPredicate.NOT_PREDICATE_TYPE, 2);
        }
    };

    private enum Assoc {
        LEFT,
        RIGHT
    }

    private enum TokenType {
        OPERAND,
        OPERATOR
    }

    public Expression parse(String str) {
        TokenType tokenType;
        List<String> list = tokenize(str);
        if (list.isEmpty()) {
            return new True();
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        ArrayDeque arrayDeque2 = new ArrayDeque();
        TokenType tokenType2 = TokenType.OPERAND;
        for (String str2 : list) {
            if (isUnary(str2)) {
                tokenType = TokenType.OPERAND;
                check(tokenType2, tokenType);
                arrayDeque.push(str2);
            } else if (isBinary(str2)) {
                check(tokenType2, TokenType.OPERATOR);
                while (arrayDeque.size() > 0 && isOperator((String) arrayDeque.peek()) && ((ASSOC.get(str2) == Assoc.LEFT && ((Integer) PREC.get(str2)).intValue() <= ((Integer) PREC.get(arrayDeque.peek())).intValue()) || (ASSOC.get(str2) == Assoc.RIGHT && ((Integer) PREC.get(str2)).intValue() < ((Integer) PREC.get(arrayDeque.peek())).intValue()))) {
                    pushExpr((String) pop(arrayDeque), arrayDeque2);
                }
                arrayDeque.push(str2);
                tokenType2 = TokenType.OPERAND;
            } else if ("(".equals(str2)) {
                tokenType = TokenType.OPERAND;
                check(tokenType2, tokenType);
                arrayDeque.push(str2);
            } else if (")".equals(str2)) {
                check(tokenType2, TokenType.OPERATOR);
                while (arrayDeque.size() > 0 && !"(".equals(arrayDeque.peek())) {
                    pushExpr((String) pop(arrayDeque), arrayDeque2);
                }
                if (arrayDeque.size() == 0) {
                    throw new TagExpressionException("Syntax error. Unmatched )", new Object[0]);
                }
                if ("(".equals(arrayDeque.peek())) {
                    pop(arrayDeque);
                }
                tokenType2 = TokenType.OPERATOR;
            } else {
                check(tokenType2, TokenType.OPERAND);
                pushExpr(str2, arrayDeque2);
                tokenType2 = TokenType.OPERATOR;
            }
            tokenType2 = tokenType;
        }
        while (arrayDeque.size() > 0) {
            if ("(".equals(arrayDeque.peek())) {
                throw new TagExpressionException("Syntax error. Unmatched (", new Object[0]);
            }
            pushExpr((String) pop(arrayDeque), arrayDeque2);
        }
        return (Expression) arrayDeque2.pop();
    }

    private static List tokenize(String str) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        StringBuilder sb = null;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if ('\\' == cCharAt) {
                z = true;
            } else {
                if (Character.isWhitespace(cCharAt)) {
                    if (sb != null) {
                        arrayList.add(sb.toString());
                        sb = null;
                    }
                } else if ((cCharAt == '(' || cCharAt == ')') && !z) {
                    if (sb != null) {
                        arrayList.add(sb.toString());
                        sb = null;
                    }
                    arrayList.add(String.valueOf(cCharAt));
                } else {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(cCharAt);
                }
                z = false;
            }
        }
        if (sb != null) {
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    private void check(TokenType tokenType, TokenType tokenType2) {
        if (tokenType != tokenType2) {
            throw new TagExpressionException("Syntax error. Expected %s", tokenType.toString().toLowerCase());
        }
    }

    private Object pop(Deque deque) {
        if (deque.isEmpty()) {
            throw new TagExpressionException("empty stack", new Object[0]);
        }
        return deque.pop();
    }

    private void pushExpr(String str, Deque deque) {
        str.hashCode();
        switch (str) {
            case "or":
                deque.push(new Or((Expression) pop(deque), (Expression) pop(deque)));
                break;
            case "and":
                deque.push(new And((Expression) pop(deque), (Expression) pop(deque)));
                break;
            case "not":
                deque.push(new Not((Expression) pop(deque)));
                break;
            default:
                deque.push(new Literal(str));
                break;
        }
    }

    private boolean isUnary(String str) {
        return JsonPredicate.NOT_PREDICATE_TYPE.equals(str);
    }

    private boolean isBinary(String str) {
        return JsonPredicate.OR_PREDICATE_TYPE.equals(str) || JsonPredicate.AND_PREDICATE_TYPE.equals(str);
    }

    private boolean isOperator(String str) {
        return ASSOC.get(str) != null;
    }

    private class Literal implements Expression {
        private final String value;

        Literal(String str) {
            this.value = str;
        }

        @Override // io.cucumber.tagexpressions.Expression
        public boolean evaluate(List list) {
            return list.contains(this.value);
        }

        public String toString() {
            return this.value.replaceAll("\\(", "\\\\(").replaceAll("\\)", "\\\\)");
        }
    }

    private class Or implements Expression {
        private final Expression left;
        private final Expression right;

        Or(Expression expression, Expression expression2) {
            this.left = expression;
            this.right = expression2;
        }

        @Override // io.cucumber.tagexpressions.Expression
        public boolean evaluate(List list) {
            return this.left.evaluate(list) || this.right.evaluate(list);
        }

        public String toString() {
            return "( " + this.left.toString() + " or " + this.right.toString() + " )";
        }
    }

    private class And implements Expression {
        private final Expression left;
        private final Expression right;

        And(Expression expression, Expression expression2) {
            this.left = expression;
            this.right = expression2;
        }

        @Override // io.cucumber.tagexpressions.Expression
        public boolean evaluate(List list) {
            return this.left.evaluate(list) && this.right.evaluate(list);
        }

        public String toString() {
            return "( " + this.left.toString() + " and " + this.right.toString() + " )";
        }
    }

    private class Not implements Expression {
        private final Expression expr;

        Not(Expression expression) {
            this.expr = expression;
        }

        @Override // io.cucumber.tagexpressions.Expression
        public boolean evaluate(List list) {
            return !this.expr.evaluate(list);
        }

        public String toString() {
            return "not ( " + this.expr.toString() + " )";
        }
    }

    private class True implements Expression {
        @Override // io.cucumber.tagexpressions.Expression
        public boolean evaluate(List list) {
            return true;
        }

        private True() {
        }
    }
}
