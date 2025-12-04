package com.disney.id.android;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/disney/id/android/ConfigData;", "", "bundleVersion", "", "bundlerURL", "previousState", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getBundleVersion", "()Ljava/lang/String;", "getBundlerURL", "getPreviousState", "()Z", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "hashCode", "", "toString", "OneID_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ConfigData {
    private final String bundleVersion;
    private final String bundlerURL;
    private final boolean previousState;

    public static /* synthetic */ ConfigData copy$default(ConfigData configData, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = configData.bundleVersion;
        }
        if ((i & 2) != 0) {
            str2 = configData.bundlerURL;
        }
        if ((i & 4) != 0) {
            z = configData.previousState;
        }
        return configData.copy(str, str2, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getBundleVersion() {
        return this.bundleVersion;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getBundlerURL() {
        return this.bundlerURL;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPreviousState() {
        return this.previousState;
    }

    @NotNull
    public final ConfigData copy(@NotNull String bundleVersion, @NotNull String bundlerURL, boolean previousState) {
        Intrinsics.checkNotNullParameter(bundleVersion, "bundleVersion");
        Intrinsics.checkNotNullParameter(bundlerURL, "bundlerURL");
        return new ConfigData(bundleVersion, bundlerURL, previousState);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConfigData)) {
            return false;
        }
        ConfigData configData = (ConfigData) other;
        return Intrinsics.areEqual(this.bundleVersion, configData.bundleVersion) && Intrinsics.areEqual(this.bundlerURL, configData.bundlerURL) && this.previousState == configData.previousState;
    }

    public int hashCode() {
        return (((this.bundleVersion.hashCode() * 31) + this.bundlerURL.hashCode()) * 31) + Boolean.hashCode(this.previousState);
    }

    @NotNull
    public String toString() {
        return "ConfigData(bundleVersion=" + this.bundleVersion + ", bundlerURL=" + this.bundlerURL + ", previousState=" + this.previousState + ")";
    }

    public ConfigData(@NotNull String bundleVersion, @NotNull String bundlerURL, boolean z) {
        Intrinsics.checkNotNullParameter(bundleVersion, "bundleVersion");
        Intrinsics.checkNotNullParameter(bundlerURL, "bundlerURL");
        this.bundleVersion = bundleVersion;
        this.bundlerURL = bundlerURL;
        this.previousState = z;
    }

    public /* synthetic */ ConfigData(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z);
    }

    @NotNull
    public final String getBundleVersion() {
        return this.bundleVersion;
    }

    @NotNull
    public final String getBundlerURL() {
        return this.bundlerURL;
    }

    public final boolean getPreviousState() {
        return this.previousState;
    }
}
