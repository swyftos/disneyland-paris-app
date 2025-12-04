package com.contentsquare.android.api.bridge.telemetry;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MimeTypes;
import com.contentsquare.android.internal.core.telemetry.Telemetry;
import com.contentsquare.android.internal.core.telemetry.event.ApiUsageEvent;
import com.contentsquare.android.sdk.C0698h7;
import com.contentsquare.android.sdk.U8;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tJ\u001d\u0010\n\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000b¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000b¢\u0006\u0002\u0010\rJ\u001d\u0010\u000f\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000b¢\u0006\u0002\u0010\rJ%\u0010\u0010\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u0002H\u000b¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0007¢\u0006\u0002\u0010\rJ\u001f\u0010\u0014\u001a\u00020\u0004\"\b\b\u0000\u0010\u000b*\u00020\u00012\u0006\u0010\f\u001a\u0002H\u000bH\u0007¢\u0006\u0002\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/contentsquare/android/api/bridge/telemetry/TelemetryInterface;", "", "()V", "collectApiCall", "", "apiName", "", "notifyPAisStarted", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "setXPFBridgeVersion", ExifInterface.GPS_DIRECTION_TRUE, "value", "(Ljava/lang/Object;)V", "setXPFType", "setXPFVersion", "telemetryCollect", "name", "(Ljava/lang/String;Ljava/lang/Object;)V", "telemetrySetXPFType", "telemetrySetXPFVersion", "library_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TelemetryInterface {
    public final void collectApiCall(@NotNull String apiName) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            String name = "custom." + apiName;
            Intrinsics.checkNotNullParameter(name, "name");
            telemetryManager$library_release.e.a(new ApiUsageEvent(name, 1L));
        }
    }

    public final void notifyPAisStarted(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "application");
        Telemetry.INSTANCE.notifyPAisStarted$library_release(application);
    }

    public final <T> void setXPFBridgeVersion(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("xpf_bridge_version", value);
        }
        U8.c = value.toString();
    }

    public final <T> void setXPFType(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("xpf_type", value);
        }
        U8.a = value.toString();
    }

    public final <T> void setXPFVersion(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("xpf_version", value);
        }
        U8.b = value.toString();
    }

    public final <T> void telemetryCollect(@NotNull String name, @NotNull T value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("custom." + name, value);
        }
    }

    @Deprecated(message = "This function is deprecated and will be removed in future releases. Use [setXPFType] instead.", replaceWith = @ReplaceWith(expression = "setXPFType(value)", imports = {}))
    public final <T> void telemetrySetXPFType(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("xpf_type", value);
        }
    }

    @Deprecated(message = "This function is deprecated and will be removed in future releases. Use [setXPFVersion] instead.", replaceWith = @ReplaceWith(expression = "setXPFVersion(value)", imports = {}))
    public final <T> void telemetrySetXPFVersion(@NotNull T value) {
        Intrinsics.checkNotNullParameter(value, "value");
        C0698h7 telemetryManager$library_release = Telemetry.INSTANCE.getTelemetryManager$library_release();
        if (telemetryManager$library_release != null) {
            telemetryManager$library_release.a("xpf_version", value);
        }
    }
}
