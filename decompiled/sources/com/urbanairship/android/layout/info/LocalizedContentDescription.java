package com.urbanairship.android.layout.info;

import ch.qos.logback.core.joran.action.ActionConst;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/urbanairship/android/layout/info/LocalizedContentDescription;", "", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "fallback", "", "getFallback", "()Ljava/lang/String;", ActionConst.REF_ATTRIBUTE, "getRef", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LocalizedContentDescription\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n79#2,16:945\n44#2,15:961\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LocalizedContentDescription\n*L\n742#1:945,16\n743#1:961,15\n*E\n"})
/* loaded from: classes5.dex */
public final class LocalizedContentDescription {
    private final String fallback;
    private final String ref;

    /* JADX WARN: Removed duplicated region for block: B:107:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0154  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LocalizedContentDescription(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r18) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 749
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.LocalizedContentDescription.<init>(com.urbanairship.json.JsonMap):void");
    }

    @Nullable
    public final String getRef() {
        return this.ref;
    }

    @NotNull
    public final String getFallback() {
        return this.fallback;
    }
}
