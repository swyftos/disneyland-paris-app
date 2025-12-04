package com.allegion.accesssdk.actions;

import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.accesssdk.models.AlPullRightsResponse;
import io.reactivex.Single;

/* loaded from: classes2.dex */
interface IAlRightsService {
    Single<AlPullPayloadsResponse> pullPayloads(AlImmutablePayloadsPullRequest alImmutablePayloadsPullRequest);

    Single<AlPullRightsResponse> pullRights(AlImmutableRightsPullRequest alImmutableRightsPullRequest);

    Single<AlPullPayloadsResponse> updatePayloads(AlImmutablePayloadsUpdateRequest alImmutablePayloadsUpdateRequest);
}
