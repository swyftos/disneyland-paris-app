package androidx.test.internal.statement;

import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.runners.model.Statement;

/* loaded from: classes2.dex */
public class UiThreadStatement extends Statement {
    private final Statement base;
    private final boolean runOnUiThread;

    public UiThreadStatement(Statement statement, boolean z) {
        this.base = statement;
        this.runOnUiThread = z;
    }

    @Override // org.junit.runners.model.Statement
    public void evaluate() throws Throwable {
        if (this.runOnUiThread) {
            final AtomicReference atomicReference = new AtomicReference();
            InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() { // from class: androidx.test.internal.statement.UiThreadStatement.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        UiThreadStatement.this.base.evaluate();
                    } catch (Throwable th) {
                        atomicReference.set(th);
                    }
                }
            });
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                throw th;
            }
            return;
        }
        this.base.evaluate();
    }
}
