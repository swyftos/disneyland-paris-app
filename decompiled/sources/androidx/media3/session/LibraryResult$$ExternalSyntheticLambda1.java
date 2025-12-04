package androidx.media3.session;

import android.os.Bundle;
import androidx.media3.common.MediaItem;
import com.google.common.base.Function;

/* loaded from: classes.dex */
public final /* synthetic */ class LibraryResult$$ExternalSyntheticLambda1 implements Function {
    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        return MediaItem.fromBundle((Bundle) obj);
    }
}
