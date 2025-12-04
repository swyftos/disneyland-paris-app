package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.internal.crypto.CipherFactory;
import java.io.FilterInputStream;
import java.io.InputStream;
import javax.crypto.CipherInputStream;

/* loaded from: classes2.dex */
public class RepeatableCipherInputStream extends AbstractRepeatableCipherInputStream<CipherFactory> {
    public RepeatableCipherInputStream(InputStream inputStream, CipherFactory cipherFactory) {
        super(inputStream, newCipherInputStream(inputStream, cipherFactory), cipherFactory);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amazonaws.services.s3.internal.AbstractRepeatableCipherInputStream
    public FilterInputStream createCipherInputStream(InputStream inputStream, CipherFactory cipherFactory) {
        return newCipherInputStream(inputStream, cipherFactory);
    }

    private static FilterInputStream newCipherInputStream(InputStream inputStream, CipherFactory cipherFactory) {
        return new CipherInputStream(inputStream, cipherFactory.createCipher());
    }
}
