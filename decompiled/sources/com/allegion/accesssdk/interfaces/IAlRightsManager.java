package com.allegion.accesssdk.interfaces;

import com.allegion.accesssdk.listeners.IAlListener;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsRequest;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public interface IAlRightsManager {
    void pullAccessPayloads(AlPullPayloadsRequest alPullPayloadsRequest);

    void pullAccessRights(AlPullRightsRequest alPullRightsRequest);

    void setPullAccessPayloadsListener(@Nullable IAlListener.Success<AlPullPayloadsResponse> success, @Nullable IAlListener.Error<Throwable> error);

    void setPullAccessPayloadsListener(@Nullable IAlListener<AlPullPayloadsResponse> iAlListener);

    void setPullAccessRightsListener(@Nullable IAlListener.Success<AlPullRightsResponse> success, @Nullable IAlListener.Error<Throwable> error);

    void setPullAccessRightsListener(@Nullable IAlListener<AlPullRightsResponse> iAlListener);
}
