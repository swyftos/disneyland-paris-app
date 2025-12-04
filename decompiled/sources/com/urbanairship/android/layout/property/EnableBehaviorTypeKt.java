package com.urbanairship.android.layout.property;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\" \u0010\u0000\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\" \u0010\u0006\u001a\u00020\u0001*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"hasFormBehaviors", "", "", "Lcom/urbanairship/android/layout/property/EnableBehaviorType;", "getHasFormBehaviors", "(Ljava/util/List;)Z", "hasPagerBehaviors", "getHasPagerBehaviors", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nEnableBehaviorType.kt\nKotlin\n*S Kotlin\n*F\n+ 1 EnableBehaviorType.kt\ncom/urbanairship/android/layout/property/EnableBehaviorTypeKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,40:1\n1747#2,3:41\n1747#2,3:44\n*S KotlinDebug\n*F\n+ 1 EnableBehaviorType.kt\ncom/urbanairship/android/layout/property/EnableBehaviorTypeKt\n*L\n32#1:41,3\n37#1:44,3\n*E\n"})
/* loaded from: classes5.dex */
public final class EnableBehaviorTypeKt {
    public static final boolean getHasPagerBehaviors(@Nullable List<? extends EnableBehaviorType> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (EnableBehaviorType enableBehaviorType : list) {
            if (enableBehaviorType == EnableBehaviorType.PAGER_NEXT || enableBehaviorType == EnableBehaviorType.PAGER_PREVIOUS) {
                return true;
            }
        }
        return false;
    }

    public static final boolean getHasFormBehaviors(@Nullable List<? extends EnableBehaviorType> list) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        for (EnableBehaviorType enableBehaviorType : list) {
            if (enableBehaviorType == EnableBehaviorType.FORM_VALIDATION || enableBehaviorType == EnableBehaviorType.FORM_SUBMISSION) {
                return true;
            }
        }
        return false;
    }
}
