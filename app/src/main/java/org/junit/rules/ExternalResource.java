package org.junit.rules;

import java.util.ArrayList;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ExternalResource implements TestRule {
    protected void after() {
    }

    protected void before() throws Throwable {
    }

    @Override // org.junit.rules.TestRule
    public Statement apply(Statement statement, Description description) {
        return statement(statement);
    }

    private Statement statement(final Statement statement) {
        return new Statement() { // from class: org.junit.rules.ExternalResource.1
            @Override // org.junit.runners.model.Statement
            public void evaluate() throws Exception {
                ExternalResource.this.before();
                ArrayList arrayList = new ArrayList();
                try {
                    try {
                        statement.evaluate();
                        ExternalResource.this.after();
                    } catch (Throwable th) {
                        try {
                            arrayList.add(th);
                            ExternalResource.this.after();
                        } catch (Throwable th2) {
                            try {
                                ExternalResource.this.after();
                            } catch (Throwable th3) {
                                arrayList.add(th3);
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th4) {
                    arrayList.add(th4);
                }
                MultipleFailureException.assertEmpty(arrayList);
            }
        };
    }
}
