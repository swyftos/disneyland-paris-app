package androidx.camera.extensions.internal.sessionprocessor;

import android.hardware.camera2.CaptureRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class Camera2SessionConfigBuilder {
    private int mSessionTemplateId = 1;
    private int mSessionType = 0;
    private Map mSessionParameters = new HashMap();
    private List mCamera2OutputConfigs = new ArrayList();

    Camera2SessionConfigBuilder() {
    }

    Camera2SessionConfigBuilder addOutputConfig(Camera2OutputConfig camera2OutputConfig) {
        this.mCamera2OutputConfigs.add(camera2OutputConfig);
        return this;
    }

    Camera2SessionConfigBuilder addSessionParameter(CaptureRequest.Key key, Object obj) {
        this.mSessionParameters.put(key, obj);
        return this;
    }

    Camera2SessionConfigBuilder setSessionTemplateId(int i) {
        this.mSessionTemplateId = i;
        return this;
    }

    Camera2SessionConfigBuilder setSessionType(int i) {
        this.mSessionType = i;
        return this;
    }

    Camera2SessionConfig build() {
        return new SessionConfigImpl(this.mSessionTemplateId, this.mSessionType, this.mSessionParameters, this.mCamera2OutputConfigs);
    }

    private static class SessionConfigImpl implements Camera2SessionConfig {
        private final List mCamera2OutputConfigs;
        private final Map mSessionParameters;
        private final int mSessionTemplateId;
        private final int mSessionType;

        SessionConfigImpl(int i, int i2, Map map, List list) {
            this.mSessionTemplateId = i;
            this.mSessionType = i2;
            this.mSessionParameters = map;
            this.mCamera2OutputConfigs = list;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public List getOutputConfigs() {
            return this.mCamera2OutputConfigs;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public Map getSessionParameters() {
            return this.mSessionParameters;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public int getSessionTemplateId() {
            return this.mSessionTemplateId;
        }

        @Override // androidx.camera.extensions.internal.sessionprocessor.Camera2SessionConfig
        public int getSessionType() {
            return this.mSessionType;
        }
    }
}
