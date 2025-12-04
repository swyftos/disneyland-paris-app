package com.facebook.react.common.build;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/react/common/build/ReactBuildConfig;", "", "<init>", "()V", "DEBUG", "", "IS_INTERNAL_BUILD", "ENABLE_PERFETTO", "EXOPACKAGE_FLAGS", "", "UNSTABLE_ENABLE_FUSEBOX_RELEASE", "UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReactBuildConfig {

    @JvmField
    public static final boolean DEBUG = false;

    @JvmField
    public static final boolean ENABLE_PERFETTO = false;

    @JvmField
    public static final int EXOPACKAGE_FLAGS = 0;

    @NotNull
    public static final ReactBuildConfig INSTANCE = new ReactBuildConfig();

    @JvmField
    public static final boolean IS_INTERNAL_BUILD = false;

    @JvmField
    public static final boolean UNSTABLE_ENABLE_FUSEBOX_RELEASE = false;

    @JvmField
    public static final boolean UNSTABLE_ENABLE_MINIFY_LEGACY_ARCHITECTURE = false;

    private ReactBuildConfig() {
    }
}
