package cucumber.api;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class Result {
    public static final Comparator<Result> SEVERITY = new Comparator() { // from class: cucumber.api.Result.1
        @Override // java.util.Comparator
        public int compare(Result result, Result result2) {
            if (result.status == result2.status) {
                return 0;
            }
            return result.status.ordinal() > result2.status.ordinal() ? 1 : -1;
        }
    };
    public static final Result UNDEFINED = new Result(Type.UNDEFINED, 0L, null);
    private final Long duration;
    private final Throwable error;
    private final Type status;

    public enum Type {
        PASSED,
        SKIPPED,
        PENDING,
        UNDEFINED,
        AMBIGUOUS,
        FAILED,
        UNUSED;

        public static Type fromLowerCaseName(String str) {
            return valueOf(str.toUpperCase(Locale.ROOT));
        }

        public String lowerCaseName() {
            return name().toLowerCase(Locale.ROOT);
        }

        public String firstLetterCapitalizedName() {
            return name().substring(0, 1) + name().substring(1).toLowerCase(Locale.ROOT);
        }
    }

    public Result(Type type, Long l, Throwable th) {
        Objects.requireNonNull(type);
        this.status = type;
        Objects.requireNonNull(l);
        this.duration = l;
        this.error = th;
    }

    public Type getStatus() {
        return this.status;
    }

    public Long getDuration() {
        return this.duration;
    }

    public String getErrorMessage() {
        Throwable th = this.error;
        if (th != null) {
            return getErrorMessage(th);
        }
        return null;
    }

    public Throwable getError() {
        return this.error;
    }

    public boolean is(Type type) {
        return this.status == type;
    }

    public boolean isOk(boolean z) {
        return hasAlwaysOkStatus() || (!z && hasOkWhenNotStrictStatus());
    }

    private boolean hasAlwaysOkStatus() {
        return is(Type.PASSED) || is(Type.SKIPPED);
    }

    private boolean hasOkWhenNotStrictStatus() {
        return is(Type.UNDEFINED) || is(Type.PENDING);
    }

    private String getErrorMessage(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.getBuffer().toString();
    }

    public String toString() {
        return "Result{status=" + this.status + ", duration=" + this.duration + ", error=" + this.error + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Result.class != obj.getClass()) {
            return false;
        }
        Result result = (Result) obj;
        return this.status == result.status && Objects.equals(this.duration, result.duration) && Objects.equals(this.error, result.error);
    }

    public int hashCode() {
        return Objects.hash(this.status, this.duration, this.error);
    }
}
