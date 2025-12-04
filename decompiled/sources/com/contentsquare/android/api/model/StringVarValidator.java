package com.contentsquare.android.api.model;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0086\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/contentsquare/android/api/model/StringVarValidator;", "", "maxLength", "", "defaultValue", "", "(ILjava/lang/String;)V", "getDefaultValue", "()Ljava/lang/String;", "getMaxLength", "()I", "onEmpty", "Lkotlin/Function0;", "", "getOnEmpty", "()Lkotlin/jvm/functions/Function0;", "onTooLong", "Lkotlin/Function1;", "getOnTooLong", "()Lkotlin/jvm/functions/Function1;", "invoke", "value", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class StringVarValidator {

    @NotNull
    private final String defaultValue;
    private final int maxLength;

    public StringVarValidator(int i, @NotNull String defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        this.maxLength = i;
        this.defaultValue = defaultValue;
    }

    @NotNull
    public final String getDefaultValue() {
        return this.defaultValue;
    }

    public final int getMaxLength() {
        return this.maxLength;
    }

    @NotNull
    public abstract Function0<Unit> getOnEmpty();

    @NotNull
    public abstract Function1<Integer, Unit> getOnTooLong();

    @NotNull
    public final String invoke(@NotNull String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (value.length() == 0) {
            getOnEmpty().invoke();
            return this.defaultValue;
        }
        if (value.length() <= this.maxLength) {
            return value;
        }
        getOnTooLong().invoke(Integer.valueOf(value.length()));
        String strSubstring = value.substring(0, this.maxLength);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public /* synthetic */ StringVarValidator(int i, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? "cs-empty" : str);
    }
}
