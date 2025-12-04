package com.urbanairship.android.layout.view;

import com.urbanairship.android.layout.property.SmsLocale;
import com.urbanairship.util.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"displayValue", "", "Lcom/urbanairship/android/layout/property/SmsLocale;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SmsLocaleAdapterKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String displayValue(SmsLocale smsLocale) {
        return CollectionsKt.joinToString$default(CollectionsKt.listOf((Object[]) new String[]{StringExtensionsKt.getAirshipEmojiFlag(smsLocale.getCountryCode()), smsLocale.getCountryCode(), smsLocale.getPrefix()}), " ", null, null, 0, null, null, 62, null);
    }
}
