package com.google.protobuf;

import com.google.protobuf.ArrayDecoders;

/* loaded from: classes4.dex */
interface Schema {
    boolean equals(Object obj, Object obj2);

    int getSerializedSize(Object obj);

    int hashCode(Object obj);

    boolean isInitialized(Object obj);

    void makeImmutable(Object obj);

    void mergeFrom(Object obj, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(Object obj, Object obj2);

    void mergeFrom(Object obj, byte[] bArr, int i, int i2, ArrayDecoders.Registers registers);

    Object newInstance();

    void writeTo(Object obj, Writer writer);
}
