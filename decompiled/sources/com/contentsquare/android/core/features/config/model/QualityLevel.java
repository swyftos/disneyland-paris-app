package com.contentsquare.android.core.features.config.model;

import ch.qos.logback.core.CoreConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0001\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0011"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/QualityLevel;", "", "fps", "", "densityScaleDown", "", "(Ljava/lang/String;IIF)V", "getDensityScaleDown", "()F", "getFps", "()I", "toString", "", "LOW", "MEDIUM", "HIGH", "Companion", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public enum QualityLevel {
    LOW(5, 2.0f),
    MEDIUM(10, 1.5f),
    HIGH(10, 1.0f);


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DEFAULT_RECORDING_QUALITY;
    private final float densityScaleDown;

    /* renamed from: fps, reason: from kotlin metadata and from toString */
    private final int FPS;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/contentsquare/android/core/features/config/model/QualityLevel$Companion;", "", "()V", "DEFAULT_RECORDING_QUALITY", "", "getDEFAULT_RECORDING_QUALITY", "()Ljava/lang/String;", "valueOfIgnoreCase", "Lcom/contentsquare/android/core/features/config/model/QualityLevel;", "name", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final String getDEFAULT_RECORDING_QUALITY() {
            return QualityLevel.DEFAULT_RECORDING_QUALITY;
        }

        @NotNull
        public final QualityLevel valueOfIgnoreCase(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            String upperCase = name.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return QualityLevel.valueOf(upperCase);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        String lowerCase = "MEDIUM".toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        DEFAULT_RECORDING_QUALITY = lowerCase;
    }

    QualityLevel(int i, float f) {
        this.FPS = i;
        this.densityScaleDown = f;
    }

    public final float getDensityScaleDown() {
        return this.densityScaleDown;
    }

    /* renamed from: getFps, reason: from getter */
    public final int getFPS() {
        return this.FPS;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return name() + " (FPS=" + this.FPS + " ImageQuality=" + this.densityScaleDown + CoreConstants.LEFT_PARENTHESIS_CHAR + ordinal() + "))";
    }
}
