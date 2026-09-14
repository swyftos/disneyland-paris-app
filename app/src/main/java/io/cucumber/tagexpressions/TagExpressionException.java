package io.cucumber.tagexpressions;

/* JADX INFO: loaded from: classes5.dex */
public class TagExpressionException extends RuntimeException {
    public TagExpressionException(String str, Object... objArr) {
        super(String.format(str, objArr));
    }
}
