package com.contentsquare.android.error.analysis.apierror.v2;

import com.contentsquare.android.core.communication.error.analysis.NetworkEvent;
import com.contentsquare.android.core.features.config.model.JsonConfig;
import com.contentsquare.android.error.analysis.apierror.v2.AggregatedRules;
import com.contentsquare.android.error.analysis.util.JSONPath;
import com.contentsquare.android.error.analysis.util.UrlExtensionsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v2/ApiErrorRuleMatcher;", "", "()V", "HTTP_400", "", "defaultRule", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$CollectionRule;", "aggregateRules", "Lcom/contentsquare/android/error/analysis/apierror/v2/AggregatedRules;", "event", "Lcom/contentsquare/android/core/communication/error/analysis/NetworkEvent;", "config", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2;", "lazyBodyHolder", "Lcom/contentsquare/android/error/analysis/apierror/v2/LazyBodyHolder;", "matchBodyAttributePath", "", "bodyAttributePath", "Lcom/contentsquare/android/core/features/config/model/JsonConfig$ApiErrorsV2$BodyAttributePath;", "matchBodyContent", "rule", "matchPrimaryBodyAttribute", "matchRule", "matchStatusCode", "matchUrl", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nApiErrorRuleMatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ApiErrorRuleMatcher.kt\ncom/contentsquare/android/error/analysis/apierror/v2/ApiErrorRuleMatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,169:1\n766#2:170\n857#2,2:171\n1855#2:173\n1856#2:175\n288#2,2:176\n1#3:174\n*S KotlinDebug\n*F\n+ 1 ApiErrorRuleMatcher.kt\ncom/contentsquare/android/error/analysis/apierror/v2/ApiErrorRuleMatcher\n*L\n39#1:170\n39#1:171,2\n51#1:173\n51#1:175\n91#1:176,2\n*E\n"})
/* loaded from: classes2.dex */
public final class ApiErrorRuleMatcher {
    private static final int HTTP_400 = 400;

    @NotNull
    public static final ApiErrorRuleMatcher INSTANCE = new ApiErrorRuleMatcher();

    @NotNull
    private static final JsonConfig.ApiErrorsV2.CollectionRule defaultRule = new JsonConfig.ApiErrorsV2.CollectionRule(null, null, null, false, false, false, CollectionsKt.emptyList(), CollectionsKt.emptyList());

    private ApiErrorRuleMatcher() {
    }

    private final boolean matchBodyAttributePath(JsonConfig.ApiErrorsV2.BodyAttributePath bodyAttributePath, LazyBodyHolder lazyBodyHolder) {
        return JSONPath.INSTANCE.getJSONPathValue(bodyAttributePath.getPath(), lazyBodyHolder.getResponseBodyJSON(), true) != null;
    }

    private final boolean matchBodyContent(JsonConfig.ApiErrorsV2.CollectionRule rule, LazyBodyHolder lazyBodyHolder) {
        String bodyContent = rule.getBodyContent();
        if (bodyContent != null) {
            String responseBodyString = lazyBodyHolder.getResponseBodyString();
            Boolean boolValueOf = responseBodyString != null ? Boolean.valueOf(StringsKt.contains$default((CharSequence) responseBodyString, (CharSequence) bodyContent, false, 2, (Object) null)) : null;
            if (boolValueOf != null) {
                return boolValueOf.booleanValue();
            }
        }
        return true;
    }

    private final boolean matchPrimaryBodyAttribute(JsonConfig.ApiErrorsV2.CollectionRule rule, LazyBodyHolder lazyBodyHolder) {
        Object next;
        Iterator<T> it = rule.getBodyAttributePaths().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((JsonConfig.ApiErrorsV2.BodyAttributePath) next).getPrimary()) {
                break;
            }
        }
        JsonConfig.ApiErrorsV2.BodyAttributePath bodyAttributePath = (JsonConfig.ApiErrorsV2.BodyAttributePath) next;
        return bodyAttributePath == null || matchBodyAttributePath(bodyAttributePath, lazyBodyHolder);
    }

    private final boolean matchStatusCode(JsonConfig.ApiErrorsV2.CollectionRule rule, NetworkEvent event) {
        if (rule.getStatusCode() != null || event.getStatusCode() < 400) {
            if (rule.getStatusCode() != null) {
                int statusCode = event.getStatusCode();
                Integer statusCode2 = rule.getStatusCode();
                if (statusCode2 != null && statusCode == statusCode2.intValue()) {
                }
            }
            return false;
        }
        return true;
    }

    private final boolean matchUrl(JsonConfig.ApiErrorsV2.CollectionRule rule, NetworkEvent event) {
        String url = rule.getUrl();
        if (url != null) {
            return StringsKt.contains$default((CharSequence) UrlExtensionsKt.removeUrlParameters(event.getUrl()), (CharSequence) url, false, 2, (Object) null);
        }
        return true;
    }

    @Nullable
    public final AggregatedRules aggregateRules(NetworkEvent event, JsonConfig.ApiErrorsV2 config, LazyBodyHolder lazyBodyHolder) {
        List listListOf;
        List<JsonConfig.ApiErrorsV2.CollectionRule> collectionRules;
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(lazyBodyHolder, "lazyBodyHolder");
        AggregatedRules.Builder builder = new AggregatedRules.Builder();
        if (config == null || (collectionRules = config.getCollectionRules()) == null || (listListOf = CollectionsKt.plus((Collection<? extends JsonConfig.ApiErrorsV2.CollectionRule>) collectionRules, defaultRule)) == null) {
            listListOf = CollectionsKt.listOf(defaultRule);
        }
        ArrayList<JsonConfig.ApiErrorsV2.CollectionRule> arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (INSTANCE.matchRule(event, (JsonConfig.ApiErrorsV2.CollectionRule) obj, lazyBodyHolder)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        for (JsonConfig.ApiErrorsV2.CollectionRule collectionRule : arrayList) {
            builder.setCollectQueryParams(collectionRule.getCollectQueryParams());
            builder.setCollectRequestBody(collectionRule.getCollectRequestBody());
            builder.setCollectResponseBody(collectionRule.getCollectResponseBody());
            builder.addCustomHeaders(collectionRule.getCustomHeaders());
            builder.addBodyAttributes(collectionRule.getBodyAttributePaths());
            String bodyContent = collectionRule.getBodyContent();
            if (bodyContent != null) {
                builder.addMatchingBodyContent(bodyContent);
            }
        }
        builder.setCollectStandardHeaders(config != null ? config.getCollectStandardHeaders() : false);
        return builder.build();
    }

    public final boolean matchRule(NetworkEvent event, JsonConfig.ApiErrorsV2.CollectionRule rule, LazyBodyHolder lazyBodyHolder) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(rule, "rule");
        Intrinsics.checkNotNullParameter(lazyBodyHolder, "lazyBodyHolder");
        return matchUrl(rule, event) && matchStatusCode(rule, event) && matchBodyContent(rule, lazyBodyHolder) && matchPrimaryBodyAttribute(rule, lazyBodyHolder);
    }
}
