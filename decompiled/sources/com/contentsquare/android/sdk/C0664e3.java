package com.contentsquare.android.sdk;

import androidx.annotation.WorkerThread;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nMutationDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutationDetector.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/MutationDetector\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,143:1\n1#2:144\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.e3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0664e3 {

    @Nullable
    public ViewLight a;

    @SourceDebugExtension({"SMAP\nMutationDetector.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MutationDetector.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/MutationDetector$Companion\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,143:1\n2624#2,3:144\n*S KotlinDebug\n*F\n+ 1 MutationDetector.kt\ncom/contentsquare/android/internal/features/sessionreplay/processing/MutationDetector$Companion\n*L\n132#1:144,3\n*E\n"})
    /* renamed from: com.contentsquare.android.sdk.e3$a */
    public static final class a {
        public static void a(ViewLight viewLight, ViewLight viewLight2, long j, ArrayList arrayList) {
            if (viewLight.getRecordingId() != viewLight2.getRecordingId()) {
                arrayList.add(new C0684g3(j, viewLight.getRecordingId()));
                arrayList.add(new C0674f3(j, viewLight2.getParentId(), viewLight2.getIndexInParent(), viewLight2));
                return;
            }
            if (ViewLight.INSTANCE.hasChangedSinceThePreviousFrame(viewLight, viewLight2)) {
                arrayList.add(new C0694h3(j, viewLight2.getRecordingId(), viewLight2));
            }
            List<ViewLight> children = viewLight2.getChildren();
            List<ViewLight> children2 = viewLight.getChildren();
            for (ViewLight viewLight3 : children) {
                if (children2 == null || !children2.isEmpty()) {
                    Iterator<T> it = children2.iterator();
                    while (it.hasNext()) {
                        if (((ViewLight) it.next()).getRecordingId() == viewLight3.getRecordingId()) {
                            break;
                        }
                    }
                }
                arrayList.add(new C0674f3(j, viewLight3.getParentId(), viewLight3.getIndexInParent(), viewLight3));
            }
            for (ViewLight viewLight4 : children2) {
                Iterator<ViewLight> it2 = children.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        arrayList.add(new C0684g3(j, viewLight4.getRecordingId()));
                        break;
                    }
                    ViewLight next = it2.next();
                    if (viewLight4.getRecordingId() == next.getRecordingId()) {
                        a(viewLight4, next, j, arrayList);
                        break;
                    }
                }
            }
        }
    }

    @WorkerThread
    @NotNull
    public final synchronized ArrayList a(@NotNull ViewLight currentTreeLight, long j) {
        ArrayList arrayList;
        try {
            Intrinsics.checkNotNullParameter(currentTreeLight, "currentTreeLight");
            ViewLight viewLight = this.a;
            arrayList = new ArrayList();
            if (viewLight == null) {
                arrayList.add(new C0674f3(j, -1L, -1, currentTreeLight));
            } else {
                a.a(viewLight, currentTreeLight, j, arrayList);
            }
            ViewLight viewLight2 = this.a;
            this.a = currentTreeLight;
            if (viewLight2 != null) {
                ViewLight.INSTANCE.recycleRecursive(viewLight2);
            }
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }
}
