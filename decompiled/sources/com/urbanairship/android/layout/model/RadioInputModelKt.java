package com.urbanairship.android.layout.model;

import com.urbanairship.android.layout.environment.State;
import com.urbanairship.android.layout.info.RadioInputInfo;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0002¨\u0006\u0003"}, d2 = {"asSelected", "Lcom/urbanairship/android/layout/environment/State$Radio$Selected;", "Lcom/urbanairship/android/layout/info/RadioInputInfo;", "urbanairship-layout_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RadioInputModelKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final State.Radio.Selected asSelected(RadioInputInfo radioInputInfo) {
        return new State.Radio.Selected(null, radioInputInfo.getReportingValue(), radioInputInfo.getAttributeValue());
    }
}
