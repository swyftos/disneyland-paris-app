package com.allegion.accesssdk.actions;

import android.app.Application;
import androidx.media3.common.MimeTypes;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.HashMap;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0080\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u00052\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\r\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b\u001f\u0010\u000b¨\u0006\""}, d2 = {"Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "", "Ljava/util/UUID;", "component1", "()Ljava/util/UUID;", "Landroid/app/Application;", "component2", "()Landroid/app/Application;", "Ljava/util/HashMap;", "", "component3", "()Ljava/util/HashMap;", "subscriptionKey", MimeTypes.BASE_TYPE_APPLICATION, "pinSet", "copy", "(Ljava/util/UUID;Landroid/app/Application;Ljava/util/HashMap;)Lcom/allegion/accesssdk/actions/AlImmutableConfig;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", ETCPaymentMethod.OTHER, "", ExactValueMatcher.EQUALS_VALUE_KEY, "(Ljava/lang/Object;)Z", "Landroid/app/Application;", "getApplication", "Ljava/util/UUID;", "getSubscriptionKey", "Ljava/util/HashMap;", "getPinSet", "<init>", "(Ljava/util/UUID;Landroid/app/Application;Ljava/util/HashMap;)V", "AccessSdk_qaRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final /* data */ class AlImmutableConfig {

    @NotNull
    private final Application application;

    @NotNull
    private final HashMap<String, String> pinSet;

    @NotNull
    private final UUID subscriptionKey;

    public AlImmutableConfig(@NotNull UUID subscriptionKey, @NotNull Application application, @NotNull HashMap<String, String> pinSet) {
        Intrinsics.checkParameterIsNotNull(subscriptionKey, "subscriptionKey");
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(pinSet, "pinSet");
        this.subscriptionKey = subscriptionKey;
        this.application = application;
        this.pinSet = pinSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlImmutableConfig copy$default(AlImmutableConfig alImmutableConfig, UUID uuid, Application application, HashMap map, int i, Object obj) {
        if ((i & 1) != 0) {
            uuid = alImmutableConfig.subscriptionKey;
        }
        if ((i & 2) != 0) {
            application = alImmutableConfig.application;
        }
        if ((i & 4) != 0) {
            map = alImmutableConfig.pinSet;
        }
        return alImmutableConfig.copy(uuid, application, map);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final UUID getSubscriptionKey() {
        return this.subscriptionKey;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    @NotNull
    public final HashMap<String, String> component3() {
        return this.pinSet;
    }

    @NotNull
    public final AlImmutableConfig copy(@NotNull UUID subscriptionKey, @NotNull Application application, @NotNull HashMap<String, String> pinSet) {
        Intrinsics.checkParameterIsNotNull(subscriptionKey, "subscriptionKey");
        Intrinsics.checkParameterIsNotNull(application, "application");
        Intrinsics.checkParameterIsNotNull(pinSet, "pinSet");
        return new AlImmutableConfig(subscriptionKey, application, pinSet);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AlImmutableConfig)) {
            return false;
        }
        AlImmutableConfig alImmutableConfig = (AlImmutableConfig) other;
        return Intrinsics.areEqual(this.subscriptionKey, alImmutableConfig.subscriptionKey) && Intrinsics.areEqual(this.application, alImmutableConfig.application) && Intrinsics.areEqual(this.pinSet, alImmutableConfig.pinSet);
    }

    @NotNull
    public final Application getApplication() {
        return this.application;
    }

    @NotNull
    public final HashMap<String, String> getPinSet() {
        return this.pinSet;
    }

    @NotNull
    public final UUID getSubscriptionKey() {
        return this.subscriptionKey;
    }

    public int hashCode() {
        UUID uuid = this.subscriptionKey;
        int iHashCode = (uuid != null ? uuid.hashCode() : 0) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application != null ? application.hashCode() : 0)) * 31;
        HashMap<String, String> map = this.pinSet;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AlImmutableConfig(subscriptionKey=" + this.subscriptionKey + ", application=" + this.application + ", pinSet=" + this.pinSet + ")";
    }
}
