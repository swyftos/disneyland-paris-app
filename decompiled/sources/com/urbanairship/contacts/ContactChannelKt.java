package com.urbanairship.contacts;

import gherkin.GherkinLanguageConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0001H\u0002¨\u0006\u0004"}, d2 = {"maskEmail", "", "maskPhoneNumber", "replaceAsterisks", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ContactChannelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String maskEmail(String str) {
        if (str.length() <= 0) {
            return str;
        }
        String strTake = StringsKt.take(str, 1);
        if (!StringsKt.contains$default((CharSequence) str, (CharSequence) GherkinLanguageConstants.TAG_PREFIX, false, 2, (Object) null)) {
            return str;
        }
        List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{GherkinLanguageConstants.TAG_PREFIX}, false, 0, 6, (Object) null);
        String str2 = (String) CollectionsKt.last(listSplit$default);
        return strTake + StringsKt.repeat("●", ((String) CollectionsKt.first(listSplit$default)).length() - 1) + '@' + str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String maskPhoneNumber(String str) {
        if (str.length() <= 0 || str.length() <= 4) {
            return str;
        }
        return StringsKt.repeat("●", str.length() - 4) + StringsKt.takeLast(str, 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String replaceAsterisks(String str) {
        return StringsKt.replace$default(str, "*", "●", false, 4, (Object) null);
    }
}
