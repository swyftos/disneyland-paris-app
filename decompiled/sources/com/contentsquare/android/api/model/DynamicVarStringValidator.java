package com.contentsquare.android.api.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/contentsquare/android/api/model/DynamicVarStringValidator;", "Lcom/contentsquare/android/api/model/DynamicVarValidator;", "key", "", "value", "(Ljava/lang/String;Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Companion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DynamicVarStringValidator extends DynamicVarValidator {

    @NotNull
    private static final String EMPTY_VALUE = "cs-empty";
    private static final int MAX_LENGTH = 255;

    @NotNull
    private final String value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicVarStringValidator(@NotNull String key, @NotNull String value) {
        String strSubstring;
        super(key);
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length() == 0) {
            DynamicVarValidator.INSTANCE.getLogger$library_release().i("Dynamic Variable value is empty. Dynamic Variable is sent but the value is set to \"cs-empty\"");
            strSubstring = EMPTY_VALUE;
        } else {
            if (value.length() <= 255) {
                this.value = value;
                return;
            }
            DynamicVarValidator.INSTANCE.getLogger$library_release().i("Dynamic Variable value is too long: the current input has a length of " + value.length() + " while the limit is 255. Dynamic Variable is sent but the value truncated");
            strSubstring = value.substring(0, 255);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        this.value = strSubstring;
    }

    @NotNull
    public final String getValue() {
        return this.value;
    }
}
