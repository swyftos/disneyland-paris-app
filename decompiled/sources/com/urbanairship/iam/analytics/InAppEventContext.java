package com.urbanairship.iam.analytics;

import ch.qos.logback.core.CoreConstants;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.experiment.ExperimentManager;
import com.urbanairship.json.JsonExtensionsKt;
import com.urbanairship.json.JsonMap;
import com.urbanairship.json.JsonSerializable;
import com.urbanairship.json.JsonValue;
import com.urbanairship.json.matchers.ExactValueMatcher;
import com.urbanairship.preferencecenter.data.PreferenceCenterPayload;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0080\b\u0018\u0000 /2\u00020\u0001:\u0005./012BS\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\u0002\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0003JW\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\r\u0010)\u001a\u00020$H\u0000¢\u0006\u0002\b*J\b\u0010+\u001a\u00020\u000bH\u0016J\t\u0010,\u001a\u00020-HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00063"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventContext;", "Lcom/urbanairship/json/JsonSerializable;", "pager", "Lcom/urbanairship/iam/analytics/InAppEventContext$Pager;", "button", "Lcom/urbanairship/iam/analytics/InAppEventContext$Button;", PreferenceCenterPayload.KEY_FORM, "Lcom/urbanairship/iam/analytics/InAppEventContext$Form;", "display", "Lcom/urbanairship/iam/analytics/InAppEventContext$Display;", "reportingContext", "Lcom/urbanairship/json/JsonValue;", "experimentReportingData", "", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/iam/analytics/InAppEventContext$Pager;Lcom/urbanairship/iam/analytics/InAppEventContext$Button;Lcom/urbanairship/iam/analytics/InAppEventContext$Form;Lcom/urbanairship/iam/analytics/InAppEventContext$Display;Lcom/urbanairship/json/JsonValue;Ljava/util/List;)V", "getButton", "()Lcom/urbanairship/iam/analytics/InAppEventContext$Button;", "getDisplay", "()Lcom/urbanairship/iam/analytics/InAppEventContext$Display;", "getExperimentReportingData", "()Ljava/util/List;", "getForm", "()Lcom/urbanairship/iam/analytics/InAppEventContext$Form;", "getPager", "()Lcom/urbanairship/iam/analytics/InAppEventContext$Pager;", "getReportingContext", "()Lcom/urbanairship/json/JsonValue;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "isValid", "isValid$urbanairship_automation_release", "toJsonValue", "toString", "", "Button", "Companion", "Display", "Form", "Pager", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InAppEventContext implements JsonSerializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final Button button;
    private final Display display;
    private final List experimentReportingData;
    private final Form form;
    private final Pager pager;
    private final JsonValue reportingContext;

    public InAppEventContext() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ InAppEventContext copy$default(InAppEventContext inAppEventContext, Pager pager, Button button, Form form, Display display, JsonValue jsonValue, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            pager = inAppEventContext.pager;
        }
        if ((i & 2) != 0) {
            button = inAppEventContext.button;
        }
        Button button2 = button;
        if ((i & 4) != 0) {
            form = inAppEventContext.form;
        }
        Form form2 = form;
        if ((i & 8) != 0) {
            display = inAppEventContext.display;
        }
        Display display2 = display;
        if ((i & 16) != 0) {
            jsonValue = inAppEventContext.reportingContext;
        }
        JsonValue jsonValue2 = jsonValue;
        if ((i & 32) != 0) {
            list = inAppEventContext.experimentReportingData;
        }
        return inAppEventContext.copy(pager, button2, form2, display2, jsonValue2, list);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final Pager getPager() {
        return this.pager;
    }

    @Nullable
    /* renamed from: component2, reason: from getter */
    public final Button getButton() {
        return this.button;
    }

    @Nullable
    /* renamed from: component3, reason: from getter */
    public final Form getForm() {
        return this.form;
    }

    @Nullable
    /* renamed from: component4, reason: from getter */
    public final Display getDisplay() {
        return this.display;
    }

    @Nullable
    /* renamed from: component5, reason: from getter */
    public final JsonValue getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    public final List<JsonMap> component6() {
        return this.experimentReportingData;
    }

    @NotNull
    public final InAppEventContext copy(@Nullable Pager pager, @Nullable Button button, @Nullable Form form, @Nullable Display display, @Nullable JsonValue reportingContext, @Nullable List<? extends JsonMap> experimentReportingData) {
        return new InAppEventContext(pager, button, form, display, reportingContext, experimentReportingData);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InAppEventContext)) {
            return false;
        }
        InAppEventContext inAppEventContext = (InAppEventContext) other;
        return Intrinsics.areEqual(this.pager, inAppEventContext.pager) && Intrinsics.areEqual(this.button, inAppEventContext.button) && Intrinsics.areEqual(this.form, inAppEventContext.form) && Intrinsics.areEqual(this.display, inAppEventContext.display) && Intrinsics.areEqual(this.reportingContext, inAppEventContext.reportingContext) && Intrinsics.areEqual(this.experimentReportingData, inAppEventContext.experimentReportingData);
    }

    public int hashCode() {
        Pager pager = this.pager;
        int iHashCode = (pager == null ? 0 : pager.hashCode()) * 31;
        Button button = this.button;
        int iHashCode2 = (iHashCode + (button == null ? 0 : button.hashCode())) * 31;
        Form form = this.form;
        int iHashCode3 = (iHashCode2 + (form == null ? 0 : form.hashCode())) * 31;
        Display display = this.display;
        int iHashCode4 = (iHashCode3 + (display == null ? 0 : display.hashCode())) * 31;
        JsonValue jsonValue = this.reportingContext;
        int iHashCode5 = (iHashCode4 + (jsonValue == null ? 0 : jsonValue.hashCode())) * 31;
        List list = this.experimentReportingData;
        return iHashCode5 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "InAppEventContext(pager=" + this.pager + ", button=" + this.button + ", form=" + this.form + ", display=" + this.display + ", reportingContext=" + this.reportingContext + ", experimentReportingData=" + this.experimentReportingData + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public InAppEventContext(@Nullable Pager pager, @Nullable Button button, @Nullable Form form, @Nullable Display display, @Nullable JsonValue jsonValue, @Nullable List<? extends JsonMap> list) {
        this.pager = pager;
        this.button = button;
        this.form = form;
        this.display = display;
        this.reportingContext = jsonValue;
        this.experimentReportingData = list;
    }

    public /* synthetic */ InAppEventContext(Pager pager, Button button, Form form, Display display, JsonValue jsonValue, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : pager, (i & 2) != 0 ? null : button, (i & 4) != 0 ? null : form, (i & 8) != 0 ? null : display, (i & 16) != 0 ? null : jsonValue, (i & 32) != 0 ? null : list);
    }

    @Nullable
    public final Pager getPager() {
        return this.pager;
    }

    @Nullable
    public final Button getButton() {
        return this.button;
    }

    @Nullable
    public final Form getForm() {
        return this.form;
    }

    @Nullable
    public final Display getDisplay() {
        return this.display;
    }

    @Nullable
    public final JsonValue getReportingContext() {
        return this.reportingContext;
    }

    @Nullable
    public final List<JsonMap> getExperimentReportingData() {
        return this.experimentReportingData;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 /2\u00020\u0001:\u0001/B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0002\u0010\fJ\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\bHÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00010\nHÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003JK\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010(\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020\u0006HÖ\u0001J\b\u0010,\u001a\u00020-H\u0016J\t\u0010.\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014¨\u00060"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventContext$Pager;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "pageIdentifier", "pageIndex", "", "completed", "", "history", "", "count", "(Ljava/lang/String;Ljava/lang/String;IZLjava/util/List;I)V", "getCompleted", "()Z", "setCompleted", "(Z)V", "getCount", "()I", "setCount", "(I)V", "getHistory", "()Ljava/util/List;", "setHistory", "(Ljava/util/List;)V", "getIdentifier", "()Ljava/lang/String;", "setIdentifier", "(Ljava/lang/String;)V", "getPageIdentifier", "setPageIdentifier", "getPageIndex", "setPageIndex", "component1", "component2", "component3", "component4", "component5", "component6", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Pager implements JsonSerializable {
        private boolean completed;
        private int count;
        private List history;
        private String identifier;
        private String pageIdentifier;
        private int pageIndex;

        public static /* synthetic */ Pager copy$default(Pager pager, String str, String str2, int i, boolean z, List list, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = pager.identifier;
            }
            if ((i3 & 2) != 0) {
                str2 = pager.pageIdentifier;
            }
            String str3 = str2;
            if ((i3 & 4) != 0) {
                i = pager.pageIndex;
            }
            int i4 = i;
            if ((i3 & 8) != 0) {
                z = pager.completed;
            }
            boolean z2 = z;
            if ((i3 & 16) != 0) {
                list = pager.history;
            }
            List list2 = list;
            if ((i3 & 32) != 0) {
                i2 = pager.count;
            }
            return pager.copy(str, str3, i4, z2, list2, i2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getPageIdentifier() {
            return this.pageIdentifier;
        }

        /* renamed from: component3, reason: from getter */
        public final int getPageIndex() {
            return this.pageIndex;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getCompleted() {
            return this.completed;
        }

        @NotNull
        public final List<JsonSerializable> component5() {
            return this.history;
        }

        /* renamed from: component6, reason: from getter */
        public final int getCount() {
            return this.count;
        }

        @NotNull
        public final Pager copy(@NotNull String identifier, @NotNull String pageIdentifier, int pageIndex, boolean completed, @NotNull List<? extends JsonSerializable> history, int count) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIdentifier, "pageIdentifier");
            Intrinsics.checkNotNullParameter(history, "history");
            return new Pager(identifier, pageIdentifier, pageIndex, completed, history, count);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Pager)) {
                return false;
            }
            Pager pager = (Pager) other;
            return Intrinsics.areEqual(this.identifier, pager.identifier) && Intrinsics.areEqual(this.pageIdentifier, pager.pageIdentifier) && this.pageIndex == pager.pageIndex && this.completed == pager.completed && Intrinsics.areEqual(this.history, pager.history) && this.count == pager.count;
        }

        public int hashCode() {
            return (((((((((this.identifier.hashCode() * 31) + this.pageIdentifier.hashCode()) * 31) + Integer.hashCode(this.pageIndex)) * 31) + Boolean.hashCode(this.completed)) * 31) + this.history.hashCode()) * 31) + Integer.hashCode(this.count);
        }

        @NotNull
        public String toString() {
            return "Pager(identifier=" + this.identifier + ", pageIdentifier=" + this.pageIdentifier + ", pageIndex=" + this.pageIndex + ", completed=" + this.completed + ", history=" + this.history + ", count=" + this.count + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Pager(@NotNull String identifier, @NotNull String pageIdentifier, int i, boolean z, @NotNull List<? extends JsonSerializable> history, int i2) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(pageIdentifier, "pageIdentifier");
            Intrinsics.checkNotNullParameter(history, "history");
            this.identifier = identifier;
            this.pageIdentifier = pageIdentifier;
            this.pageIndex = i;
            this.completed = z;
            this.history = history;
            this.count = i2;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        public final void setIdentifier(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.identifier = str;
        }

        @NotNull
        public final String getPageIdentifier() {
            return this.pageIdentifier;
        }

        public final void setPageIdentifier(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.pageIdentifier = str;
        }

        public final int getPageIndex() {
            return this.pageIndex;
        }

        public final void setPageIndex(int i) {
            this.pageIndex = i;
        }

        public final boolean getCompleted() {
            return this.completed;
        }

        public final void setCompleted(boolean z) {
            this.completed = z;
        }

        @NotNull
        public final List<JsonSerializable> getHistory() {
            return this.history;
        }

        public final void setHistory(@NotNull List<? extends JsonSerializable> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.history = list;
        }

        public final int getCount() {
            return this.count;
        }

        public final void setCount(int i) {
            this.count = i;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("identifier", this.identifier), TuplesKt.to("page_identifier", this.pageIdentifier), TuplesKt.to("page_index", Integer.valueOf(this.pageIndex)), TuplesKt.to("completed", Boolean.valueOf(this.completed)), TuplesKt.to("page_history", this.history), TuplesKt.to("count", Integer.valueOf(this.count))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventContext$Form;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "submitted", "", "type", "responseType", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "getResponseType", "getSubmitted", "()Z", "getType", "component1", "component2", "component3", "component4", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Form implements JsonSerializable {
        private final String identifier;
        private final String responseType;
        private final boolean submitted;
        private final String type;

        public static /* synthetic */ Form copy$default(Form form, String str, boolean z, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = form.identifier;
            }
            if ((i & 2) != 0) {
                z = form.submitted;
            }
            if ((i & 4) != 0) {
                str2 = form.type;
            }
            if ((i & 8) != 0) {
                str3 = form.responseType;
            }
            return form.copy(str, z, str2, str3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getSubmitted() {
            return this.submitted;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getType() {
            return this.type;
        }

        @Nullable
        /* renamed from: component4, reason: from getter */
        public final String getResponseType() {
            return this.responseType;
        }

        @NotNull
        public final Form copy(@NotNull String identifier, boolean submitted, @NotNull String type, @Nullable String responseType) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(type, "type");
            return new Form(identifier, submitted, type, responseType);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Form)) {
                return false;
            }
            Form form = (Form) other;
            return Intrinsics.areEqual(this.identifier, form.identifier) && this.submitted == form.submitted && Intrinsics.areEqual(this.type, form.type) && Intrinsics.areEqual(this.responseType, form.responseType);
        }

        public int hashCode() {
            int iHashCode = ((((this.identifier.hashCode() * 31) + Boolean.hashCode(this.submitted)) * 31) + this.type.hashCode()) * 31;
            String str = this.responseType;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        @NotNull
        public String toString() {
            return "Form(identifier=" + this.identifier + ", submitted=" + this.submitted + ", type=" + this.type + ", responseType=" + this.responseType + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Form(@NotNull String identifier, boolean z, @NotNull String type, @Nullable String str) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            Intrinsics.checkNotNullParameter(type, "type");
            this.identifier = identifier;
            this.submitted = z;
            this.type = type;
            this.responseType = str;
        }

        public /* synthetic */ Form(String str, boolean z, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, z, str2, (i & 8) != 0 ? null : str3);
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        public final boolean getSubmitted() {
            return this.submitted;
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Nullable
        public final String getResponseType() {
            return this.responseType;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("identifier", this.identifier), TuplesKt.to("submitted", Boolean.valueOf(this.submitted)), TuplesKt.to("type", this.type), TuplesKt.to("response_type", this.responseType)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventContext$Button;", "Lcom/urbanairship/json/JsonSerializable;", "identifier", "", "(Ljava/lang/String;)V", "getIdentifier", "()Ljava/lang/String;", "component1", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, "", ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Button implements JsonSerializable {
        private final String identifier;

        public static /* synthetic */ Button copy$default(Button button, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = button.identifier;
            }
            return button.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getIdentifier() {
            return this.identifier;
        }

        @NotNull
        public final Button copy(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            return new Button(identifier);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Button) && Intrinsics.areEqual(this.identifier, ((Button) other).identifier);
        }

        public int hashCode() {
            return this.identifier.hashCode();
        }

        @NotNull
        public String toString() {
            return "Button(identifier=" + this.identifier + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Button(@NotNull String identifier) {
            Intrinsics.checkNotNullParameter(identifier, "identifier");
            this.identifier = identifier;
        }

        @NotNull
        public final String getIdentifier() {
            return this.identifier;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("identifier", this.identifier)).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventContext$Companion;", "", "()V", "KEY_BUTTON", "", "KEY_DISPLAY", "KEY_EXPERIMENTS_REPORTING_DATA", "KEY_FORM", "KEY_PAGER", "KEY_REPORTING_CONTEXT", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\b\"\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/urbanairship/iam/analytics/InAppEventContext$Display;", "Lcom/urbanairship/json/JsonSerializable;", "triggerSessionId", "", "isFirstDisplay", "", "isFirstDisplayTriggerSessionId", "(Ljava/lang/String;ZZ)V", "()Z", "setFirstDisplay", "(Z)V", "setFirstDisplayTriggerSessionId", "getTriggerSessionId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "", "hashCode", "", "toJsonValue", "Lcom/urbanairship/json/JsonValue;", "toString", "Companion", "urbanairship-automation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class Display implements JsonSerializable {
        private boolean isFirstDisplay;
        private boolean isFirstDisplayTriggerSessionId;
        private final String triggerSessionId;

        public static /* synthetic */ Display copy$default(Display display, String str, boolean z, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = display.triggerSessionId;
            }
            if ((i & 2) != 0) {
                z = display.isFirstDisplay;
            }
            if ((i & 4) != 0) {
                z2 = display.isFirstDisplayTriggerSessionId;
            }
            return display.copy(str, z, z2);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getTriggerSessionId() {
            return this.triggerSessionId;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsFirstDisplay() {
            return this.isFirstDisplay;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsFirstDisplayTriggerSessionId() {
            return this.isFirstDisplayTriggerSessionId;
        }

        @NotNull
        public final Display copy(@NotNull String triggerSessionId, boolean isFirstDisplay, boolean isFirstDisplayTriggerSessionId) {
            Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
            return new Display(triggerSessionId, isFirstDisplay, isFirstDisplayTriggerSessionId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Display)) {
                return false;
            }
            Display display = (Display) other;
            return Intrinsics.areEqual(this.triggerSessionId, display.triggerSessionId) && this.isFirstDisplay == display.isFirstDisplay && this.isFirstDisplayTriggerSessionId == display.isFirstDisplayTriggerSessionId;
        }

        public int hashCode() {
            return (((this.triggerSessionId.hashCode() * 31) + Boolean.hashCode(this.isFirstDisplay)) * 31) + Boolean.hashCode(this.isFirstDisplayTriggerSessionId);
        }

        @NotNull
        public String toString() {
            return "Display(triggerSessionId=" + this.triggerSessionId + ", isFirstDisplay=" + this.isFirstDisplay + ", isFirstDisplayTriggerSessionId=" + this.isFirstDisplayTriggerSessionId + CoreConstants.RIGHT_PARENTHESIS_CHAR;
        }

        public Display(@NotNull String triggerSessionId, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(triggerSessionId, "triggerSessionId");
            this.triggerSessionId = triggerSessionId;
            this.isFirstDisplay = z;
            this.isFirstDisplayTriggerSessionId = z2;
        }

        @NotNull
        public final String getTriggerSessionId() {
            return this.triggerSessionId;
        }

        public final boolean isFirstDisplay() {
            return this.isFirstDisplay;
        }

        public final void setFirstDisplay(boolean z) {
            this.isFirstDisplay = z;
        }

        public final boolean isFirstDisplayTriggerSessionId() {
            return this.isFirstDisplayTriggerSessionId;
        }

        public final void setFirstDisplayTriggerSessionId(boolean z) {
            this.isFirstDisplayTriggerSessionId = z;
        }

        @Override // com.urbanairship.json.JsonSerializable
        @NotNull
        /* renamed from: toJsonValue */
        public JsonValue getJsonValue() {
            JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("trigger_session_id", this.triggerSessionId), TuplesKt.to("is_first_display", Boolean.valueOf(this.isFirstDisplay)), TuplesKt.to("is_first_display_trigger_session", Boolean.valueOf(this.isFirstDisplayTriggerSessionId))).getJsonValue();
            Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
            return jsonValue;
        }
    }

    @Override // com.urbanairship.json.JsonSerializable
    @NotNull
    /* renamed from: toJsonValue */
    public JsonValue getJsonValue() {
        JsonValue jsonValue = JsonExtensionsKt.jsonMapOf(TuplesKt.to("pager", this.pager), TuplesKt.to("button", this.button), TuplesKt.to(PreferenceCenterPayload.KEY_FORM, this.form), TuplesKt.to("display", this.display), TuplesKt.to("reporting_context", this.reportingContext), TuplesKt.to(ExperimentManager.PAYLOAD_TYPE, this.experimentReportingData)).getJsonValue();
        Intrinsics.checkNotNullExpressionValue(jsonValue, "toJsonValue(...)");
        return jsonValue;
    }

    public final boolean isValid$urbanairship_automation_release() {
        if (this.pager != null || this.button != null || this.form != null || this.display != null || this.reportingContext != null) {
            return true;
        }
        List list = this.experimentReportingData;
        return list != null ? list.isEmpty() ^ true : false;
    }
}
