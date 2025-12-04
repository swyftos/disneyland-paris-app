package com.allegion.alsecurity;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.util.encoders.Hex;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0006J\u0016\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/allegion/alsecurity/AlSharedPreferences;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "name", "", "(Landroid/content/Context;Ljava/lang/String;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "containsData", "", "reference", "removeData", "retrieveByteArray", "", "retrieveInteger", "", "retrieveString", "storeByteArray", "array", "storeInteger", "value", "storeString", "Companion", "AlSecurity_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlSharedPreferences {
    private static final String EXCEPTION_CONTEXT_NULL = "Context is null";
    private static final String EXCEPTION_NAME_NULL = "Storage value is null";
    private static final String EXCEPTION_REFERENCE_NULL = "Reference is null";
    private static final String EXCEPTION_VALUE_NULL = "Storage value is null";
    private static final String SHARED_PREFERENCES = "Allegion_Prefs";
    private final SharedPreferences sharedPreferences;

    public AlSharedPreferences(@NotNull Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Objects.requireNonNull(context, EXCEPTION_CONTEXT_NULL);
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…ES, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
    }

    public AlSharedPreferences(@NotNull Context context, @NotNull String name) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(name, "name");
        Objects.requireNonNull(context, EXCEPTION_CONTEXT_NULL);
        Objects.requireNonNull(name, "Storage value is null");
        SharedPreferences sharedPreferences = context.getSharedPreferences(name, 0);
        Intrinsics.checkExpressionValueIsNotNull(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences;
    }

    public final boolean storeByteArray(@NotNull byte[] array, @NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(array, "array");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        Objects.requireNonNull(array, "Storage value is null");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(reference, Hex.toHexString(array));
        editorEdit.apply();
        return true;
    }

    @NotNull
    public final byte[] retrieveByteArray(@NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        String string = this.sharedPreferences.getString(reference, null);
        if (string != null) {
            byte[] bArrDecode = Hex.decode(string);
            Intrinsics.checkExpressionValueIsNotNull(bArrDecode, "Hex.decode(data)");
            return bArrDecode;
        }
        return new byte[0];
    }

    public final boolean storeString(@NotNull String value, @NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(value, "value");
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        Objects.requireNonNull(value, "Storage value is null");
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putString(reference, value);
        editorEdit.apply();
        return true;
    }

    @NotNull
    public final String retrieveString(@NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        String string = this.sharedPreferences.getString(reference, "");
        if (string == null) {
            Intrinsics.throwNpe();
        }
        return string;
    }

    public final boolean storeInteger(int value, @NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.putInt(reference, value);
        editorEdit.apply();
        return true;
    }

    public final int retrieveInteger(@NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        return this.sharedPreferences.getInt(reference, 0);
    }

    public final boolean removeData(@NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        if (!this.sharedPreferences.contains(reference)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = this.sharedPreferences.edit();
        editorEdit.remove(reference);
        editorEdit.apply();
        return true;
    }

    public final boolean containsData(@NotNull String reference) {
        Intrinsics.checkParameterIsNotNull(reference, "reference");
        Objects.requireNonNull(reference, EXCEPTION_REFERENCE_NULL);
        return this.sharedPreferences.contains(reference);
    }
}
