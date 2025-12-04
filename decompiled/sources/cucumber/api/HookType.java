package cucumber.api;

import java.util.Locale;

/* loaded from: classes5.dex */
public enum HookType {
    Before,
    After,
    BeforeStep,
    AfterStep;

    @Override // java.lang.Enum
    public String toString() {
        return super.toString().toLowerCase(Locale.ROOT);
    }
}
