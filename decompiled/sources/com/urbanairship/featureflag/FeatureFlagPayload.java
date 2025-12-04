package com.urbanairship.featureflag;

import android.net.Uri;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagPayload;", "", "()V", "DeferredPayload", "StaticPayload", "Lcom/urbanairship/featureflag/FeatureFlagPayload$DeferredPayload;", "Lcom/urbanairship/featureflag/FeatureFlagPayload$StaticPayload;", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class FeatureFlagPayload {
    public /* synthetic */ FeatureFlagPayload(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagPayload$DeferredPayload;", "Lcom/urbanairship/featureflag/FeatureFlagPayload;", "url", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUrl", "()Landroid/net/Uri;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DeferredPayload extends FeatureFlagPayload {
        private final Uri url;

        public static /* synthetic */ DeferredPayload copy$default(DeferredPayload deferredPayload, Uri uri, int i, Object obj) {
            if ((i & 1) != 0) {
                uri = deferredPayload.url;
            }
            return deferredPayload.copy(uri);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final Uri getUrl() {
            return this.url;
        }

        @NotNull
        public final DeferredPayload copy(@NotNull Uri url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new DeferredPayload(url);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DeferredPayload) && Intrinsics.areEqual(this.url, ((DeferredPayload) other).url);
        }

        public int hashCode() {
            return this.url.hashCode();
        }

        @NotNull
        public String toString() {
            return "DeferredPayload(url=" + this.url + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DeferredPayload(@NotNull Uri url) {
            super(null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
        }

        @NotNull
        public final Uri getUrl() {
            return this.url;
        }
    }

    private FeatureFlagPayload() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/urbanairship/featureflag/FeatureFlagPayload$StaticPayload;", "Lcom/urbanairship/featureflag/FeatureFlagPayload;", "variables", "Lcom/urbanairship/featureflag/FeatureFlagVariables;", "(Lcom/urbanairship/featureflag/FeatureFlagVariables;)V", "getVariables", "()Lcom/urbanairship/featureflag/FeatureFlagVariables;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toString", "", "urbanairship-feature-flag_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class StaticPayload extends FeatureFlagPayload {
        private final FeatureFlagVariables variables;

        public StaticPayload() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ StaticPayload copy$default(StaticPayload staticPayload, FeatureFlagVariables featureFlagVariables, int i, Object obj) {
            if ((i & 1) != 0) {
                featureFlagVariables = staticPayload.variables;
            }
            return staticPayload.copy(featureFlagVariables);
        }

        @Nullable
        /* renamed from: component1, reason: from getter */
        public final FeatureFlagVariables getVariables() {
            return this.variables;
        }

        @NotNull
        public final StaticPayload copy(@Nullable FeatureFlagVariables variables) {
            return new StaticPayload(variables);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof StaticPayload) && Intrinsics.areEqual(this.variables, ((StaticPayload) other).variables);
        }

        public int hashCode() {
            FeatureFlagVariables featureFlagVariables = this.variables;
            if (featureFlagVariables == null) {
                return 0;
            }
            return featureFlagVariables.hashCode();
        }

        @NotNull
        public String toString() {
            return "StaticPayload(variables=" + this.variables + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public StaticPayload(@Nullable FeatureFlagVariables featureFlagVariables) {
            super(null);
            this.variables = featureFlagVariables;
        }

        public /* synthetic */ StaticPayload(FeatureFlagVariables featureFlagVariables, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : featureFlagVariables);
        }

        @Nullable
        public final FeatureFlagVariables getVariables() {
            return this.variables;
        }
    }
}
