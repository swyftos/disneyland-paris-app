package com.urbanairship.android.layout.info;

import com.urbanairship.android.layout.info.ItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/urbanairship/android/layout/info/NpsFormControllerInfo;", "Lcom/urbanairship/android/layout/info/FormInfo;", "json", "Lcom/urbanairship/json/JsonMap;", "(Lcom/urbanairship/json/JsonMap;)V", "children", "", "Lcom/urbanairship/android/layout/info/ItemInfo$ViewItemInfo;", "getChildren", "()Ljava/util/List;", "npsIdentifier", "", "getNpsIdentifier", "()Ljava/lang/String;", "view", "Lcom/urbanairship/android/layout/info/ViewInfo;", "getView", "()Lcom/urbanairship/android/layout/info/ViewInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nViewInfo.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/NpsFormControllerInfo\n+ 2 JsonExtensions.kt\ncom/urbanairship/json/JsonExtensionsKt\n*L\n1#1,944:1\n44#2,15:945\n44#2,15:960\n*S KotlinDebug\n*F\n+ 1 ViewInfo.kt\ncom/urbanairship/android/layout/info/NpsFormControllerInfo\n*L\n865#1:945,15\n868#1:960,15\n*E\n"})
/* loaded from: classes5.dex */
public final class NpsFormControllerInfo extends FormInfo {
    private final List children;
    private final String npsIdentifier;
    private final ViewInfo view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public NpsFormControllerInfo(@org.jetbrains.annotations.NotNull com.urbanairship.json.JsonMap r22) throws com.urbanairship.json.JsonException {
        /*
            Method dump skipped, instructions count: 822
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.urbanairship.android.layout.info.NpsFormControllerInfo.<init>(com.urbanairship.json.JsonMap):void");
    }

    @Override // com.urbanairship.android.layout.info.FormInfo, com.urbanairship.android.layout.info.Controller
    @NotNull
    public ViewInfo getView() {
        return this.view;
    }

    @Override // com.urbanairship.android.layout.info.ViewGroupInfo
    @NotNull
    public List<ItemInfo.ViewItemInfo> getChildren() {
        return this.children;
    }

    @NotNull
    public final String getNpsIdentifier() {
        return this.npsIdentifier;
    }
}
