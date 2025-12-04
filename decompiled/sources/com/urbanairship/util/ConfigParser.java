package com.urbanairship.util;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public interface ConfigParser {
    boolean getBoolean(@NonNull String str, boolean z);

    int getColor(@NonNull String str, @ColorInt int i);

    int getCount();

    int getDrawableResourceId(@NonNull String str);

    int getInt(@NonNull String str, int i);

    long getLong(@NonNull String str, long j);

    @Nullable
    String getName(int i) throws IndexOutOfBoundsException;

    int getRawResourceId(@NonNull String str);

    @Nullable
    String getString(@NonNull String str);

    @NonNull
    String getString(@NonNull String str, @NonNull String str2);

    @Nullable
    String[] getStringArray(@NonNull String str);
}
