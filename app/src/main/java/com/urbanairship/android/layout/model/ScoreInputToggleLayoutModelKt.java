package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.ScoreToggleLayoutInfo;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(m1835d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, m1836d2 = {"asSelected", "Lcom/urbanairship/android/layout/environment/State$Score$Selected;", "Lcom/urbanairship/android/layout/info/ScoreToggleLayoutInfo;", "urbanairship-layout_release"}, m1837k = 2, m1838mv = {1, 9, 0}, m1840xi = 48)
public final class ScoreInputToggleLayoutModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final State.Score.Selected asSelected(ScoreToggleLayoutInfo scoreToggleLayoutInfo) {
        return new State.Score.Selected(scoreToggleLayoutInfo.getIdentifier(), scoreToggleLayoutInfo.getReportingValue(), scoreToggleLayoutInfo.getAttributeValue());
    }
}
