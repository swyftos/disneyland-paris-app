package io.cucumber.junit;

/* loaded from: classes5.dex */
final class UndefinedThrowable extends Throwable {
    private static final long serialVersionUID = 1;

    UndefinedThrowable() {
        super("This step is undefined", null, false, false);
    }

    UndefinedThrowable(String str) {
        super(String.format("The step \"%s\" is undefined", str), null, false, false);
    }
}
