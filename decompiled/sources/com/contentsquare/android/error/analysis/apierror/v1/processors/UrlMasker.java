package com.contentsquare.android.error.analysis.apierror.v1.processors;

import com.contentsquare.android.core.utils.ExtensionsKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.SequencesKt;
import kotlin.text.MatchGroup;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00060\t2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u001c\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\tJ\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/contentsquare/android/error/analysis/apierror/v1/processors/UrlMasker;", "", "()V", "TEMPLATE_MATCHER", "Lkotlin/text/Regex;", "anonymizeTemplateParam", "", "param", "generateSubstitutions", "", "pattern", "maskUrl", "url", "patterns", "maskWithPattern", "error-analysis_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nUrlMasker.kt\nKotlin\n*S Kotlin\n*F\n+ 1 UrlMasker.kt\ncom/contentsquare/android/error/analysis/apierror/v1/processors/UrlMasker\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,72:1\n1054#2:73\n1855#2,2:74\n1864#2,3:76\n1549#2:79\n1620#2,3:80\n*S KotlinDebug\n*F\n+ 1 UrlMasker.kt\ncom/contentsquare/android/error/analysis/apierror/v1/processors/UrlMasker\n*L\n16#1:73\n16#1:74,2\n45#1:76,3\n64#1:79\n64#1:80,3\n*E\n"})
/* loaded from: classes2.dex */
public final class UrlMasker {

    @NotNull
    public static final UrlMasker INSTANCE = new UrlMasker();

    @NotNull
    private static final Regex TEMPLATE_MATCHER = new Regex("/:\\w*");

    private UrlMasker() {
    }

    private final String anonymizeTemplateParam(String param) {
        StringBuilder sb = new StringBuilder("CS_ANONYMIZED_");
        String strDrop = StringsKt.drop(param, 2);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String upperCase = strDrop.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        sb.append(upperCase);
        return sb.toString();
    }

    private final List<String> generateSubstitutions(String pattern) {
        List list = SequencesKt.toList(SequencesKt.map(Regex.findAll$default(TEMPLATE_MATCHER, pattern, 0, 2, null), new Function1<MatchResult, String>() { // from class: com.contentsquare.android.error.analysis.apierror.v1.processors.UrlMasker.generateSubstitutions.1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final String invoke(MatchResult match) {
                Intrinsics.checkNotNullParameter(match, "match");
                return match.getValue();
            }
        }));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(INSTANCE.anonymizeTemplateParam((String) it.next()));
        }
        return ExtensionsKt.reversedList(arrayList);
    }

    private final String maskWithPattern(String pattern, String url) {
        List<String> listGenerateSubstitutions = generateSubstitutions(pattern);
        Regex regex = new Regex(TEMPLATE_MATCHER.replace(pattern, "/([^/?]+)"));
        int i = 0;
        MatchResult matchResultFind$default = Regex.find$default(regex, url, 0, 2, null);
        if (matchResultFind$default == null) {
            return null;
        }
        for (Object obj : ExtensionsKt.reversedList(CollectionsKt.drop(matchResultFind$default.getGroups(), 1))) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            MatchGroup matchGroup = (MatchGroup) obj;
            String str = (String) CollectionsKt.getOrNull(listGenerateSubstitutions, i);
            if (str != null && matchGroup != null) {
                url = StringsKt.replaceRange(url, matchGroup.getRange().getFirst(), matchGroup.getRange().getLast() + 1, str).toString();
            }
            i = i2;
        }
        return url;
    }

    @NotNull
    public final String maskUrl(String url, List<String> patterns) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(patterns, "patterns");
        Iterator it = CollectionsKt.sortedWith(patterns, new Comparator() { // from class: com.contentsquare.android.error.analysis.apierror.v1.processors.UrlMasker$maskUrl$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Integer.valueOf(((String) t2).length()), Integer.valueOf(((String) t).length()));
            }
        }).iterator();
        while (it.hasNext()) {
            String strMaskWithPattern = INSTANCE.maskWithPattern((String) it.next(), url);
            if (strMaskWithPattern != null) {
                return strMaskWithPattern;
            }
        }
        return url;
    }
}
