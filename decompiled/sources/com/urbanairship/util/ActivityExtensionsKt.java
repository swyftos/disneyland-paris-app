package com.urbanairship.util;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.core.content.IntentCompat;
import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"parcelableExtra", ExifInterface.GPS_DIRECTION_TRUE, "Landroid/app/Activity;", "key", "", "(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/Object;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityExtensionsKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final /* synthetic */ <T> T parcelableExtra(Activity activity, String key) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intent intent = activity.getIntent();
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        return (T) IntentCompat.getParcelableExtra(intent, key, Object.class);
    }
}
