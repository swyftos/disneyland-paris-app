package com.urbanairship.android.framework.proxy;

import androidx.exifinterface.media.ExifInterface;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0004*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Companion", "Override", "UseDefault", "Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$Override;", "Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$UseDefault;", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AirshipPluginOverride<T> {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    public /* synthetic */ AirshipPluginOverride(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final Override<Unit> Override() {
        return INSTANCE.Override();
    }

    private AirshipPluginOverride() {
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\t\u0010\b\u001a\u00020\tHÖ\u0001J\t\u0010\n\u001a\u00020\u000bHÖ\u0001¨\u0006\f"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$UseDefault;", "Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride;", "", "()V", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class UseDefault extends AirshipPluginOverride {

        @NotNull
        public static final UseDefault INSTANCE = new UseDefault();

        public boolean equals(@Nullable Object other) {
            return this == other || (other instanceof UseDefault);
        }

        public int hashCode() {
            return 1096946527;
        }

        @NotNull
        public String toString() {
            return "UseDefault";
        }

        private UseDefault() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$Override;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride;", "result", "(Ljava/lang/Object;)V", "getResult", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$Override;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Override<T> extends AirshipPluginOverride<T> {
        private final Object result;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Override copy$default(Override override, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                obj = override.result;
            }
            return override.copy(obj);
        }

        public final T component1() {
            return (T) this.result;
        }

        @NotNull
        public final Override<T> copy(T result) {
            return new Override<>(result);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Override) && Intrinsics.areEqual(this.result, ((Override) other).result);
        }

        public int hashCode() {
            Object obj = this.result;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @NotNull
        public String toString() {
            return "Override(result=" + this.result + ")";
        }

        public Override(T t) {
            super(null);
            this.result = t;
        }

        public final T getResult() {
            return (T) this.result;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0007¨\u0006\u0006"}, d2 = {"Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$Companion;", "", "()V", "Override", "Lcom/urbanairship/android/framework/proxy/AirshipPluginOverride$Override;", "", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final Override<Unit> Override() {
            return new Override<>(Unit.INSTANCE);
        }
    }
}
