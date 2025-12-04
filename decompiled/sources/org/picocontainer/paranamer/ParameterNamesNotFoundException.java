package org.picocontainer.paranamer;

/* loaded from: classes6.dex */
public class ParameterNamesNotFoundException extends RuntimeException {
    public static final String __PARANAMER_DATA = "v1.0 \n<init> java.lang.String message \n";
    private Exception cause;

    public ParameterNamesNotFoundException(String str, Exception exc) {
        super(str);
        this.cause = exc;
    }

    public ParameterNamesNotFoundException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
