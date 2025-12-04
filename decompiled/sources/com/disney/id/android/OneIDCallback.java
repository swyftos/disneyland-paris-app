package com.disney.id.android;

import androidx.exifinterface.media.ExifInterface;
import com.disney.id.android.OneIDCallbackData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/disney/id/android/OneIDCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/disney/id/android/OneIDCallbackData;", "", "onFailure", "", "data", "(Lcom/disney/id/android/OneIDCallbackData;)V", "onSuccess", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface OneIDCallback<T extends OneIDCallbackData> {
    void onFailure(@NotNull T data);

    void onSuccess(@NotNull T data);
}
