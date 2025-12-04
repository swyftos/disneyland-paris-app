package com.urbanairship.android.layout.model;

import android.content.Context;
import com.urbanairship.android.layout.info.ButtonLayoutInfo;
import com.urbanairship.android.layout.info.ItemInfo;
import com.urbanairship.android.layout.info.LabelInfo;
import com.urbanairship.android.layout.info.MediaInfo;
import com.urbanairship.android.layout.info.ViewGroupInfo;
import com.urbanairship.android.layout.info.ViewInfo;
import com.urbanairship.android.layout.util.ContextExtensionsKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\",\u0010\u0000\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00020\u0001*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"&\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"$\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"childContentDescriptionResolvers", "", "Lkotlin/Function1;", "Landroid/content/Context;", "", "Lcom/urbanairship/android/layout/info/ViewInfo;", "getChildContentDescriptionResolvers", "(Lcom/urbanairship/android/layout/info/ViewInfo;)Ljava/util/List;", "contentDescriptionResolver", "Lcom/urbanairship/android/layout/info/ButtonLayoutInfo;", "getContentDescriptionResolver", "(Lcom/urbanairship/android/layout/info/ButtonLayoutInfo;)Lkotlin/jvm/functions/Function1;", "reportingDescriptionResolver", "getReportingDescriptionResolver", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nButtonLayoutModel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ButtonLayoutModel.kt\ncom/urbanairship/android/layout/model/ButtonLayoutModelKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,94:1\n1360#2:95\n1446#2,5:96\n*S KotlinDebug\n*F\n+ 1 ButtonLayoutModel.kt\ncom/urbanairship/android/layout/model/ButtonLayoutModelKt\n*L\n68#1:95\n68#1:96,5\n*E\n"})
/* loaded from: classes5.dex */
public final class ButtonLayoutModelKt {
    private static final List getChildContentDescriptionResolvers(final ViewInfo viewInfo) {
        if (viewInfo instanceof LabelInfo) {
            return CollectionsKt.listOf(new Function1() { // from class: com.urbanairship.android.layout.model.ButtonLayoutModelKt$childContentDescriptionResolvers$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    String strResolveContentDescription = ContextExtensionsKt.resolveContentDescription(context, ((LabelInfo) viewInfo).getContentDescription(), ((LabelInfo) viewInfo).getLocalizedContentDescription());
                    return strResolveContentDescription == null ? ((LabelInfo) viewInfo).getText() : strResolveContentDescription;
                }
            });
        }
        if (viewInfo instanceof MediaInfo) {
            return CollectionsKt.listOf(new Function1() { // from class: com.urbanairship.android.layout.model.ButtonLayoutModelKt$childContentDescriptionResolvers$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    return ContextExtensionsKt.resolveContentDescription(context, ((MediaInfo) viewInfo).getContentDescription(), ((MediaInfo) viewInfo).getLocalizedContentDescription());
                }
            });
        }
        if (viewInfo instanceof ButtonLayoutInfo) {
            return CollectionsKt.emptyList();
        }
        if (!(viewInfo instanceof ViewGroupInfo)) {
            return CollectionsKt.emptyList();
        }
        List list = CollectionsKt.toList(((ViewGroupInfo) viewInfo).getChildren());
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, getChildContentDescriptionResolvers(((ItemInfo) it.next()).getInfo()));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 getContentDescriptionResolver(final ButtonLayoutInfo buttonLayoutInfo) {
        if (buttonLayoutInfo.getContentDescription() != null || buttonLayoutInfo.getLocalizedContentDescription() != null) {
            return new Function1() { // from class: com.urbanairship.android.layout.model.ButtonLayoutModelKt$contentDescriptionResolver$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final String invoke(Context context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    return ContextExtensionsKt.resolveContentDescription(context, buttonLayoutInfo.getContentDescription(), buttonLayoutInfo.getLocalizedContentDescription());
                }
            };
        }
        final List childContentDescriptionResolvers = getChildContentDescriptionResolvers(buttonLayoutInfo.getView());
        return new Function1() { // from class: com.urbanairship.android.layout.model.ButtonLayoutModelKt$contentDescriptionResolver$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                List list = childContentDescriptionResolvers;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) ((Function1) it.next()).invoke(context);
                    if (str != null) {
                        arrayList.add(str);
                    }
                }
                return CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 getReportingDescriptionResolver(final ButtonLayoutInfo buttonLayoutInfo) {
        return new Function1() { // from class: com.urbanairship.android.layout.model.ButtonLayoutModelKt$reportingDescriptionResolver$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Context context) {
                Intrinsics.checkNotNullParameter(context, "context");
                String strResolveContentDescription = ContextExtensionsKt.resolveContentDescription(context, buttonLayoutInfo.getContentDescription(), buttonLayoutInfo.getLocalizedContentDescription());
                return strResolveContentDescription == null ? buttonLayoutInfo.getIdentifier() : strResolveContentDescription;
            }
        };
    }
}
