package com.contentsquare.android.error.analysis.apierror.v2;

import ch.qos.logback.core.CoreConstants;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.tagcommander.lib.serverside.ETCPaymentMethod;
import com.urbanairship.json.matchers.ExactValueMatcher;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\b\u0018\u00002\u00020\u0001:\u0001)BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u0018\u001a\u00020\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\bHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003Ja\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0001J\u0013\u0010!\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%J\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\rHÖ\u0001R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006*"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "", "shouldCollectQueryParams", "", "shouldCollectResponseBody", "shouldCollectRequestBody", "shouldCollectStandardHeaders", "bodyAttributes", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath;", "customHeaders", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader;", "matchingBodyContents", "", "(ZZZZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getBodyAttributes", "()Ljava/util/List;", "getCustomHeaders", "getMatchingBodyContents", "getShouldCollectQueryParams", "()Z", "getShouldCollectRequestBody", "getShouldCollectResponseBody", "getShouldCollectStandardHeaders", "anyValuesEncrypted", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", ExactValueMatcher.EQUALS_VALUE_KEY, ETCPaymentMethod.OTHER, "encrypted", "type", "Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorsType;", "hashCode", "", "toString", "Builder", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAggregatedRules.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AggregatedRules.kt\ncom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n766#2:98\n857#2,2:99\n766#2:101\n857#2,2:102\n1747#2,3:104\n1747#2,3:107\n*S KotlinDebug\n*F\n+ 1 AggregatedRules.kt\ncom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules\n*L\n75#1:98\n75#1:99,2\n84#1:101\n84#1:102,2\n90#1:104,3\n91#1:107,3\n*E\n"})
/* loaded from: classes2.dex */
public final /* data */ class AggregatedRules {

    @NotNull
    private final List<JsonConfig.ApiErrorsV2.BodyAttributePath> bodyAttributes;

    @NotNull
    private final List<JsonConfig.ApiErrorsV2.CustomHeader> customHeaders;

    @NotNull
    private final List<String> matchingBodyContents;
    private final boolean shouldCollectQueryParams;
    private final boolean shouldCollectRequestBody;
    private final boolean shouldCollectResponseBody;
    private final boolean shouldCollectStandardHeaders;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012J\u0014\u0010\u0013\u001a\u00020\u00102\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u0012J\u000e\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bJ\u000e\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules$Builder;", "", "()V", "bodyAttributes", "", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath;", "customHeaders", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CustomHeader;", "matchingBodyContents", "", "shouldCollectQueryParams", "", "shouldCollectRequestBody", "shouldCollectResponseBody", "shouldCollectStandardHeaders", "addBodyAttributes", "", "attributes", "", "addCustomHeaders", "headers", "addMatchingBodyContent", "matchingBodyContent", "build", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "setCollectQueryParams", "collect", "setCollectRequestBody", "setCollectResponseBody", "setCollectStandardHeaders", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {

        @NotNull
        private final Set<JsonConfig.ApiErrorsV2.BodyAttributePath> bodyAttributes = new LinkedHashSet();

        @NotNull
        private final Set<JsonConfig.ApiErrorsV2.CustomHeader> customHeaders = new LinkedHashSet();

        @NotNull
        private final Set<String> matchingBodyContents = new LinkedHashSet();
        private boolean shouldCollectQueryParams;
        private boolean shouldCollectRequestBody;
        private boolean shouldCollectResponseBody;
        private boolean shouldCollectStandardHeaders;

        public final void addBodyAttributes(List<JsonConfig.ApiErrorsV2.BodyAttributePath> attributes) {
            Intrinsics.checkNotNullParameter(attributes, "attributes");
            this.bodyAttributes.addAll(attributes);
        }

        public final void addCustomHeaders(List<JsonConfig.ApiErrorsV2.CustomHeader> headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.customHeaders.addAll(headers);
        }

        public final void addMatchingBodyContent(String matchingBodyContent) {
            Intrinsics.checkNotNullParameter(matchingBodyContent, "matchingBodyContent");
            this.matchingBodyContents.add(matchingBodyContent);
        }

        @NotNull
        public final AggregatedRules build() {
            return new AggregatedRules(this.shouldCollectQueryParams, this.shouldCollectResponseBody, this.shouldCollectRequestBody, this.shouldCollectStandardHeaders, CollectionsKt.toList(this.bodyAttributes), CollectionsKt.toList(this.customHeaders), CollectionsKt.toList(this.matchingBodyContents));
        }

        public final void setCollectQueryParams(boolean collect) {
            if (collect) {
                this.shouldCollectQueryParams = true;
            }
        }

        public final void setCollectRequestBody(boolean collect) {
            if (collect) {
                this.shouldCollectRequestBody = true;
            }
        }

        public final void setCollectResponseBody(boolean collect) {
            if (collect) {
                this.shouldCollectResponseBody = true;
            }
        }

        public final void setCollectStandardHeaders(boolean collect) {
            if (collect) {
                this.shouldCollectStandardHeaders = true;
            }
        }
    }

    public AggregatedRules(boolean z, boolean z2, boolean z3, boolean z4, List<JsonConfig.ApiErrorsV2.BodyAttributePath> bodyAttributes, List<JsonConfig.ApiErrorsV2.CustomHeader> customHeaders, List<String> matchingBodyContents) {
        Intrinsics.checkNotNullParameter(bodyAttributes, "bodyAttributes");
        Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
        Intrinsics.checkNotNullParameter(matchingBodyContents, "matchingBodyContents");
        this.shouldCollectQueryParams = z;
        this.shouldCollectResponseBody = z2;
        this.shouldCollectRequestBody = z3;
        this.shouldCollectStandardHeaders = z4;
        this.bodyAttributes = bodyAttributes;
        this.customHeaders = customHeaders;
        this.matchingBodyContents = matchingBodyContents;
    }

    public static /* synthetic */ AggregatedRules copy$default(AggregatedRules aggregatedRules, boolean z, boolean z2, boolean z3, boolean z4, List list, List list2, List list3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = aggregatedRules.shouldCollectQueryParams;
        }
        if ((i & 2) != 0) {
            z2 = aggregatedRules.shouldCollectResponseBody;
        }
        boolean z5 = z2;
        if ((i & 4) != 0) {
            z3 = aggregatedRules.shouldCollectRequestBody;
        }
        boolean z6 = z3;
        if ((i & 8) != 0) {
            z4 = aggregatedRules.shouldCollectStandardHeaders;
        }
        boolean z7 = z4;
        if ((i & 16) != 0) {
            list = aggregatedRules.bodyAttributes;
        }
        List list4 = list;
        if ((i & 32) != 0) {
            list2 = aggregatedRules.customHeaders;
        }
        List list5 = list2;
        if ((i & 64) != 0) {
            list3 = aggregatedRules.matchingBodyContents;
        }
        return aggregatedRules.copy(z, z5, z6, z7, list4, list5, list3);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean anyValuesEncrypted() {
        /*
            r2 = this;
            java.util.List<com.contentsquare.android.core.features.config.model.JsonConfig$ApiErrorsV2$CustomHeader> r0 = r2.customHeaders
            if (r0 == 0) goto Lb
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Lb
            goto L22
        Lb:
            java.util.Iterator r0 = r0.iterator()
        Lf:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L22
            java.lang.Object r1 = r0.next()
            com.contentsquare.android.core.features.config.model.JsonConfig$ApiErrorsV2$CustomHeader r1 = (com.contentsquare.android.core.features.config.model.JsonConfig.ApiErrorsV2.CustomHeader) r1
            boolean r1 = r1.getEncrypted()
            if (r1 == 0) goto Lf
            goto L53
        L22:
            java.util.List<com.contentsquare.android.core.features.config.model.JsonConfig$ApiErrorsV2$BodyAttributePath> r0 = r2.bodyAttributes
            if (r0 == 0) goto L2d
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L2d
            goto L44
        L2d:
            java.util.Iterator r0 = r0.iterator()
        L31:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L44
            java.lang.Object r1 = r0.next()
            com.contentsquare.android.core.features.config.model.JsonConfig$ApiErrorsV2$BodyAttributePath r1 = (com.contentsquare.android.core.features.config.model.JsonConfig.ApiErrorsV2.BodyAttributePath) r1
            boolean r1 = r1.getEncrypted()
            if (r1 == 0) goto L31
            goto L53
        L44:
            boolean r0 = r2.shouldCollectResponseBody
            if (r0 != 0) goto L53
            boolean r0 = r2.shouldCollectRequestBody
            if (r0 != 0) goto L53
            boolean r2 = r2.shouldCollectQueryParams
            if (r2 == 0) goto L51
            goto L53
        L51:
            r2 = 0
            goto L54
        L53:
            r2 = 1
        L54:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.error.analysis.apierror.v2.AggregatedRules.anyValuesEncrypted():boolean");
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getShouldCollectQueryParams() {
        return this.shouldCollectQueryParams;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getShouldCollectResponseBody() {
        return this.shouldCollectResponseBody;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getShouldCollectRequestBody() {
        return this.shouldCollectRequestBody;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getShouldCollectStandardHeaders() {
        return this.shouldCollectStandardHeaders;
    }

    @NotNull
    public final List<JsonConfig.ApiErrorsV2.BodyAttributePath> component5() {
        return this.bodyAttributes;
    }

    @NotNull
    public final List<JsonConfig.ApiErrorsV2.CustomHeader> component6() {
        return this.customHeaders;
    }

    @NotNull
    public final List<String> component7() {
        return this.matchingBodyContents;
    }

    @NotNull
    public final AggregatedRules copy(boolean shouldCollectQueryParams, boolean shouldCollectResponseBody, boolean shouldCollectRequestBody, boolean shouldCollectStandardHeaders, List<JsonConfig.ApiErrorsV2.BodyAttributePath> bodyAttributes, List<JsonConfig.ApiErrorsV2.CustomHeader> customHeaders, List<String> matchingBodyContents) {
        Intrinsics.checkNotNullParameter(bodyAttributes, "bodyAttributes");
        Intrinsics.checkNotNullParameter(customHeaders, "customHeaders");
        Intrinsics.checkNotNullParameter(matchingBodyContents, "matchingBodyContents");
        return new AggregatedRules(shouldCollectQueryParams, shouldCollectResponseBody, shouldCollectRequestBody, shouldCollectStandardHeaders, bodyAttributes, customHeaders, matchingBodyContents);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AggregatedRules)) {
            return false;
        }
        AggregatedRules aggregatedRules = (AggregatedRules) other;
        return this.shouldCollectQueryParams == aggregatedRules.shouldCollectQueryParams && this.shouldCollectResponseBody == aggregatedRules.shouldCollectResponseBody && this.shouldCollectRequestBody == aggregatedRules.shouldCollectRequestBody && this.shouldCollectStandardHeaders == aggregatedRules.shouldCollectStandardHeaders && Intrinsics.areEqual(this.bodyAttributes, aggregatedRules.bodyAttributes) && Intrinsics.areEqual(this.customHeaders, aggregatedRules.customHeaders) && Intrinsics.areEqual(this.matchingBodyContents, aggregatedRules.matchingBodyContents);
    }

    @NotNull
    public final List<JsonConfig.ApiErrorsV2.BodyAttributePath> getBodyAttributes() {
        return this.bodyAttributes;
    }

    @NotNull
    public final List<JsonConfig.ApiErrorsV2.CustomHeader> getCustomHeaders() {
        return this.customHeaders;
    }

    @NotNull
    public final List<String> getMatchingBodyContents() {
        return this.matchingBodyContents;
    }

    public final boolean getShouldCollectQueryParams() {
        return this.shouldCollectQueryParams;
    }

    public final boolean getShouldCollectRequestBody() {
        return this.shouldCollectRequestBody;
    }

    public final boolean getShouldCollectResponseBody() {
        return this.shouldCollectResponseBody;
    }

    public final boolean getShouldCollectStandardHeaders() {
        return this.shouldCollectStandardHeaders;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    public int hashCode() {
        boolean z = this.shouldCollectQueryParams;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.shouldCollectResponseBody;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.shouldCollectRequestBody;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z2 = this.shouldCollectStandardHeaders;
        return this.matchingBodyContents.hashCode() + ((this.customHeaders.hashCode() + ((this.bodyAttributes.hashCode() + ((i5 + (z2 ? 1 : z2 ? 1 : 0)) * 31)) * 31)) * 31);
    }

    @NotNull
    public String toString() {
        return "AggregatedRules(shouldCollectQueryParams=" + this.shouldCollectQueryParams + ", shouldCollectResponseBody=" + this.shouldCollectResponseBody + ", shouldCollectRequestBody=" + this.shouldCollectRequestBody + ", shouldCollectStandardHeaders=" + this.shouldCollectStandardHeaders + ", bodyAttributes=" + this.bodyAttributes + ", customHeaders=" + this.customHeaders + ", matchingBodyContents=" + this.matchingBodyContents + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    @NotNull
    public final List<JsonConfig.ApiErrorsV2.BodyAttributePath> getBodyAttributes(boolean encrypted, ApiErrorsType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<JsonConfig.ApiErrorsV2.BodyAttributePath> list = this.bodyAttributes;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            JsonConfig.ApiErrorsV2.BodyAttributePath bodyAttributePath = (JsonConfig.ApiErrorsV2.BodyAttributePath) obj;
            if (bodyAttributePath.getEncrypted() == encrypted && (Intrinsics.areEqual(bodyAttributePath.getType(), ApiErrorsType.REQUEST_RESPONSE.getValue()) || Intrinsics.areEqual(bodyAttributePath.getType(), type.getValue()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @NotNull
    public final List<JsonConfig.ApiErrorsV2.CustomHeader> getCustomHeaders(boolean encrypted, ApiErrorsType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        List<JsonConfig.ApiErrorsV2.CustomHeader> list = this.customHeaders;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            JsonConfig.ApiErrorsV2.CustomHeader customHeader = (JsonConfig.ApiErrorsV2.CustomHeader) obj;
            if (customHeader.getEncrypted() == encrypted && (Intrinsics.areEqual(customHeader.getType(), ApiErrorsType.REQUEST_RESPONSE.getValue()) || Intrinsics.areEqual(customHeader.getType(), type.getValue()))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
