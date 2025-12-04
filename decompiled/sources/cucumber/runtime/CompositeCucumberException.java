package cucumber.runtime;

import java.util.List;

/* loaded from: classes5.dex */
class CompositeCucumberException extends CucumberException {
    private final List causes;

    CompositeCucumberException(List list) {
        super(String.format("There were %d exceptions:", Integer.valueOf(list.size())));
        this.causes = list;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        StringBuilder sb = new StringBuilder(super.getMessage());
        for (Throwable th : this.causes) {
            sb.append(String.format("\n  %s(%s)", th.getClass().getName(), th.getMessage()));
        }
        return sb.toString();
    }
}
