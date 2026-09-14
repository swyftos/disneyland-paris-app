package coil3.decode;

import androidx.annotation.DrawableRes;
import com.google.firebase.messaging.Constants;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, m1836d2 = {"Lcoil3/decode/ResourceMetadata;", "Lcoil3/decode/ImageSource$Metadata;", Constants.FirelogAnalytics.PARAM_PACKAGE_NAME, "", "resId", "", TCEventPropertiesNames.TCD_SCREEN_DENSITY, "<init>", "(Ljava/lang/String;II)V", "getPackageName", "()Ljava/lang/String;", "getResId", "()I", "getDensity", "coil-core_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class ResourceMetadata extends ImageSource.Metadata {
    private final int density;
    private final String packageName;
    private final int resId;

    @NotNull
    public final String getPackageName() {
        return this.packageName;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getDensity() {
        return this.density;
    }

    public ResourceMetadata(@NotNull String str, @DrawableRes int i, int i2) {
        this.packageName = str;
        this.resId = i;
        this.density = i2;
    }
}
