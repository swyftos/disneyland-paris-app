package com.urbanairship.android.layout.property;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001e\u0010\u0005\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"earliestNavigationAction", "Lcom/urbanairship/android/layout/property/AutomatedAction;", "", "getEarliestNavigationAction", "(Ljava/util/List;)Lcom/urbanairship/android/layout/property/AutomatedAction;", "hasPagerPauseOrResumeAction", "", "getHasPagerPauseOrResumeAction", "(Ljava/util/List;)Z", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nAutomatedAction.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AutomatedAction.kt\ncom/urbanairship/android/layout/property/AutomatedActionKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,53:1\n288#2,2:54\n1747#2,3:56\n*S KotlinDebug\n*F\n+ 1 AutomatedAction.kt\ncom/urbanairship/android/layout/property/AutomatedActionKt\n*L\n46#1:54,2\n52#1:56,3\n*E\n"})
/* loaded from: classes5.dex */
public final class AutomatedActionKt {
    public static final boolean getHasPagerPauseOrResumeAction(@NotNull List<AutomatedAction> list) {
        List<ButtonClickBehaviorType> behaviors;
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list != null && list.isEmpty()) {
            return false;
        }
        for (AutomatedAction automatedAction : list) {
            List<ButtonClickBehaviorType> behaviors2 = automatedAction.getBehaviors();
            if ((behaviors2 != null && ButtonClickBehaviorTypeKt.getHasPagerPause(behaviors2)) || ((behaviors = automatedAction.getBehaviors()) != null && ButtonClickBehaviorTypeKt.getHasPagerResume(behaviors))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final AutomatedAction getEarliestNavigationAction(@NotNull List<AutomatedAction> list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            List<ButtonClickBehaviorType> behaviors = ((AutomatedAction) next).getBehaviors();
            if (behaviors != null ? ButtonClickBehaviorTypeKt.getHasStoryNavigationBehavior(behaviors) : false) {
                break;
            }
        }
        return (AutomatedAction) next;
    }
}
