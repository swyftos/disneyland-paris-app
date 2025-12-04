package com.facebook.react.uimanager;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;

@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0087\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/facebook/react/uimanager/ReactStage;", "", "Companion", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
/* loaded from: classes3.dex */
public @interface ReactStage {
    public static final int BRIDGE_DID_LOAD = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final int MODULE_DID_LOAD = 2;
    public static final int ON_ATTACH_TO_INSTANCE = 101;
    public static final int SURFACE_DID_INITIALIZE = 0;
    public static final int SURFACE_DID_INITIAL_LAYOUT = 5;
    public static final int SURFACE_DID_INITIAL_MOUNTING = 6;
    public static final int SURFACE_DID_INITIAL_RENDERING = 4;
    public static final int SURFACE_DID_RUN = 3;
    public static final int SURFACE_DID_STOP = 7;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/uimanager/ReactStage$Companion;", "", "<init>", "()V", "SURFACE_DID_INITIALIZE", "", "BRIDGE_DID_LOAD", "MODULE_DID_LOAD", "SURFACE_DID_RUN", "SURFACE_DID_INITIAL_RENDERING", "SURFACE_DID_INITIAL_LAYOUT", "SURFACE_DID_INITIAL_MOUNTING", "SURFACE_DID_STOP", "ON_ATTACH_TO_INSTANCE", "ReactAndroid_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int BRIDGE_DID_LOAD = 1;
        public static final int MODULE_DID_LOAD = 2;
        public static final int ON_ATTACH_TO_INSTANCE = 101;
        public static final int SURFACE_DID_INITIALIZE = 0;
        public static final int SURFACE_DID_INITIAL_LAYOUT = 5;
        public static final int SURFACE_DID_INITIAL_MOUNTING = 6;
        public static final int SURFACE_DID_INITIAL_RENDERING = 4;
        public static final int SURFACE_DID_RUN = 3;
        public static final int SURFACE_DID_STOP = 7;

        private Companion() {
        }
    }
}
