package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/urbanairship/android/framework/proxy/SubscriptionListOperation;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "listId", "", "action", "Lcom/urbanairship/android/framework/proxy/SubscriptionListOperationAction;", "(Ljava/lang/String;Lcom/urbanairship/android/framework/proxy/SubscriptionListOperationAction;)V", "getAction", "()Lcom/urbanairship/android/framework/proxy/SubscriptionListOperationAction;", "getListId", "()Ljava/lang/String;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SubscriptionListOperation {
    private final SubscriptionListOperationAction action;
    private final String listId;

    public static /* synthetic */ SubscriptionListOperation copy$default(SubscriptionListOperation subscriptionListOperation, String str, SubscriptionListOperationAction subscriptionListOperationAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subscriptionListOperation.listId;
        }
        if ((i & 2) != 0) {
            subscriptionListOperationAction = subscriptionListOperation.action;
        }
        return subscriptionListOperation.copy(str, subscriptionListOperationAction);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final SubscriptionListOperationAction getAction() {
        return this.action;
    }

    @NotNull
    public final SubscriptionListOperation copy(@NotNull String listId, @NotNull SubscriptionListOperationAction action) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(action, "action");
        return new SubscriptionListOperation(listId, action);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionListOperation)) {
            return false;
        }
        SubscriptionListOperation subscriptionListOperation = (SubscriptionListOperation) other;
        return Intrinsics.areEqual(this.listId, subscriptionListOperation.listId) && this.action == subscriptionListOperation.action;
    }

    public int hashCode() {
        return (this.listId.hashCode() * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "SubscriptionListOperation(listId=" + this.listId + ", action=" + this.action + ")";
    }

    public SubscriptionListOperation(@NotNull String listId, @NotNull SubscriptionListOperationAction action) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(action, "action");
        this.listId = listId;
        this.action = action;
    }

    @NotNull
    public final String getListId() {
        return this.listId;
    }

    @NotNull
    public final SubscriptionListOperationAction getAction() {
        return this.action;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public SubscriptionListOperation(@NotNull JsonMap json) throws JsonException {
        Intrinsics.checkNotNullParameter(json, "json");
        String strRequireString = json.require("listId").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
        String strRequireString2 = json.require("action").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString2, "requireString(...)");
        String upperCase = strRequireString2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this(strRequireString, SubscriptionListOperationAction.valueOf(upperCase));
    }
}
