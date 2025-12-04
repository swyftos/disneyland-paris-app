package com.urbanairship.android.layout.info;

import com.disney.id.android.tracker.OneIDTrackerEvent;
import com.urbanairship.android.layout.property.ViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0001\u000bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/urbanairship/android/layout/info/ItemInfo;", "", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ViewInfo;", "(Lcom/urbanairship/android/layout/info/ViewInfo;)V", "getInfo", "()Lcom/urbanairship/android/layout/info/ViewInfo;", "type", "Lcom/urbanairship/android/layout/property/ViewType;", "getType", "()Lcom/urbanairship/android/layout/property/ViewType;", "ViewItemInfo", "Lcom/urbanairship/android/layout/info/ContainerLayoutItemInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo$ViewItemInfo;", "Lcom/urbanairship/android/layout/info/LinearLayoutItemInfo;", "Lcom/urbanairship/android/layout/info/PagerItemInfo;", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class ItemInfo {
    private final ViewInfo info;
    private final ViewType type;

    public /* synthetic */ ItemInfo(ViewInfo viewInfo, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewInfo);
    }

    private ItemInfo(ViewInfo viewInfo) {
        this.info = viewInfo;
        this.type = viewInfo.getType();
    }

    @NotNull
    public final ViewInfo getInfo() {
        return this.info;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/urbanairship/android/layout/info/ItemInfo$ViewItemInfo;", "Lcom/urbanairship/android/layout/info/ItemInfo;", OneIDTrackerEvent.EVENT_PARAM_ERROR_INFO, "Lcom/urbanairship/android/layout/info/ViewInfo;", "(Lcom/urbanairship/android/layout/info/ViewInfo;)V", "urbanairship-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ViewItemInfo extends ItemInfo {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewItemInfo(@NotNull ViewInfo info) {
            super(info, null);
            Intrinsics.checkNotNullParameter(info, "info");
        }
    }

    @NotNull
    public final ViewType getType() {
        return this.type;
    }
}
