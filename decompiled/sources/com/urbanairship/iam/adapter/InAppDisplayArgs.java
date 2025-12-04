package com.urbanairship.iam.adapter;

import androidx.exifinterface.media.ExifInterface;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.ActionRunner;
import com.urbanairship.iam.assets.AirshipCachedAssets;
import com.urbanairship.iam.content.InAppMessageDisplayContent;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B3\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000e\u0010\u0019\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JJ\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001¢\u0006\u0002\u0010\u001fJ\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0003HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/urbanairship/iam/adapter/InAppDisplayArgs;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "", "displayContent", "assets", "Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "displayListener", "Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;", "extras", "Lcom/urbanairship/json/JsonMap;", "actionRunner", "Lcom/urbanairship/actions/ActionRunner;", "(Lcom/urbanairship/iam/content/InAppMessageDisplayContent;Lcom/urbanairship/iam/assets/AirshipCachedAssets;Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/actions/ActionRunner;)V", "getActionRunner", "()Lcom/urbanairship/actions/ActionRunner;", "getAssets", "()Lcom/urbanairship/iam/assets/AirshipCachedAssets;", "getDisplayContent", "()Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "Lcom/urbanairship/iam/content/InAppMessageDisplayContent;", "getDisplayListener", "()Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;", "getExtras", "()Lcom/urbanairship/json/JsonMap;", "component1", "component2", "component3", "component4", "component5", "copy", "(Lcom/urbanairship/iam/content/InAppMessageDisplayContent;Lcom/urbanairship/iam/assets/AirshipCachedAssets;Lcom/urbanairship/iam/adapter/InAppMessageDisplayListener;Lcom/urbanairship/json/JsonMap;Lcom/urbanairship/actions/ActionRunner;)Lcom/urbanairship/iam/adapter/InAppDisplayArgs;", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InAppDisplayArgs<T extends InAppMessageDisplayContent> {
    private final ActionRunner actionRunner;
    private final AirshipCachedAssets assets;
    private final InAppMessageDisplayContent displayContent;
    private final InAppMessageDisplayListener displayListener;
    private final JsonMap extras;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.urbanairship.iam.content.InAppMessageDisplayContent] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.urbanairship.iam.content.InAppMessageDisplayContent] */
    public static /* synthetic */ InAppDisplayArgs copy$default(InAppDisplayArgs inAppDisplayArgs, InAppMessageDisplayContent inAppMessageDisplayContent, AirshipCachedAssets airshipCachedAssets, InAppMessageDisplayListener inAppMessageDisplayListener, JsonMap jsonMap, ActionRunner actionRunner, int i, Object obj) {
        T t = inAppMessageDisplayContent;
        if ((i & 1) != 0) {
            t = inAppDisplayArgs.displayContent;
        }
        if ((i & 2) != 0) {
            airshipCachedAssets = inAppDisplayArgs.assets;
        }
        AirshipCachedAssets airshipCachedAssets2 = airshipCachedAssets;
        if ((i & 4) != 0) {
            inAppMessageDisplayListener = inAppDisplayArgs.displayListener;
        }
        InAppMessageDisplayListener inAppMessageDisplayListener2 = inAppMessageDisplayListener;
        if ((i & 8) != 0) {
            jsonMap = inAppDisplayArgs.extras;
        }
        JsonMap jsonMap2 = jsonMap;
        if ((i & 16) != 0) {
            actionRunner = inAppDisplayArgs.actionRunner;
        }
        return inAppDisplayArgs.copy(t, airshipCachedAssets2, inAppMessageDisplayListener2, jsonMap2, actionRunner);
    }

    @NotNull
    public final T component1() {
        return (T) this.displayContent;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final AirshipCachedAssets getAssets() {
        return this.assets;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final InAppMessageDisplayListener getDisplayListener() {
        return this.displayListener;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final JsonMap getExtras() {
        return this.extras;
    }

    @NotNull
    /* renamed from: component5, reason: from getter */
    public final ActionRunner getActionRunner() {
        return this.actionRunner;
    }

    @NotNull
    public final InAppDisplayArgs<T> copy(@NotNull T displayContent, @Nullable AirshipCachedAssets assets, @NotNull InAppMessageDisplayListener displayListener, @Nullable JsonMap extras, @NotNull ActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        return new InAppDisplayArgs<>(displayContent, assets, displayListener, extras, actionRunner);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppDisplayArgs)) {
            return false;
        }
        InAppDisplayArgs inAppDisplayArgs = (InAppDisplayArgs) other;
        return Intrinsics.areEqual(this.displayContent, inAppDisplayArgs.displayContent) && Intrinsics.areEqual(this.assets, inAppDisplayArgs.assets) && Intrinsics.areEqual(this.displayListener, inAppDisplayArgs.displayListener) && Intrinsics.areEqual(this.extras, inAppDisplayArgs.extras) && Intrinsics.areEqual(this.actionRunner, inAppDisplayArgs.actionRunner);
    }

    public int hashCode() {
        int iHashCode = this.displayContent.hashCode() * 31;
        AirshipCachedAssets airshipCachedAssets = this.assets;
        int iHashCode2 = (((iHashCode + (airshipCachedAssets == null ? 0 : airshipCachedAssets.hashCode())) * 31) + this.displayListener.hashCode()) * 31;
        JsonMap jsonMap = this.extras;
        return ((iHashCode2 + (jsonMap != null ? jsonMap.hashCode() : 0)) * 31) + this.actionRunner.hashCode();
    }

    @NotNull
    public String toString() {
        return "InAppDisplayArgs(displayContent=" + this.displayContent + ", assets=" + this.assets + ", displayListener=" + this.displayListener + ", extras=" + this.extras + ", actionRunner=" + this.actionRunner + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public InAppDisplayArgs(@NotNull T displayContent, @Nullable AirshipCachedAssets airshipCachedAssets, @NotNull InAppMessageDisplayListener displayListener, @Nullable JsonMap jsonMap, @NotNull ActionRunner actionRunner) {
        Intrinsics.checkNotNullParameter(displayContent, "displayContent");
        Intrinsics.checkNotNullParameter(displayListener, "displayListener");
        Intrinsics.checkNotNullParameter(actionRunner, "actionRunner");
        this.displayContent = displayContent;
        this.assets = airshipCachedAssets;
        this.displayListener = displayListener;
        this.extras = jsonMap;
        this.actionRunner = actionRunner;
    }

    public /* synthetic */ InAppDisplayArgs(InAppMessageDisplayContent inAppMessageDisplayContent, AirshipCachedAssets airshipCachedAssets, InAppMessageDisplayListener inAppMessageDisplayListener, JsonMap jsonMap, ActionRunner actionRunner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(inAppMessageDisplayContent, airshipCachedAssets, inAppMessageDisplayListener, (i & 8) != 0 ? null : jsonMap, actionRunner);
    }

    @NotNull
    public final T getDisplayContent() {
        return (T) this.displayContent;
    }

    @Nullable
    public final AirshipCachedAssets getAssets() {
        return this.assets;
    }

    @NotNull
    public final InAppMessageDisplayListener getDisplayListener() {
        return this.displayListener;
    }

    @Nullable
    public final JsonMap getExtras() {
        return this.extras;
    }

    @NotNull
    public final ActionRunner getActionRunner() {
        return this.actionRunner;
    }
}
