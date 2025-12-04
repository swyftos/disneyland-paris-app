package com.urbanairship.android.framework.proxy;

import ch.qos.logback.core.joran.action.Action;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.contacts.Scope;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001d\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J'\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/framework/proxy/ScopedSubscriptionListOperation;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "listId", "", Action.SCOPE_ATTRIBUTE, "Lcom/urbanairship/contacts/Scope;", "action", "Lcom/urbanairship/android/framework/proxy/SubscriptionListOperationAction;", "(Ljava/lang/String;Lcom/urbanairship/contacts/Scope;Lcom/urbanairship/android/framework/proxy/SubscriptionListOperationAction;)V", "getAction", "()Lcom/urbanairship/android/framework/proxy/SubscriptionListOperationAction;", "getListId", "()Ljava/lang/String;", "getScope", "()Lcom/urbanairship/contacts/Scope;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ScopedSubscriptionListOperation {
    private final SubscriptionListOperationAction action;
    private final String listId;
    private final Scope scope;

    public static /* synthetic */ ScopedSubscriptionListOperation copy$default(ScopedSubscriptionListOperation scopedSubscriptionListOperation, String str, Scope scope, SubscriptionListOperationAction subscriptionListOperationAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = scopedSubscriptionListOperation.listId;
        }
        if ((i & 2) != 0) {
            scope = scopedSubscriptionListOperation.scope;
        }
        if ((i & 4) != 0) {
            subscriptionListOperationAction = scopedSubscriptionListOperation.action;
        }
        return scopedSubscriptionListOperation.copy(str, scope, subscriptionListOperationAction);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getListId() {
        return this.listId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final Scope getScope() {
        return this.scope;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final SubscriptionListOperationAction getAction() {
        return this.action;
    }

    @NotNull
    public final ScopedSubscriptionListOperation copy(@NotNull String listId, @NotNull Scope scope, @NotNull SubscriptionListOperationAction action) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(action, "action");
        return new ScopedSubscriptionListOperation(listId, scope, action);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ScopedSubscriptionListOperation)) {
            return false;
        }
        ScopedSubscriptionListOperation scopedSubscriptionListOperation = (ScopedSubscriptionListOperation) other;
        return Intrinsics.areEqual(this.listId, scopedSubscriptionListOperation.listId) && this.scope == scopedSubscriptionListOperation.scope && this.action == scopedSubscriptionListOperation.action;
    }

    public int hashCode() {
        return (((this.listId.hashCode() * 31) + this.scope.hashCode()) * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "ScopedSubscriptionListOperation(listId=" + this.listId + ", scope=" + this.scope + ", action=" + this.action + ")";
    }

    public ScopedSubscriptionListOperation(@NotNull String listId, @NotNull Scope scope, @NotNull SubscriptionListOperationAction action) {
        Intrinsics.checkNotNullParameter(listId, "listId");
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(action, "action");
        this.listId = listId;
        this.scope = scope;
        this.action = action;
    }

    @NotNull
    public final String getListId() {
        return this.listId;
    }

    @NotNull
    public final Scope getScope() {
        return this.scope;
    }

    @NotNull
    public final SubscriptionListOperationAction getAction() {
        return this.action;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ScopedSubscriptionListOperation(@NotNull JsonMap json) throws JsonException {
        Intrinsics.checkNotNullParameter(json, "json");
        String strRequireString = json.require("listId").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
        String strRequireString2 = json.require(Action.SCOPE_ATTRIBUTE).requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString2, "requireString(...)");
        Locale locale = Locale.ROOT;
        String upperCase = strRequireString2.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        Scope scopeValueOf = Scope.valueOf(upperCase);
        String strRequireString3 = json.require("action").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString3, "requireString(...)");
        String upperCase2 = strRequireString3.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
        this(strRequireString, scopeValueOf, SubscriptionListOperationAction.valueOf(upperCase2));
    }
}
