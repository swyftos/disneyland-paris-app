package com.contentsquare.android.sdk;

import android.view.View;
import com.contentsquare.android.core.CoreModule;
import com.contentsquare.android.core.communication.compose.ComposeInterface;
import com.contentsquare.android.core.communication.sessionreplay.ViewLight;
import com.contentsquare.android.core.features.preferences.PreferencesKey;
import com.contentsquare.android.core.utils.JsonConfigFeatureFlagNames;
import com.contentsquare.android.core.utils.SystemInstantiable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nAndroidViewToViewLightConverter.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AndroidViewToViewLightConverter.kt\ncom/contentsquare/android/internal/features/sessionreplay/viewcapturing/AndroidViewToViewLightConverter\n+ 2 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,359:1\n179#2,2:360\n*S KotlinDebug\n*F\n+ 1 AndroidViewToViewLightConverter.kt\ncom/contentsquare/android/internal/features/sessionreplay/viewcapturing/AndroidViewToViewLightConverter\n*L\n305#1:360,2\n*E\n"})
/* renamed from: com.contentsquare.android.sdk.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0819u {

    @NotNull
    public final SystemInstantiable a;

    @NotNull
    public final Z2 b;

    @Nullable
    public final ComposeInterface c;

    @Nullable
    public final C0847x d;

    @NotNull
    public final int[] e;

    @NotNull
    public final C0794r4 f;

    @NotNull
    public final I3 g;
    public boolean h;

    public C0819u(@NotNull SystemInstantiable systemInstantiable, @NotNull Z2 maskingParameter, @Nullable ComposeInterface composeInterface, @Nullable C0847x c0847x) {
        Intrinsics.checkNotNullParameter(systemInstantiable, "systemInstantiable");
        Intrinsics.checkNotNullParameter(maskingParameter, "maskingParameter");
        this.a = systemInstantiable;
        this.b = maskingParameter;
        this.c = composeInterface;
        this.d = c0847x;
        this.e = new int[2];
        this.f = new C0794r4();
        this.g = new I3(new J3());
    }

    @NotNull
    public final ViewLight a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.h = C0848x0.a(CoreModule.INSTANCE.getInstance(), JsonConfigFeatureFlagNames.SNAPSHOT_CAPTURE_SR);
        view.getLocationInWindow(this.e);
        int[] iArr = this.e;
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth() + i;
        int height = view.getHeight() + this.e[1];
        int[] iArr2 = this.e;
        return a(i, i2, width, height, view, iArr2[0], iArr2[1], this.b.a.getBoolean(PreferencesKey.SESSION_REPLAY_DEFAULT_MASKING, true));
    }

    public final void a(View view, int i, int i2, int i3, int i4, ViewLight viewLight) {
        view.getLocationInWindow(this.e);
        if (view.getVisibility() == 0) {
            C0794r4 c0794r4 = this.f;
            int[] iArr = this.e;
            int i5 = iArr[0];
            int i6 = iArr[1];
            int width = view.getWidth();
            int height = view.getHeight();
            c0794r4.getClass();
            if (width + i5 <= i || height + i6 <= i2 || i5 >= i + i3 || i6 >= i2 + i4) {
                return;
            }
            int[] iArr2 = this.e;
            ViewLight viewLightA = a(i, i2, i3, i4, view, iArr2[0], iArr2[1], viewLight.getIsMasked());
            viewLightA.setParentId(viewLight.getRecordingId());
            viewLightA.setIndexInParent(viewLight.getChildren().size());
            viewLight.getChildren().add(viewLightA);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.contentsquare.android.core.communication.sessionreplay.ViewLight a(int r19, int r20, int r21, int r22, android.view.View r23, int r24, int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 589
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.contentsquare.android.sdk.C0819u.a(int, int, int, int, android.view.View, int, int, boolean):com.contentsquare.android.core.communication.sessionreplay.ViewLight");
    }
}
