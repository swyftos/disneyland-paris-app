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

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u001b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\tHÆ\u0003J#\u0010\u0011\u001a\u00020\u00002\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/urbanairship/android/framework/proxy/TagOperation;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", FetchDeviceInfoAction.TAGS_KEY, "", "", "action", "Lcom/urbanairship/android/framework/proxy/TagOperationAction;", "(Ljava/util/List;Lcom/urbanairship/android/framework/proxy/TagOperationAction;)V", "getAction", "()Lcom/urbanairship/android/framework/proxy/TagOperationAction;", "getTags", "()Ljava/util/List;", "component1", "component2", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "hashCode", "", "toString", "airship-framework-proxy_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nTagOperation.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TagOperation.kt\ncom/urbanairship/android/framework/proxy/TagOperation\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,29:1\n1549#2:30\n1620#2,3:31\n*S KotlinDebug\n*F\n+ 1 TagOperation.kt\ncom/urbanairship/android/framework/proxy/TagOperation\n*L\n16#1:30\n16#1:31,3\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class TagOperation {
    private final TagOperationAction action;
    private final List tags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagOperation copy$default(TagOperation tagOperation, List list, TagOperationAction tagOperationAction, int i, Object obj) {
        if ((i & 1) != 0) {
            list = tagOperation.tags;
        }
        if ((i & 2) != 0) {
            tagOperationAction = tagOperation.action;
        }
        return tagOperation.copy(list, tagOperationAction);
    }

    @NotNull
    public final List<String> component1() {
        return this.tags;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final TagOperationAction getAction() {
        return this.action;
    }

    @NotNull
    public final TagOperation copy(@NotNull List<String> tags, @NotNull TagOperationAction action) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(action, "action");
        return new TagOperation(tags, action);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TagOperation)) {
            return false;
        }
        TagOperation tagOperation = (TagOperation) other;
        return Intrinsics.areEqual(this.tags, tagOperation.tags) && this.action == tagOperation.action;
    }

    public int hashCode() {
        return (this.tags.hashCode() * 31) + this.action.hashCode();
    }

    @NotNull
    public String toString() {
        return "TagOperation(tags=" + this.tags + ", action=" + this.action + ")";
    }

    public TagOperation(@NotNull List<String> tags, @NotNull TagOperationAction action) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(action, "action");
        this.tags = tags;
        this.action = action;
    }

    @NotNull
    public final List<String> getTags() {
        return this.tags;
    }

    @NotNull
    public final TagOperationAction getAction() {
        return this.action;
    }

    public TagOperation(@NotNull JsonMap json) throws JsonException {
        Intrinsics.checkNotNullParameter(json, "json");
        JsonList jsonListRequireList = json.require(FetchDeviceInfoAction.TAGS_KEY).requireList();
        Intrinsics.checkNotNullExpressionValue(jsonListRequireList, "requireList(...)");
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(jsonListRequireList, 10));
        Iterator<JsonValue> it = jsonListRequireList.iterator();
        while (it.hasNext()) {
            String strRequireString = it.next().requireString();
            Intrinsics.checkNotNullExpressionValue(strRequireString, "requireString(...)");
            arrayList.add(strRequireString);
        }
        String strRequireString2 = json.require("operationType").requireString();
        Intrinsics.checkNotNullExpressionValue(strRequireString2, "requireString(...)");
        String upperCase = strRequireString2.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        this(arrayList, TagOperationAction.valueOf(upperCase));
    }
}
