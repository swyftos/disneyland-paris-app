package com.contentsquare.android.core.communication;

import ch.qos.logback.core.CoreConstants;
import com.disney.id.android.OneIDRecoveryContext;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u001f\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\tH\u0002¢\u0006\u0002\u0010\u0010R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/contentsquare/android/core/communication/HeapInterface;", "", "heapClass", "Ljava/lang/Class;", "isEnabled", "Lkotlin/Function0;", "", "(Ljava/lang/Class;Lkotlin/jvm/functions/Function0;)V", "getEnvironmentIdMethod", "Ljava/lang/reflect/Method;", "getSessionIdMethod", "getUserIdMethod", "getHeapMetadata", "Lcom/contentsquare/android/core/communication/HeapInterface$HeapMetadata;", "getFromReflectionOrNull", "", "(Ljava/lang/reflect/Method;)Ljava/lang/Long;", "Companion", "HeapMetadata", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HeapInterface {

    @NotNull
    public static final String HEAP_APP_ID = "happid";

    @NotNull
    public static final String HEAP_SESSION_ID = "hsid";

    @NotNull
    public static final String HEAP_USER_ID = "huu";

    @Nullable
    private Method getEnvironmentIdMethod;

    @Nullable
    private Method getSessionIdMethod;

    @Nullable
    private Method getUserIdMethod;

    @NotNull
    private final Function0<Boolean> isEnabled;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/contentsquare/android/core/communication/HeapInterface$HeapMetadata;", "", OneIDRecoveryContext.SESSION_ID, "", "userId", "appId", "(JJJ)V", "getAppId", "()J", "getSessionId", "getUserId", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class HeapMetadata {
        private final long appId;
        private final long sessionId;
        private final long userId;

        public HeapMetadata(long j, long j2, long j3) {
            this.sessionId = j;
            this.userId = j2;
            this.appId = j3;
        }

        public static /* synthetic */ HeapMetadata copy$default(HeapMetadata heapMetadata, long j, long j2, long j3, int i, Object obj) {
            if ((i & 1) != 0) {
                j = heapMetadata.sessionId;
            }
            long j4 = j;
            if ((i & 2) != 0) {
                j2 = heapMetadata.userId;
            }
            long j5 = j2;
            if ((i & 4) != 0) {
                j3 = heapMetadata.appId;
            }
            return heapMetadata.copy(j4, j5, j3);
        }

        /* renamed from: component1, reason: from getter */
        public final long getSessionId() {
            return this.sessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final long getUserId() {
            return this.userId;
        }

        /* renamed from: component3, reason: from getter */
        public final long getAppId() {
            return this.appId;
        }

        @NotNull
        public final HeapMetadata copy(long sessionId, long userId, long appId) {
            return new HeapMetadata(sessionId, userId, appId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof HeapMetadata)) {
                return false;
            }
            HeapMetadata heapMetadata = (HeapMetadata) other;
            return this.sessionId == heapMetadata.sessionId && this.userId == heapMetadata.userId && this.appId == heapMetadata.appId;
        }

        public final long getAppId() {
            return this.appId;
        }

        public final long getSessionId() {
            return this.sessionId;
        }

        public final long getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return Long.hashCode(this.appId) + ((Long.hashCode(this.userId) + (Long.hashCode(this.sessionId) * 31)) * 31);
        }

        @NotNull
        public String toString() {
            return "HeapMetadata(sessionId=" + this.sessionId + ", userId=" + this.userId + ", appId=" + this.appId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }
    }

    public HeapInterface(Class<?> heapClass, Function0<Boolean> isEnabled) {
        Intrinsics.checkNotNullParameter(heapClass, "heapClass");
        Intrinsics.checkNotNullParameter(isEnabled, "isEnabled");
        this.isEnabled = isEnabled;
        this.getSessionIdMethod = heapClass.getDeclaredMethod("getSessionId", null);
        this.getUserIdMethod = heapClass.getDeclaredMethod("getUserId", null);
        this.getEnvironmentIdMethod = heapClass.getDeclaredMethod("getEnvironmentId", null);
    }

    private final Long getFromReflectionOrNull(Method method) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke = method.invoke(null, null);
        String str = objInvoke instanceof String ? (String) objInvoke : null;
        if (str != null) {
            return StringsKt.toLongOrNull(str);
        }
        return null;
    }

    @Nullable
    public final HeapMetadata getHeapMetadata() {
        if (!this.isEnabled.invoke().booleanValue()) {
            return null;
        }
        Method method = this.getSessionIdMethod;
        Long fromReflectionOrNull = method != null ? getFromReflectionOrNull(method) : null;
        Method method2 = this.getUserIdMethod;
        Long fromReflectionOrNull2 = method2 != null ? getFromReflectionOrNull(method2) : null;
        Method method3 = this.getEnvironmentIdMethod;
        Long fromReflectionOrNull3 = method3 != null ? getFromReflectionOrNull(method3) : null;
        if (fromReflectionOrNull == null || fromReflectionOrNull2 == null || fromReflectionOrNull3 == null) {
            return null;
        }
        return new HeapMetadata(fromReflectionOrNull.longValue(), fromReflectionOrNull2.longValue(), fromReflectionOrNull3.longValue());
    }
}
