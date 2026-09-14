package com.urbanairship.android.layout.widget;

import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005À\u0006\u0003"}, m1836d2 = {"Lcom/urbanairship/android/layout/widget/TappableView;", "", "taps", "Lkotlinx/coroutines/flow/Flow;", "", "urbanairship-layout_release"}, m1837k = 1, m1838mv = {1, 9, 0}, m1840xi = 48)
public interface TappableView {
    @NotNull
    Flow<Unit> taps();
}
