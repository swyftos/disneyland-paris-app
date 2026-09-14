package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
@UnstableApi
public interface MediaDrmCallback {
    byte[] executeKeyRequest(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException;

    byte[] executeProvisionRequest(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException;
}
