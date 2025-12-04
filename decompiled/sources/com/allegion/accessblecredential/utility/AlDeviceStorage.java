package com.allegion.accessblecredential.utility;

import com.allegion.alsecurity.exceptions.AlSecurityException;
import com.allegion.alsecurity.interfaces.IAlSecureStorage;
import com.allegion.altranslation.AlJson;
import com.allegion.altranslation.utility.AlTranslationComponentException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b \u0010!J?\u0010\u0007\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00050\u0004j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0005`\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\n\u001a\u00020\u0002*\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J%\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00052\u0006\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00028\u0000@\u0000X\u0080D¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/allegion/accessblecredential/utility/AlDeviceStorage;", "", "", "value", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "deviceListFromString", "(Ljava/lang/String;)Ljava/util/ArrayList;", "", "toHexString", "([B)Ljava/lang/String;", "serialNumber", "pinValue", "", "storeDevicePin", "(Ljava/lang/String;[B)Z", "retrieveDeviceBySerial", "(Ljava/lang/String;)Lkotlin/Pair;", "devicePin", "retrieveDeviceByPin", "([B)Lkotlin/Pair;", "", "clearAllDevicePins", "()V", "DEVICE_STORAGE_REF", "Ljava/lang/String;", "getDEVICE_STORAGE_REF$AccessBleCredential_release", "()Ljava/lang/String;", "Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "storage", "Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;", "<init>", "(Lcom/allegion/alsecurity/interfaces/IAlSecureStorage;)V", "AccessBleCredential_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class AlDeviceStorage {

    @NotNull
    private final String DEVICE_STORAGE_REF;
    private final IAlSecureStorage storage;

    public AlDeviceStorage(@NotNull IAlSecureStorage storage) {
        Intrinsics.checkParameterIsNotNull(storage, "storage");
        this.storage = storage;
        this.DEVICE_STORAGE_REF = "devicePins";
    }

    private final ArrayList<Pair<String, String>> deviceListFromString(String value) throws AlTranslationComponentException {
        if (value.length() == 0) {
            return new ArrayList<>();
        }
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        try {
            ArrayList<LinkedHashMap> arrayList2 = (ArrayList) new ObjectMapper().readValue(value, ArrayList.class);
            if (arrayList2 != null) {
                for (LinkedHashMap linkedHashMap : arrayList2) {
                    Collection collectionValues = linkedHashMap.values();
                    Intrinsics.checkExpressionValueIsNotNull(collectionValues, "it.values");
                    Object objFirst = CollectionsKt.first(collectionValues);
                    Collection collectionValues2 = linkedHashMap.values();
                    Intrinsics.checkExpressionValueIsNotNull(collectionValues2, "it.values");
                    arrayList.add(new Pair<>(objFirst, CollectionsKt.last(collectionValues2)));
                }
            }
            return arrayList;
        } catch (IOException e) {
            throw new AlTranslationComponentException(AlJson.EXCEPTION_JSON_PARSING, e);
        }
    }

    private final String toHexString(@NotNull byte[] bArr) {
        return ArraysKt.joinToString$default(bArr, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new Function1<Byte, String>() { // from class: com.allegion.accessblecredential.utility.AlDeviceStorage.toHexString.1
            @Override // kotlin.jvm.functions.Function1
            public String invoke(Byte b) {
                String str = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b.byteValue())}, 1));
                Intrinsics.checkExpressionValueIsNotNull(str, "java.lang.String.format(this, *args)");
                return str;
            }
        }, 30, (Object) null);
    }

    public final void clearAllDevicePins() {
        this.storage.remove(this.DEVICE_STORAGE_REF);
    }

    @NotNull
    /* renamed from: getDEVICE_STORAGE_REF$AccessBleCredential_release, reason: from getter */
    public final String getDEVICE_STORAGE_REF() {
        return this.DEVICE_STORAGE_REF;
    }

    @Nullable
    public final Pair<String, String> retrieveDeviceByPin(@NotNull byte[] devicePin) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(devicePin, "devicePin");
        if (!this.storage.contains(this.DEVICE_STORAGE_REF)) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayListDeviceListFromString = deviceListFromString(this.storage.retrieve(this.DEVICE_STORAGE_REF));
        if (arrayListDeviceListFromString.isEmpty()) {
            return null;
        }
        Iterator<Pair<String, String>> it = arrayListDeviceListFromString.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (Intrinsics.areEqual(next.getSecond(), toHexString(devicePin))) {
                return next;
            }
        }
        return null;
    }

    @Nullable
    public final Pair<String, String> retrieveDeviceBySerial(@NotNull String serialNumber) throws AlTranslationComponentException {
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        if (!this.storage.contains(this.DEVICE_STORAGE_REF)) {
            return null;
        }
        ArrayList<Pair<String, String>> arrayListDeviceListFromString = deviceListFromString(this.storage.retrieve(this.DEVICE_STORAGE_REF));
        if (arrayListDeviceListFromString.isEmpty()) {
            return null;
        }
        Iterator<Pair<String, String>> it = arrayListDeviceListFromString.iterator();
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (Intrinsics.areEqual(next.getFirst(), serialNumber)) {
                return next;
            }
        }
        return null;
    }

    public final boolean storeDevicePin(@NotNull String serialNumber, @NotNull byte[] pinValue) throws AlTranslationComponentException, AlSecurityException {
        Intrinsics.checkParameterIsNotNull(serialNumber, "serialNumber");
        Intrinsics.checkParameterIsNotNull(pinValue, "pinValue");
        ArrayList<Pair<String, String>> arrayListDeviceListFromString = deviceListFromString(this.storage.contains(this.DEVICE_STORAGE_REF) ? this.storage.retrieve(this.DEVICE_STORAGE_REF) : "");
        if (arrayListDeviceListFromString.size() >= 20) {
            arrayListDeviceListFromString.remove(CollectionsKt.first((List) arrayListDeviceListFromString));
        }
        arrayListDeviceListFromString.add(new Pair<>(serialNumber, toHexString(pinValue)));
        this.storage.store(this.DEVICE_STORAGE_REF, AlJson.toJson(arrayListDeviceListFromString));
        return true;
    }
}
