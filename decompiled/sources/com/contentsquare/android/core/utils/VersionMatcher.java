package com.contentsquare.android.core.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lcom/contentsquare/android/core/utils/VersionMatcher;", "", "()V", "match", "", "pattern", "", "version", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nVersionMatcher.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VersionMatcher.kt\ncom/contentsquare/android/core/utils/VersionMatcher\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,251:1\n1549#2:252\n1620#2,3:253\n1726#2,3:256\n1549#2:259\n1620#2,3:260\n1747#2,3:263\n*S KotlinDebug\n*F\n+ 1 VersionMatcher.kt\ncom/contentsquare/android/core/utils/VersionMatcher\n*L\n47#1:252\n47#1:253,3\n47#1:256,3\n49#1:259\n49#1:260,3\n49#1:263,3\n*E\n"})
/* loaded from: classes2.dex */
public final class VersionMatcher {

    @NotNull
    public static final VersionMatcher INSTANCE = new VersionMatcher();

    private VersionMatcher() {
    }

    @JvmStatic
    public static final boolean match(String pattern, String version) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        Intrinsics.checkNotNullParameter(version, "version");
        if (!Intrinsics.areEqual(pattern, "**")) {
            if (!StringsKt.contains$default((CharSequence) pattern, (CharSequence) "&&", false, 2, (Object) null)) {
                if (!StringsKt.contains$default((CharSequence) pattern, (CharSequence) "||", false, 2, (Object) null)) {
                    return (StringsKt.contains$default((CharSequence) pattern, (CharSequence) ">", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) pattern, (CharSequence) "<", false, 2, (Object) null)) ? SingleRangeMatcher.match(pattern, version) : PatternMatcher.match(pattern, version);
                }
                List listSplit$default = StringsKt.split$default((CharSequence) pattern, new String[]{"||"}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                Iterator it = listSplit$default.iterator();
                while (it.hasNext()) {
                    arrayList.add(StringsKt.trim((String) it.next()).toString());
                }
                if (arrayList.isEmpty()) {
                    return false;
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    if (SingleRangeMatcher.match((String) it2.next(), version)) {
                    }
                }
                return false;
            }
            List listSplit$default2 = StringsKt.split$default((CharSequence) pattern, new String[]{"&&"}, false, 0, 6, (Object) null);
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default2, 10));
            Iterator it3 = listSplit$default2.iterator();
            while (it3.hasNext()) {
                arrayList2.add(StringsKt.trim((String) it3.next()).toString());
            }
            if (!arrayList2.isEmpty()) {
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    if (!SingleRangeMatcher.match((String) it4.next(), version)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
