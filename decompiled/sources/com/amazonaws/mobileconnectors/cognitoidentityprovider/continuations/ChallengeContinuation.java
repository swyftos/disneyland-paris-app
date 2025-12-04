package com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations;

import android.content.Context;
import android.os.Handler;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeRequest;
import com.amazonaws.services.cognitoidentityprovider.model.RespondToAuthChallengeResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class ChallengeContinuation implements CognitoIdentityProviderContinuation<Map<String, String>> {
    public static final boolean RUN_IN_BACKGROUND = true;
    public static final boolean RUN_IN_CURRENT = false;
    private final AuthenticationHandler callback;
    private final RespondToAuthChallengeResult challengeResult;
    private final String clientId;
    private final Context context;
    private final boolean runInBackground;
    private final String secretHash;
    private final CognitoUser user;
    private final String username;
    protected final Map<String, String> challengeResponses = new HashMap();
    private final Map clientMetaData = new HashMap();

    public ChallengeContinuation(CognitoUser cognitoUser, Context context, String str, String str2, String str3, RespondToAuthChallengeResult respondToAuthChallengeResult, boolean z, AuthenticationHandler authenticationHandler) {
        this.challengeResult = respondToAuthChallengeResult;
        this.context = context;
        this.clientId = str2;
        this.secretHash = str3;
        this.user = cognitoUser;
        this.username = str;
        this.callback = authenticationHandler;
        this.runInBackground = z;
    }

    public Map<String, String> getClientMetaData() {
        return Collections.unmodifiableMap(this.clientMetaData);
    }

    public void setClientMetaData(Map<String, String> map) {
        this.clientMetaData.clear();
        if (map != null) {
            this.clientMetaData.putAll(map);
        }
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public Map<String, String> getParameters() {
        return this.challengeResult.getChallengeParameters();
    }

    public String getChallengeName() {
        return this.challengeResult.getChallengeName();
    }

    public void setChallengeResponse(String str, String str2) {
        this.challengeResponses.put(str, str2);
    }

    @Override // com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.CognitoIdentityProviderContinuation
    public void continueTask() {
        Runnable runnableRespondToChallenge;
        final RespondToAuthChallengeRequest respondToAuthChallengeRequest = new RespondToAuthChallengeRequest();
        this.challengeResponses.put("USERNAME", this.username);
        this.challengeResponses.put("SECRET_HASH", this.secretHash);
        respondToAuthChallengeRequest.setChallengeName(this.challengeResult.getChallengeName());
        respondToAuthChallengeRequest.setSession(this.challengeResult.getSession());
        respondToAuthChallengeRequest.setClientId(this.clientId);
        respondToAuthChallengeRequest.setChallengeResponses(this.challengeResponses);
        if (!this.clientMetaData.isEmpty()) {
            respondToAuthChallengeRequest.setClientMetadata(this.clientMetaData);
        }
        if (this.runInBackground) {
            new Thread(new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnableRespondToChallenge2;
                    Handler handler = new Handler(ChallengeContinuation.this.context.getMainLooper());
                    try {
                        runnableRespondToChallenge2 = ChallengeContinuation.this.user.respondToChallenge(ChallengeContinuation.this.clientMetaData, respondToAuthChallengeRequest, ChallengeContinuation.this.callback, true);
                    } catch (Exception e) {
                        runnableRespondToChallenge2 = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ChallengeContinuation.this.callback.onFailure(e);
                            }
                        };
                    }
                    handler.post(runnableRespondToChallenge2);
                }
            }).start();
            return;
        }
        try {
            runnableRespondToChallenge = this.user.respondToChallenge(this.clientMetaData, respondToAuthChallengeRequest, this.callback, false);
        } catch (Exception e) {
            runnableRespondToChallenge = new Runnable() { // from class: com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.ChallengeContinuation.2
                @Override // java.lang.Runnable
                public void run() {
                    ChallengeContinuation.this.callback.onFailure(e);
                }
            };
        }
        runnableRespondToChallenge.run();
    }

    public void setResponseSessionCode(String str) {
        this.challengeResult.setSession(str);
    }
}
