package com.brentvatne.exoplayer;

import androidx.media3.common.util.Util;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.drm.HttpMediaDrmCallback;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import com.brentvatne.common.api.DRMProps;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J$\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/brentvatne/exoplayer/DRMManager;", "Lcom/brentvatne/exoplayer/DRMManagerSpec;", "dataSourceFactory", "Landroidx/media3/datasource/HttpDataSource$Factory;", "<init>", "(Landroidx/media3/datasource/HttpDataSource$Factory;)V", "hasDrmFailed", "", "buildDrmSessionManager", "Landroidx/media3/exoplayer/drm/DrmSessionManager;", "uuid", "Ljava/util/UUID;", "drmProps", "Lcom/brentvatne/common/api/DRMProps;", "retryCount", "", "react-native-video_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DRMManager implements DRMManagerSpec {
    private final HttpDataSource.Factory dataSourceFactory;
    private boolean hasDrmFailed;

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExoMediaDrm buildDrmSessionManager$lambda$0(FrameworkMediaDrm frameworkMediaDrm, UUID it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return frameworkMediaDrm;
    }

    public DRMManager(@NotNull HttpDataSource.Factory dataSourceFactory) {
        Intrinsics.checkNotNullParameter(dataSourceFactory, "dataSourceFactory");
        this.dataSourceFactory = dataSourceFactory;
    }

    @Override // com.brentvatne.exoplayer.DRMManagerSpec
    @Nullable
    public DrmSessionManager buildDrmSessionManager(@NotNull UUID uuid, @NotNull DRMProps drmProps) throws UnsupportedDrmException {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        Intrinsics.checkNotNullParameter(drmProps, "drmProps");
        return buildDrmSessionManager(uuid, drmProps, 0);
    }

    private final DrmSessionManager buildDrmSessionManager(UUID uuid, DRMProps drmProps, int retryCount) throws UnsupportedDrmException {
        if (Util.SDK_INT < 18) {
            return null;
        }
        try {
            HttpMediaDrmCallback httpMediaDrmCallback = new HttpMediaDrmCallback(drmProps.getDrmLicenseServer(), this.dataSourceFactory);
            String[] drmLicenseHeader = drmProps.getDrmLicenseHeader();
            int i = 0;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, drmLicenseHeader.length - 1, 2);
            if (progressionLastElement >= 0) {
                while (true) {
                    httpMediaDrmCallback.setKeyRequestProperty(drmLicenseHeader[i], drmLicenseHeader[i + 1]);
                    if (i == progressionLastElement) {
                        break;
                    }
                    i += 2;
                }
            }
            final FrameworkMediaDrm frameworkMediaDrmNewInstance = FrameworkMediaDrm.newInstance(uuid);
            Intrinsics.checkNotNullExpressionValue(frameworkMediaDrmNewInstance, "newInstance(...)");
            if (this.hasDrmFailed) {
                frameworkMediaDrmNewInstance.setPropertyString("securityLevel", "L3");
            }
            return new DefaultDrmSessionManager.Builder().setUuidAndExoMediaDrmProvider(uuid, new ExoMediaDrm.Provider() { // from class: com.brentvatne.exoplayer.DRMManager$$ExternalSyntheticLambda0
                @Override // androidx.media3.exoplayer.drm.ExoMediaDrm.Provider
                public final ExoMediaDrm acquireExoMediaDrm(UUID uuid2) {
                    return DRMManager.buildDrmSessionManager$lambda$0(frameworkMediaDrmNewInstance, uuid2);
                }
            }).setKeyRequestParameters(null).setMultiSession(drmProps.getMultiDrm()).build(httpMediaDrmCallback);
        } catch (UnsupportedDrmException e) {
            this.hasDrmFailed = true;
            throw e;
        } catch (Exception e2) {
            if (retryCount < 3) {
                this.hasDrmFailed = true;
                return this.buildDrmSessionManager(uuid, drmProps, retryCount + 1);
            }
            throw new UnsupportedDrmException(1, e2);
        }
    }
}
