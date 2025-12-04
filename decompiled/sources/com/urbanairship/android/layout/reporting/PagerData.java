package com.urbanairship.android.layout.reporting;

import androidx.annotation.RestrictTo;
import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.android.layout.event.ReportingEvent;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 %2\u00020\u0001:\u0001%B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u001c\u001a\u00020\fHÆ\u0003JK\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\f2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006&"}, d2 = {"Lcom/urbanairship/android/layout/reporting/PagerData;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "index", "", "pageId", "count", "history", "", "Lcom/urbanairship/android/layout/event/ReportingEvent$PageSummaryData$PageView;", "isCompleted", "", "(Ljava/lang/String;ILjava/lang/String;ILjava/util/List;Z)V", "getCount", "()I", "getHistory", "()Ljava/util/List;", "getIdentifier", "()Ljava/lang/String;", "getIndex", "()Z", "getPageId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final /* data */ class PagerData implements JsonSerializable {
    private static final Companion Companion = new Companion(null);
    private final int count;
    private final List history;
    private final String identifier;
    private final int index;
    private final boolean isCompleted;
    private final String pageId;

    public static /* synthetic */ PagerData copy$default(PagerData pagerData, String str, int i, String str2, int i2, List list, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = pagerData.identifier;
        }
        if ((i3 & 2) != 0) {
            i = pagerData.index;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            str2 = pagerData.pageId;
        }
        String str3 = str2;
        if ((i3 & 8) != 0) {
            i2 = pagerData.count;
        }
        int i5 = i2;
        if ((i3 & 16) != 0) {
            list = pagerData.history;
        }
        List list2 = list;
        if ((i3 & 32) != 0) {
            z = pagerData.isCompleted;
        }
        return pagerData.copy(str, i4, str3, i5, list2, z);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getIdentifier() {
        return this.identifier;
    }

    /* renamed from: component2, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: component3, reason: from getter */
    public final String getPageId() {
        return this.pageId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final List<ReportingEvent.PageSummaryData.PageView> component5() {
        return this.history;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
    }

    @NotNull
    public final PagerData copy(@NotNull String identifier, int index, @NotNull String pageId, int count, @NotNull List<ReportingEvent.PageSummaryData.PageView> history, boolean isCompleted) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(history, "history");
        return new PagerData(identifier, index, pageId, count, history, isCompleted);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PagerData)) {
            return false;
        }
        PagerData pagerData = (PagerData) other;
        return Intrinsics.areEqual(this.identifier, pagerData.identifier) && this.index == pagerData.index && Intrinsics.areEqual(this.pageId, pagerData.pageId) && this.count == pagerData.count && Intrinsics.areEqual(this.history, pagerData.history) && this.isCompleted == pagerData.isCompleted;
    }

    public int hashCode() {
        return (((((((((this.identifier.hashCode() * 31) + Integer.hashCode(this.index)) * 31) + this.pageId.hashCode()) * 31) + Integer.hashCode(this.count)) * 31) + this.history.hashCode()) * 31) + Boolean.hashCode(this.isCompleted);
    }

    @NotNull
    public String toString() {
        return "PagerData(identifier=" + this.identifier + ", index=" + this.index + ", pageId=" + this.pageId + ", count=" + this.count + ", history=" + this.history + ", isCompleted=" + this.isCompleted + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public PagerData(@NotNull String identifier, int i, @NotNull String pageId, int i2, @NotNull List<ReportingEvent.PageSummaryData.PageView> history, boolean z) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(pageId, "pageId");
        Intrinsics.checkNotNullParameter(history, "history");
        this.identifier = identifier;
        this.index = i;
        this.pageId = pageId;
        this.count = i2;
        this.history = history;
        this.isCompleted = z;
    }

    @NotNull
    public final String getIdentifier() {
        return this.identifier;
    }

    public final int getIndex() {
        return this.index;
    }

    @NotNull
    public final String getPageId() {
        return this.pageId;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final List<ReportingEvent.PageSummaryData.PageView> getHistory() {
        return this.history;
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("identifier", this.identifier), TuplesKt.to("index", Integer.valueOf(this.index)), TuplesKt.to("page_id", this.pageId), TuplesKt.to("count", Integer.valueOf(this.count)), TuplesKt.to("history", this.history), TuplesKt.to("is_completed", Boolean.valueOf(this.isCompleted))).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }
}
