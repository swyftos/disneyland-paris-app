package com.urbanairship.android.layout.property;

import com.urbanairship.android.layout.property.EventHandler;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0000\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0000¨\u0006\u0005"}, d2 = {"hasFormInputHandler", "", "", "Lcom/urbanairship/android/layout/property/EventHandler;", "hasTapHandler", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEventHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EventHandler.kt\ncom/urbanairship/android/layout/property/EventHandlerKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,37:1\n1747#2,3:38\n1747#2,3:41\n*S KotlinDebug\n*F\n+ 1 EventHandler.kt\ncom/urbanairship/android/layout/property/EventHandlerKt\n*L\n33#1:38,3\n36#1:41,3\n*E\n"})
/* loaded from: classes5.dex */
public final class EventHandlerKt {
    public static final boolean hasTapHandler(@Nullable List<EventHandler> list) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((EventHandler) it.next()).getType() == EventHandler.Type.TAP) {
                return true;
            }
        }
        return false;
    }

    public static final boolean hasFormInputHandler(@Nullable List<EventHandler> list) {
        if (list == null) {
            list = CollectionsKt.emptyList();
        }
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((EventHandler) it.next()).getType() == EventHandler.Type.FORM_INPUT) {
                return true;
            }
        }
        return false;
    }
}
