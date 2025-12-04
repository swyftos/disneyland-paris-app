package com.urbanairship.analytics;

import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0002¨\u0006\u0006"}, d2 = {"isLengthValid", "", "", "sizeInBytes", "", "Lcom/urbanairship/json/JsonMap;", "urbanairship-core_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CustomEventKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean isLengthValid(String str) {
        return str.length() < 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int sizeInBytes(JsonMap jsonMap) {
        String string = jsonMap.toJsonValue().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        byte[] bytes = string.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return bytes.length;
    }
}
