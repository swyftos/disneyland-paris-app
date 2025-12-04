package androidx.test.espresso;

import androidx.test.espresso.core.internal.deps.guava.base.Preconditions;
import androidx.test.internal.platform.util.TestOutputEmitter;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class PerformException extends RuntimeException implements EspressoException {
    private final String actionDescription;
    private final String viewDescription;

    public static class Builder {
        private String actionDescription;
        private Throwable cause;
        private String viewDescription;

        public PerformException build() {
            return new PerformException(this);
        }

        public Builder from(PerformException performException) {
            this.actionDescription = performException.getActionDescription();
            this.viewDescription = performException.getViewDescription();
            this.cause = performException.getCause();
            return this;
        }

        public Builder withActionDescription(String str) {
            this.actionDescription = str;
            return this;
        }

        public Builder withCause(Throwable th) {
            this.cause = th;
            return this;
        }

        public Builder withViewDescription(String str) {
            this.viewDescription = str;
            return this;
        }
    }

    private PerformException(Builder builder) {
        super(String.format(Locale.ROOT, "Error performing '%s' on view '%s'.", builder.actionDescription, builder.viewDescription), builder.cause);
        this.actionDescription = (String) Preconditions.checkNotNull(builder.actionDescription);
        this.viewDescription = (String) Preconditions.checkNotNull(builder.viewDescription);
        TestOutputEmitter.dumpThreadStates("ThreadState-PerformException.txt");
    }

    public String getActionDescription() {
        return this.actionDescription;
    }

    public String getViewDescription() {
        return this.viewDescription;
    }
}
