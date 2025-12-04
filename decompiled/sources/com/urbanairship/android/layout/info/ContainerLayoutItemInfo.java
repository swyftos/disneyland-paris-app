package com.urbanairship.android.layout.info;

import com.facebook.react.uimanager.ViewProps;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import com.urbanairship.android.layout.property.Margin;
import com.urbanairship.android.layout.property.Position;
import com.urbanairship.android.layout.property.Size;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/info/ContainerLayoutItemInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo;", "Lcom/urbanairship/android/layout/info/SafeAreaAware;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "ignoreSafeArea", "", "getIgnoreSafeArea", "()Z", ViewProps.MARGIN, "Lcom/urbanairship/android/layout/property/Margin;", "getMargin", "()Lcom/urbanairship/android/layout/property/Margin;", ViewProps.POSITION, "Lcom/urbanairship/android/layout/property/Position;", "getPosition", "()Lcom/urbanairship/android/layout/property/Position;", TCEventPropertiesNames.TCP_SIZE, "Lcom/urbanairship/android/layout/property/Size;", "getSize", "()Lcom/urbanairship/android/layout/property/Size;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ContainerLayoutItemInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:960\n44#2,15:975\n1#3:990\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/ContainerLayoutItemInfo\n*L\n480#1:945,15\n481#1:960,15\n482#1:975,15\n*E\n"})
/* loaded from: classes5.dex */
public final class ContainerLayoutItemInfo extends ItemInfo implements SafeAreaAware {
    private final /* synthetic */ SafeAreaAware $$delegate_0;
    private final Margin margin;
    private final Position position;
    private final Size size;

    @Override // com.urbanairship.android.layout.info.SafeAreaAware
    public boolean getIgnoreSafeArea() {
        return this.$$delegate_0.getIgnoreSafeArea();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ContainerLayoutItemInfo(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r23) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 1217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.ContainerLayoutItemInfo.<init>(com.urbanairship.json.JsonMap):void");
    }

    @NotNull
    public final Position getPosition() {
        return this.position;
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
