package com.urbanairship.android.layout.info;

import com.urbanairship.android.layout.info.ItemInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u0082\u0001\r\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/urbanairship/android/layout/info/ViewGroupInfo;", "C", "Lcom/urbanairship/android/layout/info/ItemInfo;", "Lcom/urbanairship/android/layout/info/ViewInfo;", "()V", "children", "", "getChildren", "()Ljava/util/List;", "Lcom/urbanairship/android/layout/info/BaseToggleLayoutInfo;", "Lcom/urbanairship/android/layout/info/ButtonLayoutInfo;", "Lcom/urbanairship/android/layout/info/CheckboxControllerInfo;", "Lcom/urbanairship/android/layout/info/ContainerLayoutInfo;", "Lcom/urbanairship/android/layout/info/ControllerInfo;", "Lcom/urbanairship/android/layout/info/FormInfo;", "Lcom/urbanairship/android/layout/info/LinearLayoutInfo;", "Lcom/urbanairship/android/layout/info/PagerControllerInfo;", "Lcom/urbanairship/android/layout/info/PagerInfo;", "Lcom/urbanairship/android/layout/info/RadioInputControllerInfo;", "Lcom/urbanairship/android/layout/info/ScoreControllerInfo;", "Lcom/urbanairship/android/layout/info/ScrollLayoutInfo;", "Lcom/urbanairship/android/layout/info/StateControllerInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ViewGroupInfo<C extends ItemInfo> extends ViewInfo {
    public /* synthetic */ ViewGroupInfo(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract List<C> getChildren();

    private ViewGroupInfo() {
        super(null);
    }
}
