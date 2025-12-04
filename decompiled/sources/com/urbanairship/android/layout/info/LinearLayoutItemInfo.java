package com.urbanairship.android.layout.info;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.Size;
import com.urbanairship.json.JsonMap;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/urbanairship/android/layout/info/LinearLayoutItemInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "getJson", "()Lcom/urbanairship/json/JsonMap;", ViewProps.MARGIN, "Lcom/urbanairship/android/layout/property/Margin;", "getMargin", "()Lcom/urbanairship/android/layout/property/Margin;", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/Size;", "getSize", "()Lcom/urbanairship/android/layout/property/Size;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LinearLayoutItemInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:960\n1#3:975\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/LinearLayoutItemInfo\n*L\n465#1:945,15\n466#1:960,15\n*E\n"})
/* loaded from: classes5.dex */
public final class LinearLayoutItemInfo extends ItemInfo {
    private final JsonMap json;
    private final Margin margin;
    private final Size size;

    @NotNull
    public final JsonMap getJson() {
        return this.json;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x016c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public LinearLayoutItemInfo(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r21) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 826
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.LinearLayoutItemInfo.<init>(com.urbanairship.json.JsonMap):void");
    }

    @NotNull
    public final Size getSize() {
        return this.size;
    }

    @Nullable
    public final Margin getMargin() {
        return this.margin;
    }
}
