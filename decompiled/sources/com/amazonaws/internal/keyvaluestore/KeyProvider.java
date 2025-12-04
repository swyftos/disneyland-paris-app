package com.amazonaws.internal.keyvaluestore;

import java.security.Key;

/* loaded from: classes2.dex */
interface KeyProvider {
    void deleteKey(String str);

    Key generateKey(String str);

    Key retrieveKey(String str);
}
