package org.junit.internal.runners.statements;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

/* loaded from: classes6.dex */
public class ExpectException extends Statement {
    private final Class expected;
    private final Statement next;

    public ExpectException(Statement statement, Class<? extends Throwable> cls) {
        this.next = statement;
        this.expected = cls;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Exception {
        try {
            this.next.evaluate();
            throw new AssertionError("Expected exception: " + this.expected.getName());
        } catch (AssumptionViolatedException e) {
            if (!this.expected.isAssignableFrom(e.getClass())) {
                throw e;
            }
        } catch (Throwable th) {
            if (this.expected.isAssignableFrom(th.getClass())) {
                return;
            }
            throw new Exception("Unexpected exception, expected<" + this.expected.getName() + "> but was<" + th.getClass().getName() + ">", th);
        }
    }
}
