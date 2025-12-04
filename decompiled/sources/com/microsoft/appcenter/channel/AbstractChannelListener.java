package com.microsoft.appcenter.channel;

import androidx.annotation.NonNull;
import com.microsoft.appcenter.channel.Channel;
import com.microsoft.appcenter.ingestion.models.Log;

/* loaded from: classes4.dex */
public class AbstractChannelListener implements Channel.Listener {
    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onClear(@NonNull String str) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onGloballyEnabled(boolean z) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onGroupAdded(@NonNull String str, Channel.GroupListener groupListener, long j) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onGroupRemoved(@NonNull String str) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onPaused(@NonNull String str, String str2) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onPreparedLog(@NonNull Log log, @NonNull String str, int i) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onPreparingLog(@NonNull Log log, @NonNull String str) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public void onResumed(@NonNull String str, String str2) {
    }

    @Override // com.microsoft.appcenter.channel.Channel.Listener
    public boolean shouldFilter(@NonNull Log log) {
        return false;
    }
}
