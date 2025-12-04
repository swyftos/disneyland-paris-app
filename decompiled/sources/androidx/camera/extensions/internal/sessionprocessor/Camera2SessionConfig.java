package androidx.camera.extensions.internal.sessionprocessor;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
interface Camera2SessionConfig {
    List getOutputConfigs();

    Map getSessionParameters();

    int getSessionTemplateId();

    int getSessionType();
}
