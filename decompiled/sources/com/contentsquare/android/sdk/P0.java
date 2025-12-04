package com.contentsquare.android.sdk;

import com.contentsquare.android.core.features.logging.Logger;
import com.contentsquare.android.core.utils.ExtensionsKt;
import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAsset;
import com.contentsquare.android.internal.features.webviewbridge.assets.WebViewAssetContent;
import com.contentsquare.android.sdk.Q0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@SourceDebugExtension({"SMAP\nCssProcessor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CssProcessor.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssProcessor\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,96:1\n288#2,2:97\n1238#2,4:101\n1238#2,2:107\n766#2:109\n857#2,2:110\n1549#2:112\n1620#2,3:113\n1241#2:116\n766#2:117\n857#2,2:118\n1179#2,2:120\n1253#2,4:122\n442#3:99\n392#3:100\n442#3:105\n392#3:106\n*S KotlinDebug\n*F\n+ 1 CssProcessor.kt\ncom/contentsquare/android/internal/features/webviewbridge/util/CssProcessor\n*L\n31#1:97,2\n66#1:101,4\n84#1:107,2\n85#1:109\n85#1:110,2\n85#1:112\n85#1:113,3\n84#1:116\n94#1:117\n94#1:118,2\n95#1:120,2\n95#1:122,4\n66#1:99\n66#1:100\n84#1:105\n84#1:106\n*E\n"})
/* loaded from: classes2.dex */
public final class P0 {

    @NotNull
    public static final Logger c = new Logger("CssProcessor");

    @NotNull
    public final Q0 a;

    @NotNull
    public final O0 b;

    public P0(@NotNull Q0 cssUtil, @NotNull O0 cssDependencyResolver) {
        Intrinsics.checkNotNullParameter(cssUtil, "cssUtil");
        Intrinsics.checkNotNullParameter(cssDependencyResolver, "cssDependencyResolver");
        this.a = cssUtil;
        this.b = cssDependencyResolver;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v18, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.util.List] */
    @NotNull
    public final ArrayList a(@NotNull ArrayList cssAssets, @NotNull ArrayList processedDataAssets) {
        Object obj;
        ?? EmptyList;
        Object next;
        String css;
        List<Q0.a> urls;
        Q0.a aVarA;
        byte[] bArr;
        Intrinsics.checkNotNullParameter(cssAssets, "cssAssets");
        Intrinsics.checkNotNullParameter(processedDataAssets, "processedDataAssets");
        Map mapCreateMapBuilder = MapsKt.createMapBuilder();
        Iterator it = cssAssets.iterator();
        while (it.hasNext()) {
            WebViewAsset webViewAsset = (WebViewAsset) it.next();
            String str = webViewAsset.b;
            WebViewAssetContent webViewAssetContent = webViewAsset.d;
            if (webViewAssetContent != null && (bArr = webViewAssetContent.c) != null) {
                mapCreateMapBuilder.put(str, new String(bArr, Charsets.UTF_8));
            }
        }
        Map mapBuild = MapsKt.build(mapCreateMapBuilder);
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(mapBuild.size()));
        Iterator it2 = mapBuild.entrySet().iterator();
        while (true) {
            int i = 0;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it2.next();
            Object key = entry.getKey();
            String css2 = (String) entry.getValue();
            this.a.getClass();
            Intrinsics.checkNotNullParameter(css2, "css");
            ArrayList arrayList = new ArrayList();
            while (i < css2.length() && ((aVarA = Q0.a(i, css2, "@import ", ";")) != null || (aVarA = Q0.a(i, css2, "url(", ")")) != null)) {
                arrayList.add(aVarA);
                i = aVarA.c;
            }
            linkedHashMap.put(key, arrayList);
        }
        LinkedHashMap dependencyMap = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap.size()));
        Iterator it3 = linkedHashMap.entrySet().iterator();
        while (true) {
            obj = null;
            if (it3.hasNext()) {
                Map.Entry entry2 = (Map.Entry) it3.next();
                Object key2 = entry2.getKey();
                List list = (List) entry2.getValue();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (StringsKt.endsWith$default(((Q0.a) obj2).a, ".css", false, 2, (Object) null)) {
                        arrayList2.add(obj2);
                    }
                }
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    arrayList3.add(((Q0.a) it4.next()).a);
                }
                dependencyMap.put(key2, arrayList3);
            } else {
                try {
                    break;
                } catch (IllegalArgumentException e) {
                    Logger logger = c;
                    Q2.a(logger, "Failed to process CSS assets", e);
                    logger.d("Failed to process CSS assets, a circular dependency has been detected.");
                    EmptyList = CollectionsKt.emptyList();
                }
            }
        }
        this.b.getClass();
        Intrinsics.checkNotNullParameter(dependencyMap, "dependencyMap");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        EmptyList = new ArrayList();
        for (String str2 : dependencyMap.keySet()) {
            if (!linkedHashSet.contains(str2)) {
                O0.a(linkedHashSet, dependencyMap, EmptyList, str2);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (String str3 : EmptyList) {
            Iterator it5 = cssAssets.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    next = obj;
                    break;
                }
                next = it5.next();
                if (Intrinsics.areEqual(((WebViewAsset) next).b, str3)) {
                    break;
                }
            }
            WebViewAsset webViewAsset2 = (WebViewAsset) next;
            if (webViewAsset2 != null && (css = (String) mapBuild.get(str3)) != null && (urls = (List) linkedHashMap.get(str3)) != null) {
                String str4 = webViewAsset2.a;
                List listPlus = CollectionsKt.plus((Collection) processedDataAssets, (Iterable) arrayList4);
                ArrayList arrayList5 = new ArrayList();
                for (Object obj3 : listPlus) {
                    if (Intrinsics.areEqual(((WebViewAsset) obj3).c, str4)) {
                        arrayList5.add(obj3);
                    }
                }
                LinkedHashMap replacements = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList5, 10)), 16));
                Iterator it6 = arrayList5.iterator();
                while (it6.hasNext()) {
                    WebViewAsset webViewAsset3 = (WebViewAsset) it6.next();
                    Pair pair = TuplesKt.to(webViewAsset3.b, "cs://resources/" + webViewAsset3.e);
                    replacements.put(pair.getFirst(), pair.getSecond());
                }
                this.a.getClass();
                Intrinsics.checkNotNullParameter(css, "css");
                Intrinsics.checkNotNullParameter(replacements, "replacements");
                Intrinsics.checkNotNullParameter(urls, "urls");
                if (!urls.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    int i2 = 0;
                    for (Q0.a aVar : urls) {
                        String str5 = (String) replacements.get(aVar.a);
                        if (str5 == null) {
                            str5 = aVar.a;
                        }
                        String strSubstring = css.substring(i2, aVar.b);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                        sb.append(strSubstring);
                        sb.append(str5);
                        i2 = aVar.c;
                    }
                    String strSubstring2 = css.substring(i2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring2);
                    css = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(css, "replacedCss.toString()");
                }
                WebViewAsset webViewAsset4 = new WebViewAsset(webViewAsset2.a + '#' + webViewAsset2.g, webViewAsset2.b, webViewAsset2.c, new WebViewAssetContent(ExtensionsKt.toBase64(css)));
                webViewAsset4.g = webViewAsset2.g;
                arrayList4.add(webViewAsset4);
                obj = null;
            }
        }
        return arrayList4;
    }
}
