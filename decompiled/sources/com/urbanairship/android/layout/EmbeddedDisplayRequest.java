package com.urbanairship.android.layout;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.display.DisplayArgs;
import com.urbanairship.android.layout.info.LayoutInfo;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\u0002\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0003JS\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010#\u001a\u00020\u0006H\u0016J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\n¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012¨\u0006%"}, d2 = {"Lcom/urbanairship/android/layout/EmbeddedDisplayRequest;", "", "embeddedViewId", "", "viewInstanceId", Constants.FirelogAnalytics.PARAM_PRIORITY, "", "extras", "Lcom/urbanairship/json/JsonMap;", "layoutInfoProvider", "Lkotlin/Function0;", "Lcom/urbanairship/android/layout/info/LayoutInfo;", "displayArgsProvider", "Lcom/urbanairship/android/layout/display/DisplayArgs;", "(Ljava/lang/String;Ljava/lang/String;ILcom/urbanairship/json/JsonMap;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "getDisplayArgsProvider", "()Lkotlin/jvm/functions/Function0;", "getEmbeddedViewId", "()Ljava/lang/String;", "getExtras", "()Lcom/urbanairship/json/JsonMap;", "getLayoutInfoProvider", "getPriority", "()I", "getViewInstanceId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "toString", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class EmbeddedDisplayRequest {
    private final Function0 displayArgsProvider;
    private final String embeddedViewId;
    private final JsonMap extras;
    private final Function0 layoutInfoProvider;
    private final int priority;
    private final String viewInstanceId;

    public static /* synthetic */ EmbeddedDisplayRequest copy$default(EmbeddedDisplayRequest embeddedDisplayRequest, String str, String str2, int i, JsonMap jsonMap, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = embeddedDisplayRequest.embeddedViewId;
        }
        if ((i2 & 2) != 0) {
            str2 = embeddedDisplayRequest.viewInstanceId;
        }
        String str3 = str2;
        if ((i2 & 4) != 0) {
            i = embeddedDisplayRequest.priority;
        }
        int i3 = i;
        if ((i2 & 8) != 0) {
            jsonMap = embeddedDisplayRequest.extras;
        }
        JsonMap jsonMap2 = jsonMap;
        if ((i2 & 16) != 0) {
            function0 = embeddedDisplayRequest.layoutInfoProvider;
        }
        Function0 function03 = function0;
        if ((i2 & 32) != 0) {
            function02 = embeddedDisplayRequest.displayArgsProvider;
        }
        return embeddedDisplayRequest.copy(str, str3, i3, jsonMap2, function03, function02);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getEmbeddedViewId() {
        return this.embeddedViewId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getViewInstanceId() {
        return this.viewInstanceId;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    /* renamed from: component4, reason: from getter */
    public final JsonMap getExtras() {
        return this.extras;
    }

    @NotNull
    public final Function0<LayoutInfo> component5() {
        return this.layoutInfoProvider;
    }

    @NotNull
    public final Function0<DisplayArgs> component6() {
        return this.displayArgsProvider;
    }

    @NotNull
    public final EmbeddedDisplayRequest copy(@NotNull String embeddedViewId, @NotNull String viewInstanceId, int priority, @NotNull JsonMap extras, @NotNull Function0<LayoutInfo> layoutInfoProvider, @NotNull Function0<DisplayArgs> displayArgsProvider) {
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Intrinsics.checkNotNullParameter(viewInstanceId, "viewInstanceId");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(layoutInfoProvider, "layoutInfoProvider");
        Intrinsics.checkNotNullParameter(displayArgsProvider, "displayArgsProvider");
        return new EmbeddedDisplayRequest(embeddedViewId, viewInstanceId, priority, extras, layoutInfoProvider, displayArgsProvider);
    }

    @NotNull
    public String toString() {
        return "EmbeddedDisplayRequest(embeddedViewId=" + this.embeddedViewId + ", viewInstanceId=" + this.viewInstanceId + ", priority=" + this.priority + ", extras=" + this.extras + ", layoutInfoProvider=" + this.layoutInfoProvider + ", displayArgsProvider=" + this.displayArgsProvider + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public EmbeddedDisplayRequest(@NotNull String embeddedViewId, @NotNull String viewInstanceId, int i, @NotNull JsonMap extras, @NotNull Function0<LayoutInfo> layoutInfoProvider, @NotNull Function0<DisplayArgs> displayArgsProvider) {
        Intrinsics.checkNotNullParameter(embeddedViewId, "embeddedViewId");
        Intrinsics.checkNotNullParameter(viewInstanceId, "viewInstanceId");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(layoutInfoProvider, "layoutInfoProvider");
        Intrinsics.checkNotNullParameter(displayArgsProvider, "displayArgsProvider");
        this.embeddedViewId = embeddedViewId;
        this.viewInstanceId = viewInstanceId;
        this.priority = i;
        this.extras = extras;
        this.layoutInfoProvider = layoutInfoProvider;
        this.displayArgsProvider = displayArgsProvider;
    }

    @NotNull
    public final String getEmbeddedViewId() {
        return this.embeddedViewId;
    }

    @NotNull
    public final String getViewInstanceId() {
        return this.viewInstanceId;
    }

    public final int getPriority() {
        return this.priority;
    }

    @NotNull
    public final JsonMap getExtras() {
        return this.extras;
    }

    @NotNull
    public final Function0<LayoutInfo> getLayoutInfoProvider() {
        return this.layoutInfoProvider;
    }

    @NotNull
    public final Function0<DisplayArgs> getDisplayArgsProvider() {
        return this.displayArgsProvider;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(EmbeddedDisplayRequest.class, other != null ? other.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(other, "null cannot be cast to non-null type com.urbanairship.android.layout.EmbeddedDisplayRequest");
        EmbeddedDisplayRequest embeddedDisplayRequest = (EmbeddedDisplayRequest) other;
        return Intrinsics.areEqual(this.embeddedViewId, embeddedDisplayRequest.embeddedViewId) && Intrinsics.areEqual(this.viewInstanceId, embeddedDisplayRequest.viewInstanceId) && Intrinsics.areEqual(this.extras, embeddedDisplayRequest.extras);
    }

    public int hashCode() {
        return Objects.hash(this.embeddedViewId, this.viewInstanceId, this.extras);
    }
}
