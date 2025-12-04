package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
interface Reader {
    int getFieldNumber();

    int getTag();

    void mergeGroupField(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    void mergeMessageField(Object obj, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    boolean readBool();

    void readBoolList(List list);

    ByteString readBytes();

    void readBytesList(List list);

    double readDouble();

    void readDoubleList(List list);

    int readEnum();

    void readEnumList(List list);

    int readFixed32();

    void readFixed32List(List list);

    long readFixed64();

    void readFixed64List(List list);

    float readFloat();

    void readFloatList(List list);

    Object readGroup(Class cls, ExtensionRegistryLite extensionRegistryLite);

    void readGroupList(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    int readInt32();

    void readInt32List(List list);

    long readInt64();

    void readInt64List(List list);

    void readMap(Map map, MapEntryLite.Metadata metadata, ExtensionRegistryLite extensionRegistryLite);

    Object readMessage(Class cls, ExtensionRegistryLite extensionRegistryLite);

    void readMessageList(List list, Schema schema, ExtensionRegistryLite extensionRegistryLite);

    int readSFixed32();

    void readSFixed32List(List list);

    long readSFixed64();

    void readSFixed64List(List list);

    int readSInt32();

    void readSInt32List(List list);

    long readSInt64();

    void readSInt64List(List list);

    String readString();

    void readStringList(List list);

    void readStringListRequireUtf8(List list);

    String readStringRequireUtf8();

    int readUInt32();

    void readUInt32List(List list);

    long readUInt64();

    void readUInt64List(List list);

    boolean skipField();
}
