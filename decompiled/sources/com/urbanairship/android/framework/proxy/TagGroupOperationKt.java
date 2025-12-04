package com.urbanairship.android.framework.proxy;

import com.urbanairship.channel.TagGroupsEditor;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"applyOperation", "", "Lcom/urbanairship/android/framework/proxy/TagGroupOperation;", "editor", "Lcom/urbanairship/channel/TagGroupsEditor;", "airship-framework-proxy_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TagGroupOperationKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TagGroupOperationAction.values().length];
            try {
                iArr[TagGroupOperationAction.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TagGroupOperationAction.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TagGroupOperationAction.SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void applyOperation(@NotNull TagGroupOperation tagGroupOperation, @NotNull TagGroupsEditor editor) {
        Intrinsics.checkNotNullParameter(tagGroupOperation, "<this>");
        Intrinsics.checkNotNullParameter(editor, "editor");
        int i = WhenMappings.$EnumSwitchMapping$0[tagGroupOperation.getAction().ordinal()];
        if (i == 1) {
            editor.addTags(tagGroupOperation.getGroup(), CollectionsKt.toSet(tagGroupOperation.getTags()));
        } else if (i == 2) {
            editor.removeTags(tagGroupOperation.getGroup(), CollectionsKt.toSet(tagGroupOperation.getTags()));
        } else {
            if (i != 3) {
                return;
            }
            editor.setTags(tagGroupOperation.getGroup(), CollectionsKt.toSet(tagGroupOperation.getTags()));
        }
    }
}
