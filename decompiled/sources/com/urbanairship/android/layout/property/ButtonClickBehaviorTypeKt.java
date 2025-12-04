package com.urbanairship.android.layout.property;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0016\u001a\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001e\u0010\u0004\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001e\u0010\b\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007\"\u001e\u0010\n\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007\"\u001e\u0010\f\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007\"\u001e\u0010\u000e\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007\"\u001e\u0010\u0010\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007\"\u001e\u0010\u0012\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007\"\u001e\u0010\u0014\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007\"\u001e\u0010\u0016\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007\"\u001e\u0010\u0018\u001a\u00020\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001b"}, d2 = {"pagerNextBehaviors", "", "Lcom/urbanairship/android/layout/property/ButtonClickBehaviorType;", "storyNavigationBehaviors", "hasCancel", "", "getHasCancel", "(Ljava/util/List;)Z", "hasCancelOrDismiss", "getHasCancelOrDismiss", "hasDismiss", "getHasDismiss", "hasFormSubmit", "getHasFormSubmit", "hasFormValidate", "getHasFormValidate", "hasPagerNext", "getHasPagerNext", "hasPagerPause", "getHasPagerPause", "hasPagerPrevious", "getHasPagerPrevious", "hasPagerResume", "getHasPagerResume", "hasStoryNavigationBehavior", "getHasStoryNavigationBehavior", "firstPagerNextOrNull", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nButtonClickBehaviorType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ButtonClickBehaviorType.kt\ncom/urbanairship/android/layout/property/ButtonClickBehaviorTypeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,97:1\n1747#2,3:98\n1747#2,3:101\n288#2,2:104\n*S KotlinDebug\n*F\n+ 1 ButtonClickBehaviorType.kt\ncom/urbanairship/android/layout/property/ButtonClickBehaviorTypeKt\n*L\n60#1:98,3\n90#1:101,3\n96#1:104,2\n*E\n"})
/* loaded from: classes5.dex */
public final class ButtonClickBehaviorTypeKt {
    private static final List pagerNextBehaviors;
    private static final List storyNavigationBehaviors;

    static {
        ButtonClickBehaviorType buttonClickBehaviorType = ButtonClickBehaviorType.CANCEL;
        ButtonClickBehaviorType buttonClickBehaviorType2 = ButtonClickBehaviorType.DISMISS;
        ButtonClickBehaviorType buttonClickBehaviorType3 = ButtonClickBehaviorType.PAGER_NEXT;
        ButtonClickBehaviorType buttonClickBehaviorType4 = ButtonClickBehaviorType.PAGER_PREVIOUS;
        ButtonClickBehaviorType buttonClickBehaviorType5 = ButtonClickBehaviorType.PAGER_NEXT_OR_DISMISS;
        ButtonClickBehaviorType buttonClickBehaviorType6 = ButtonClickBehaviorType.PAGER_NEXT_OR_FIRST;
        storyNavigationBehaviors = CollectionsKt.listOf((Object[]) new ButtonClickBehaviorType[]{buttonClickBehaviorType, buttonClickBehaviorType2, buttonClickBehaviorType3, buttonClickBehaviorType4, buttonClickBehaviorType5, buttonClickBehaviorType6, ButtonClickBehaviorType.PAGER_PAUSE, ButtonClickBehaviorType.PAGER_RESUME});
        pagerNextBehaviors = CollectionsKt.listOf((Object[]) new ButtonClickBehaviorType[]{buttonClickBehaviorType3, buttonClickBehaviorType5, buttonClickBehaviorType6});
    }

    public static final boolean getHasPagerPause(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.PAGER_PAUSE);
    }

    public static final boolean getHasPagerResume(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.PAGER_RESUME);
    }

    public static final boolean getHasFormSubmit(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.FORM_SUBMIT);
    }

    public static final boolean getHasFormValidate(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.FORM_VALIDATE);
    }

    public static final boolean getHasDismiss(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.DISMISS);
    }

    public static final boolean getHasCancel(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.CANCEL);
    }

    public static final boolean getHasCancelOrDismiss(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return getHasCancel(list) || getHasDismiss(list);
    }

    public static final boolean getHasPagerPrevious(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        return list.contains(ButtonClickBehaviorType.PAGER_PREVIOUS);
    }

    public static final boolean getHasStoryNavigationBehavior(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (storyNavigationBehaviors.contains((ButtonClickBehaviorType) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static final boolean getHasPagerNext(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (pagerNextBehaviors.contains((ButtonClickBehaviorType) it.next())) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public static final ButtonClickBehaviorType firstPagerNextOrNull(@NotNull List<? extends ButtonClickBehaviorType> list) {
        Object next;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (pagerNextBehaviors.contains((ButtonClickBehaviorType) next)) {
                break;
            }
        }
        return (ButtonClickBehaviorType) next;
    }
}
