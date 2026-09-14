package com.facebook.common.lifecycle;

import android.view.View;
import com.facebook.infer.annotation.Nullsafe;

/* JADX INFO: loaded from: classes3.dex */
@Nullsafe(Nullsafe.Mode.LOCAL)
public interface AttachDetachListener {
    void onAttachToView(View view);

    void onDetachFromView(View view);
}
