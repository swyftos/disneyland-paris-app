package com.urbanairship.android.framework.proxy.proxies;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H¦@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m1836d2 = {"Lcom/urbanairship/android/framework/proxy/proxies/SuspendingPredicate;", ExifInterface.GPS_DIRECTION_TRUE, "", "apply", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "airship-framework-proxy_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface SuspendingPredicate<T> {
    @Nullable
    Object apply(T t, @NotNull Continuation<? super Boolean> continuation);
}
