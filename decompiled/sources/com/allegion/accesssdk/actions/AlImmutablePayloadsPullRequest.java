package com.allegion.accesssdk.actions;

import com.allegion.accesshub.models.AccessPayloadsMAHWebRequest;
import com.allegion.accesssdk.exceptions.AlObjects;
import com.allegion.accesssdk.exceptions.AlPublicKeyExportException;
import com.allegion.accesssdk.exceptions.AlRuntimeException;
import com.allegion.accesssdk.models.AlPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsRequest;
import com.allegion.accesssdk.models.AlPullPayloadsResponse;
import com.allegion.altranslation.AlUUIDUtilityKt;
import com.amazonaws.cognito.clientcontext.datacollection.DataRecordKey;
import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nonnull;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.util.encoders.Hex;

/* loaded from: classes2.dex */
final class AlImmutablePayloadsPullRequest extends AccessPayloadsMAHWebRequest implements IAlImmutableRequestCacheable<AlPullPayloadsResponse> {
    private final UUID accountId;
    private final UUID deviceId;
    private final boolean ignoreCache;
    private final UUID rightId;

    public AlImmutablePayloadsPullRequest(AlPullPayloadsRequest alPullPayloadsRequest, UUID uuid, UUID uuid2) {
        super((String) AlObjects.requireNonNull(alPullPayloadsRequest.getAccessToken(), "Access token must not be null"), buildRequests(alPullPayloadsRequest.getRightId(), uuid, alPullPayloadsRequest.getPayloadRequests()));
        this.accountId = (UUID) AlObjects.requireNonNull(uuid2, "Account Id must not be null");
        this.deviceId = (UUID) AlObjects.requireNonNull(uuid, "Device Id must not be null");
        this.rightId = (UUID) AlObjects.requireNonNull(alPullPayloadsRequest.getRightId(), "Right id must not be null");
        this.ignoreCache = alPullPayloadsRequest.getShouldIgnoreCache();
    }

    private static AlImmutablePayloadsRequest[] buildRequests(UUID uuid, UUID uuid2, List<AlPayloadsRequest> list) {
        int size = list.size();
        AlImmutablePayloadsRequest[] alImmutablePayloadsRequestArr = new AlImmutablePayloadsRequest[size];
        for (int i = 0; i < size; i++) {
            AlPayloadsRequest alPayloadsRequest = list.get(i);
            String string = uuid.toString();
            IAlStorageService iAlStorageService = (IAlStorageService) AlSdkConfiguration.getServiceProvider().locateService(IAlStorageService.class);
            String str = (StringUtils.isNotBlank(string) && iAlStorageService.contains(string)) ? (String) iAlStorageService.retrieve(string, String.class) : null;
            try {
                alPayloadsRequest.addPayloadArgs("MobileDevicePublicKey", Hex.toHexString(AlSdkConfiguration.getConfig().exportEccDevicePublicKeyUncompressed()));
                alPayloadsRequest.addPayloadArgs(DataRecordKey.DEVICE_AGENT, Hex.toHexString(AlUUIDUtilityKt.toByteArray(uuid2)));
                if (str != null) {
                    alPayloadsRequest.addPayloadArgs("LastDownloadedTimestamp", str);
                }
                alImmutablePayloadsRequestArr[i] = new AlImmutablePayloadsRequest(alPayloadsRequest);
            } catch (AlPublicKeyExportException e) {
                throw new AlRuntimeException(e);
            }
        }
        return alImmutablePayloadsRequestArr;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AlImmutablePayloadsPullRequest)) {
            return false;
        }
        AlImmutablePayloadsPullRequest alImmutablePayloadsPullRequest = (AlImmutablePayloadsPullRequest) obj;
        return this.rightId.equals(alImmutablePayloadsPullRequest.rightId) && this.deviceId.equals(alImmutablePayloadsPullRequest.deviceId) && this.accountId.equals(alImmutablePayloadsPullRequest.accountId) && getAccessToken().equals(alImmutablePayloadsPullRequest.getAccessToken()) && Arrays.equals(getPayloadRequests(), alImmutablePayloadsPullRequest.getPayloadRequests());
    }

    public UUID getAccountId() {
        return this.accountId;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public String getCacheKey() {
        return "access.payloads." + this.accountId + InstructionFileId.DOT + this.rightId + InstructionFileId.DOT + this.deviceId;
    }

    @Override // com.allegion.accesssdk.interfaces.IAlRequestCacheable
    /* renamed from: getIgnoreCache */
    public boolean getShouldIgnoreCache() {
        return this.ignoreCache;
    }

    @Override // com.allegion.accesssdk.actions.IAlImmutableRequestCacheable
    public Class<AlPullPayloadsResponse> getResponseType() {
        return AlPullPayloadsResponse.class;
    }

    public UUID getRightId() {
        return this.rightId;
    }

    public int hashCode() {
        return Arrays.hashCode(getPayloadRequests()) ^ (((this.rightId.hashCode() ^ this.deviceId.hashCode()) ^ this.accountId.hashCode()) ^ getAccessToken().hashCode());
    }

    @Nonnull
    public String toString() {
        return "AlPayloadsPullRequest {" + this.deviceId + ",  " + this.accountId + ",  " + this.rightId + ",  " + getAccessToken() + ",  " + Arrays.toString(getPayloadRequests()) + ",  " + this.ignoreCache + "}";
    }
}
