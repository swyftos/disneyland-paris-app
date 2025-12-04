package com.allegion.altranslation;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u001c\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\u0086\b¢\u0006\u0002\u0010\u0003\u001a\f\u0010\u0004\u001a\u00020\u0002*\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"parseJson", ExifInterface.GPS_DIRECTION_TRUE, "", "(Ljava/lang/String;)Ljava/lang/Object;", "toJson", "", "AlTranslation_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AlJsonKt {
    @NotNull
    public static final String toJson(@Nullable Object obj) {
        return AlJson.toJson(obj);
    }

    @Nullable
    public static final /* synthetic */ <T> T parseJson(@NotNull String parseJson) {
        Intrinsics.checkParameterIsNotNull(parseJson, "$this$parseJson");
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) AlJson.parseJson(parseJson, Object.class);
    }
}
