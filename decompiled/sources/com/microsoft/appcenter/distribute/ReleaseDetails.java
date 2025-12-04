package com.microsoft.appcenter.distribute;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class ReleaseDetails {
    @NonNull
    public Uri getDownloadUrl() {
        return null;
    }

    public int getId() {
        return 1;
    }

    @Nullable
    public Uri getReleaseNotesUrl() {
        return null;
    }

    public long getSize() {
        return 0L;
    }

    public int getVersion() {
        return 1;
    }

    public boolean isMandatoryUpdate() {
        return false;
    }

    @NonNull
    public String getShortVersion() {
        return "shortVersion";
    }

    @Nullable
    public String getReleaseNotes() {
        return "releaseNotes";
    }

    @NonNull
    public String getReleaseHash() {
        return "releaseHash";
    }

    public String getDistributionGroupId() {
        return "distributionGroupId";
    }
}
