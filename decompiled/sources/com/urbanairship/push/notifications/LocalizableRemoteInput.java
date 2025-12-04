package com.urbanairship.push.notifications;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.core.app.RemoteInput;

/* loaded from: classes5.dex */
public class LocalizableRemoteInput {
    private final boolean allowFreeFormInput;
    private final int[] choices;
    private final int choicesArray;
    private final Bundle extras;
    private final int labelId;
    private final String resultKey;

    private LocalizableRemoteInput(Builder builder) {
        this.resultKey = builder.resultKey;
        this.labelId = builder.labelId;
        this.choices = builder.choices;
        this.allowFreeFormInput = builder.allowFreeFormInput;
        this.extras = builder.extras;
        this.choicesArray = builder.choicesArray;
    }

    @NonNull
    public String getResultKey() {
        return this.resultKey;
    }

    public int getLabel() {
        return this.labelId;
    }

    @Nullable
    public int[] getChoices() {
        return this.choices;
    }

    public boolean getAllowFreeFormInput() {
        return this.allowFreeFormInput;
    }

    @NonNull
    public Bundle getExtras() {
        return this.extras;
    }

    @NonNull
    public RemoteInput createRemoteInput(@NonNull Context context) {
        RemoteInput.Builder builderAddExtras = new RemoteInput.Builder(this.resultKey).setAllowFreeFormInput(this.allowFreeFormInput).addExtras(this.extras);
        int[] iArr = this.choices;
        if (iArr != null) {
            CharSequence[] charSequenceArr = new CharSequence[iArr.length];
            int i = 0;
            while (true) {
                int[] iArr2 = this.choices;
                if (i >= iArr2.length) {
                    break;
                }
                charSequenceArr[i] = context.getText(iArr2[i]);
                i++;
            }
            builderAddExtras.setChoices(charSequenceArr);
        }
        if (this.choicesArray != 0) {
            builderAddExtras.setChoices(context.getResources().getStringArray(this.choicesArray));
        }
        int i2 = this.labelId;
        if (i2 != 0) {
            builderAddExtras.setLabel(context.getText(i2));
        }
        return builderAddExtras.build();
    }

    public static final class Builder {
        private int[] choices;
        private int choicesArray;
        private int labelId;
        private final String resultKey;
        private final Bundle extras = new Bundle();
        private boolean allowFreeFormInput = false;

        public Builder(@NonNull String str) {
            this.resultKey = str;
        }

        @NonNull
        public Builder setLabel(@StringRes int i) {
            this.labelId = i;
            return this;
        }

        @NonNull
        public Builder setChoices(@ArrayRes int i) {
            this.choices = null;
            this.choicesArray = i;
            return this;
        }

        @NonNull
        public Builder setAllowFreeFormInput(boolean z) {
            this.allowFreeFormInput = z;
            return this;
        }

        @NonNull
        public Builder addExtras(@Nullable Bundle bundle) {
            if (bundle != null) {
                this.extras.putAll(bundle);
            }
            return this;
        }

        @NonNull
        public LocalizableRemoteInput build() {
            return new LocalizableRemoteInput(this);
        }
    }
}
