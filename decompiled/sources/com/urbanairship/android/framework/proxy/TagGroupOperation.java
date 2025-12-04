package com.urbanairship.android.framework.proxy;

import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.actions.FetchDeviceInfoAction;
import com.urbanairship.json.JsonException;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\t\u0010\u0014\u001a\u00020\nHÆ\u0003J-\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/urbanairship/android/framework/proxy/TagGroupOperation;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "group", "", FetchDeviceInfoAction.TAGS_KEY, "", "action", "Lcom/urbanairship/android/framework/proxy/TagGroupOperationAction;", "(Ljava/lang/String;Ljava/util/List;Lcom/urbanairship/android/framework/proxy/TagGroupOperationAction;)V", "getAction", "()Lcom/urbanairship/android/framework/proxy/TagGroupOperationAction;", "getGroup", "()Ljava/lang/String;", "getTags", "()Ljava/util/List;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTagGroupOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagGroupOperation.kt\ncom/urbanairship/android/framework/proxy/TagGroupOperation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,31:1\n1549#2:32\n1620#2,3:33\n*S KotlinDebug\n*F\n+ 1 TagGroupOperation.kt\ncom/urbanairship/android/framework/proxy/TagGroupOperation\n*L\n17#1:32\n17#1:33,3\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class TagGroupOperation {
    private final TagGroupOperationAction action;
    private final String group;
    private final List tags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagGroupOperation copy$default(TagGroupOperation tagGroupOperation, String str, List list, TagGroupOperationAction tagGroupOperationAction, int i, Object obj) {
        if ((i & 1) != 0) {
            str = tagGroupOperation.group;
        }
        if ((i & 2) != 0) {
            list = tagGroupOperation.tags;
        }
        if ((i & 4) != 0) {
            tagGroupOperationAction = tagGroupOperation.action;
        }
        return tagGroupOperation.copy(str, list, tagGroupOperationAction);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    @NotNull
    public final List<String> component2() {
        return this.tags;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final TagGroupOperationAction getAction() {
        return this.action;
    }

    @NotNull
    public final TagGroupOperation copy(@NotNull String group, @NotNull List<String> tags, @NotNull TagGroupOperationAction action) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(action, "action");
        return new TagGroupOperation(group, tags, action);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagGroupOperation)) {
            return false;
        }
        TagGroupOperation tagGroupOperation = (TagGroupOperation) other;
        return Intrinsics.areEqual(this.group, tagGroupOperation.group) && Intrinsics.areEqual(this.tags, tagGroupOperation.tags) && this.action == tagGroupOperation.action;
    }

    public int hashCode() {
        return (((this.group.hashCode() * 31) + this.tags.hashCode()) * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "TagGroupOperation(group=" + this.group + ", tags=" + this.tags + ", action=" + this.action + ")";
    }

    public TagGroupOperation(@NotNull String group, @NotNull List<String> tags, @NotNull TagGroupOperationAction action) {
        Intrinsics.checkNotNullParameter(group, "group");
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(action, "action");
        this.group = group;
        this.tags = tags;
        this.action = action;
    }

    @NotNull
    public final String getGroup() {
        return this.group;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @NotNull
    public final TagGroupOperationAction getAction() {
        return this.action;
    }

    public TagGroupOperation(@NotNull JsonMap json) throws JsonException {
        Intrinsics.checkNotNullParameter(json, "json");
        String strRequireString = json.require("group").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
        JsonList jsonListRequireList = json.require(FetchDeviceInfoAction.TAGS_KEY).requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it = jsonListRequireList.iterator();
        while (it.hasNext()) {
            String strRequireString2 = it.next().requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString2, "requireString(...)");
            arrayList.add(strRequireString2);
        }
        String strRequireString3 = json.require("operationType").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString3, "requireString(...)");
        String upperCase = strRequireString3.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this(strRequireString, arrayList, TagGroupOperationAction.valueOf(upperCase));
    }
}
