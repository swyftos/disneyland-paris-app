package com.allegion.core.operations.gatt;

import com.allegion.logging.AlLog;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes2.dex */
public class GattLookup {
    private static GattLookup gattLookup;
    private UUID[] serviceUUIDs;
    private Map<String, UUID> uuids = new HashMap();
    private Map<String, UUID> characteristicToService = new HashMap();

    public static GattLookup getInstance(InputStream inputStream) throws IOException {
        GattLookup gattLookup2 = new GattLookup();
        gattLookup = gattLookup2;
        gattLookup2.init(inputStream);
        return gattLookup;
    }

    protected GattLookup() {
    }

    public void init(InputStream inputStream) throws IOException {
        DeviceGATT deviceGATT;
        Gson gson = new Gson();
        Type type = new TypeToken<DeviceGATT>() { // from class: com.allegion.core.operations.gatt.GattLookup.1
        }.getType();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                } else {
                    sb.append(line);
                }
            } catch (IOException e) {
                AlLog.e(e);
            }
        }
        try {
            deviceGATT = (DeviceGATT) gson.fromJson(sb.toString(), type);
        } catch (JsonSyntaxException e2) {
            AlLog.e(e2);
            deviceGATT = null;
        }
        if (deviceGATT == null || deviceGATT.getServices() == null) {
            return;
        }
        this.serviceUUIDs = new UUID[deviceGATT.getServices().length];
        for (int i = 0; i < deviceGATT.getServices().length; i++) {
            String name = deviceGATT.getServices()[i].getName();
            UUID uuidFromString = UUID.fromString(deviceGATT.getServices()[i].getUuid());
            this.serviceUUIDs[i] = UUID.fromString(deviceGATT.getServices()[i].getUuid());
            this.uuids.put(name, uuidFromString);
            this.characteristicToService.put(name, uuidFromString);
            for (DeviceCharacteristic deviceCharacteristic : deviceGATT.getServices()[i].getCharacteristic()) {
                try {
                    this.uuids.put(deviceCharacteristic.getName(), UUID.fromString(deviceCharacteristic.getUuid()));
                } catch (IllegalArgumentException e3) {
                    AlLog.e("Invalid argument in either characteristic name or uuid", e3);
                    String strReplace = deviceCharacteristic.getUuid().replace("-", "");
                    this.uuids.put(deviceCharacteristic.getName(), new UUID(new BigInteger(strReplace.substring(0, 16), 16).longValue(), new BigInteger(strReplace.substring(16), 16).longValue()));
                }
                this.characteristicToService.put(deviceCharacteristic.getName(), uuidFromString);
            }
        }
    }

    public UUID getServiceUUID(String str) {
        if (this.characteristicToService.containsKey(str)) {
            return this.characteristicToService.get(str);
        }
        return null;
    }

    public UUID getUUID(String str) {
        if (this.uuids.containsKey(str)) {
            return this.uuids.get(str);
        }
        return null;
    }
}
