package com.allegion.core.scanning;

import android.util.Log;
import com.allegion.core.operations.support.HexConverter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

/* loaded from: classes2.dex */
public class AdvertisementParser {
    public static final String LOG_TAG = "AdvertisementParser";

    private AdvertisementParser() {
        throw new IllegalStateException("Utility class cannot be instantiated");
    }

    public static Advertisement parseUUIDs(byte[] bArr) {
        Log.d(LOG_TAG, "Advertisement Data: " + HexConverter.bytesToString(bArr));
        Advertisement advertisement = new Advertisement();
        int i = 0;
        while (i < bArr.length - 2) {
            int i2 = i + 1;
            int i3 = bArr[i];
            if (i3 == 0) {
                break;
            }
            int i4 = i + 2;
            int i5 = bArr[i2];
            String str = LOG_TAG;
            Log.d(str, "Type: " + i5);
            if (i5 == -1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Company Info: ");
                int i6 = (i4 + i3) - 1;
                sb.append(HexConverter.bytesToString(Arrays.copyOfRange(bArr, i4, i6)));
                Log.d(str, sb.toString());
                advertisement.setCompanyData(Arrays.copyOfRange(bArr, i4, i6));
            } else if (i5 == 9) {
                String str2 = new String(Arrays.copyOfRange(bArr, i4, (i4 + i3) - 1), StandardCharsets.UTF_8);
                Log.d(str, "Name: " + str2);
                advertisement.setName(str2);
            } else if (i5 == 16) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Serial Number: ");
                int i7 = (i4 + i3) - 1;
                sb2.append(HexConverter.bytesToString(Arrays.copyOfRange(bArr, i4, i7)));
                Log.d(str, sb2.toString());
                advertisement.setSerialNumber(Arrays.copyOfRange(bArr, i4, i7));
            } else if (i5 != 22) {
                if (i5 == 2 || i5 == 3) {
                    while (i3 > 1) {
                        int i8 = i4 + 1;
                        int i9 = bArr[i4];
                        i4 += 2;
                        i3 -= 2;
                        advertisement.addUUID(UUID.fromString(String.format("%08x-0000-1000-8000-00805f9b34fb", Integer.valueOf(i9 + (bArr[i8] << 8)))));
                    }
                } else if (i5 == 6 || i5 == 7) {
                    while (i3 >= 16) {
                        try {
                            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr, i4, 16).order(ByteOrder.LITTLE_ENDIAN);
                            advertisement.addUUID(new UUID(byteBufferOrder.getLong(), byteBufferOrder.getLong()));
                        } catch (IndexOutOfBoundsException e) {
                            Log.e(LOG_TAG, "Advertisement buffer overrun " + e.toString(), e);
                        }
                        i4 += 16;
                        i3 -= 16;
                    }
                }
                i = i4;
            } else {
                int i10 = i + 4;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Serial Number: ");
                int i11 = ((i3 - 2) + i10) - 1;
                sb3.append(HexConverter.bytesToString(Arrays.copyOfRange(bArr, i10, i11)));
                Log.d(str, sb3.toString());
                advertisement.setSerialNumber(Arrays.copyOfRange(bArr, i10, i11));
                i = i10 + (i3 - 3);
            }
            i4 += i3 - 1;
            i = i4;
        }
        return advertisement;
    }
}
