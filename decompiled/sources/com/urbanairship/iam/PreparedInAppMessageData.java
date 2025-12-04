package com.urbanairship.iam;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.iam.actions.InAppActionRunner;
import com.urbanairship.iam.adapter.DisplayAdapter;
import com.urbanairship.iam.analytics.InAppMessageAnalyticsInterface;
import com.urbanairship.iam.coordinator.DisplayCoordinator;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\u000bHÆ\u0003J;\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, d2 = {"Lcom/urbanairship/iam/PreparedInAppMessageData;", "", "message", "Lcom/urbanairship/iam/InAppMessage;", "displayAdapter", "Lcom/urbanairship/iam/adapter/DisplayAdapter;", "displayCoordinator", "Lcom/urbanairship/iam/coordinator/DisplayCoordinator;", AirshipConfigOptions.FEATURE_ANALYTICS, "Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "actionRunner", "Lcom/urbanairship/iam/actions/InAppActionRunner;", "(Lcom/urbanairship/iam/InAppMessage;Lcom/urbanairship/iam/adapter/DisplayAdapter;Lcom/urbanairship/iam/coordinator/DisplayCoordinator;Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;Lcom/urbanairship/iam/actions/InAppActionRunner;)V", "getActionRunner", "()Lcom/urbanairship/iam/actions/InAppActionRunner;", "getAnalytics", "()Lcom/urbanairship/iam/analytics/InAppMessageAnalyticsInterface;", "getDisplayAdapter", "()Lcom/urbanairship/iam/adapter/DisplayAdapter;", "getDisplayCoordinator", "()Lcom/urbanairship/iam/coordinator/DisplayCoordinator;", "getMessage", "()Lcom/urbanairship/iam/InAppMessage;", "component1", "component2", "component3", "component4", "component5", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class PreparedInAppMessageData {
    private final InAppActionRunner actionRunner;
    private final InAppMessageAnalyticsInterface analytics;
    private final DisplayAdapter displayAdapter;
    private final DisplayCoordinator displayCoordinator;
    private final InAppMessage message;

    public static /* synthetic */ PreparedInAppMessageData copy$default(PreparedInAppMessageData preparedInAppMessageData, InAppMessage inAppMessage, DisplayAdapter displayAdapter, DisplayCoordinator displayCoordinator, InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface, InAppActionRunner inAppActionRunner, int i, Object obj) {
        if ((i & 1) != 0) {
            inAppMessage = preparedInAppMessageData.message;
        }
        if ((i & 2) != 0) {
            displayAdapter = preparedInAppMessageData.displayAdapter;
        }
        DisplayAdapter displayAdapter2 = displayAdapter;
        if ((i & 4) != 0) {
            displayCoordinator = preparedInAppMessageData.displayCoordinator;
        }
        DisplayCoordinator displayCoordinator2 = displayCoordinator;
        if ((i & 8) != 0) {
            inAppMessageAnalyticsInterface = preparedInAppMessageData.analytics;
        }
        InAppMessageAnalyticsInterface inAppMessageAnalyticsInterface2 = inAppMessageAnalyticsInterface;
        if ((i & 16) != 0) {
            inAppActionRunner = preparedInAppMessageData.actionRunner;
        }
        return preparedInAppMessageData.copy(inAppMessage, displayAdapter2, displayCoordinator2, inAppMessageAnalyticsInterface2, inAppActionRunner);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final InAppMessage getMessage() {
        return this.message;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final DisplayAdapter getDisplayAdapter() {
        return this.displayAdapter;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final DisplayCoordinator getDisplayCoordinator() {
        return this.displayCoordinator;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final InAppMessageAnalyticsInterface getAnalytics() {
        return this.analytics;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final InAppActionRunner getActionRunner() {
        return this.actionRunner;
    }

    @NotNull
    public final PreparedInAppMessageData copy(@NotNull InAppMessage message, @NotNull DisplayAdapter displayAdapter, @NotNull DisplayCoordinator displayCoordinator, @NotNull InAppMessageAnalyticsInterface analytics, @NotNull InAppActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(displayAdapter, "displayAdapter");
        Intrinsics.checkNotNullParameter(displayCoordinator, "displayCoordinator");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        return new PreparedInAppMessageData(message, displayAdapter, displayCoordinator, analytics, actionRunner);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PreparedInAppMessageData)) {
            return false;
        }
        PreparedInAppMessageData preparedInAppMessageData = (PreparedInAppMessageData) other;
        return Intrinsics.areEqual(this.message, preparedInAppMessageData.message) && Intrinsics.areEqual(this.displayAdapter, preparedInAppMessageData.displayAdapter) && Intrinsics.areEqual(this.displayCoordinator, preparedInAppMessageData.displayCoordinator) && Intrinsics.areEqual(this.analytics, preparedInAppMessageData.analytics) && Intrinsics.areEqual(this.actionRunner, preparedInAppMessageData.actionRunner);
    }

    public int hashCode() {
        return (((((((this.message.hashCode() * 31) + this.displayAdapter.hashCode()) * 31) + this.displayCoordinator.hashCode()) * 31) + this.analytics.hashCode()) * 31) + this.actionRunner.hashCode();
    }

    @NotNull
    public String toString() {
        return "PreparedInAppMessageData(message=" + this.message + ", displayAdapter=" + this.displayAdapter + ", displayCoordinator=" + this.displayCoordinator + ", analytics=" + this.analytics + ", actionRunner=" + this.actionRunner + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PreparedInAppMessageData(@NotNull InAppMessage message, @NotNull DisplayAdapter displayAdapter, @NotNull DisplayCoordinator displayCoordinator, @NotNull InAppMessageAnalyticsInterface analytics, @NotNull InAppActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(displayAdapter, "displayAdapter");
        Intrinsics.checkNotNullParameter(displayCoordinator, "displayCoordinator");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.message = message;
        this.displayAdapter = displayAdapter;
        this.displayCoordinator = displayCoordinator;
        this.analytics = analytics;
        this.actionRunner = actionRunner;
    }

    @NotNull
    public final InAppMessage getMessage() {
        return this.message;
    }

    @NotNull
    public final DisplayAdapter getDisplayAdapter() {
        return this.displayAdapter;
    }

    @NotNull
    public final DisplayCoordinator getDisplayCoordinator() {
        return this.displayCoordinator;
    }

    @NotNull
    public final InAppMessageAnalyticsInterface getAnalytics() {
        return this.analytics;
    }

    @NotNull
    public final InAppActionRunner getActionRunner() {
        return this.actionRunner;
    }
}
