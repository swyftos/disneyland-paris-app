package com.google.protobuf;

import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public interface FieldMaskOrBuilder extends MessageLiteOrBuilder {
    String getPaths(int i);

    ByteString getPathsBytes(int i);

    int getPathsCount();

    List<String> getPathsList();
}
