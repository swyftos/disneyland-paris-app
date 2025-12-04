package com.allegion.core.enums;

import com.google.common.base.Ascii;
import com.tagcommander.lib.serverside.schemas.TCEventPropertiesNames;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b1\b\u0086\u0001\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00000\u0001:\u00013B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0003J\u0006\u0010\f\u001a\u00020\u0003J\b\u0010\r\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2¨\u00064"}, d2 = {"Lcom/allegion/core/enums/AlBLEDeviceType;", "", "deviceType", "", "productName", TCEventPropertiesNames.TCD_MODEL, "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDeviceType", "()Ljava/lang/String;", "getModel", "getProductName", "toModel", "toProductName", "toString", "SWORDFISH", "JAGUAR", "KRILL", "TRIDENT", "GATEWAY", "OEM", "MARLIN", "LEOPARD", "DENALI", "ARGOS", "BARRACUDA", "WIFI", "GHI_TRILOCK", "GHI_GATEWAY", "TOPAZ", "CO110", "SWITCHBACK", "E_SIGNO_LOCK", "E_SIGNO_READER", "JACKALOPE", "ENCODE_LEVER", "E_SIGNO_LOCK_OUTDOOR", "E_SIGNO_READER_OUTDOOR", "E_SIGNO_READER_PLASTIC", "UWE", "ZION", "GHI_JACKALOPE", "GHI_JACKALOPE_LEVER", "GHI_WIFI_TRILOCK", "INTERFLEX_READER", "INTERFLEX_LOCK", "WIFI_KEYPAD_DEADBOLT", "E_SIGNO_SMARTLOCKER", "E_SIGNO_ECYLINDER", "E_SIGNO_SMARTHANDLE", "CISA_RESERVED", "UNKNOWN", "Companion", "AlBle_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public enum AlBLEDeviceType {
    SWORDFISH("NDE", "NDE", "NDE"),
    JAGUAR("Jaguar", "Control Lock", "BE467/FE410"),
    KRILL("Krill", "MT20W", "MT20W"),
    TRIDENT("ADE", "ADE", "ADE"),
    GATEWAY("Gateway", "Gateway", "GWE"),
    OEM("OEM Product", "OEM Product", "OEM"),
    MARLIN("LE", "LE", "LEMB/LEMS/LEMD"),
    LEOPARD("Sense", "Sense", ""),
    DENALI("Encode", "Encode", ""),
    ARGOS("Argos", "Exit Device", "RM/RU"),
    BARRACUDA("CTE", "CTE", "CTE"),
    WIFI("Connected Home Module", "Connected Home Module", ""),
    GHI_TRILOCK("Trilock", "Trilock", "Trilock"),
    GHI_GATEWAY("Gateway (GHI)", "Gateway (GHI)", "GHI GWE"),
    TOPAZ("Topaz", "BLE Wall Mount Reader", "MTB"),
    CO110("CO110 Lock", "CO110 Lock", "CO110"),
    SWITCHBACK("RC05", "Reader-Controller", "RC05"),
    E_SIGNO_LOCK("CISA eSigno Lock", "CISA eSigno Lock", "eSigno Lock"),
    E_SIGNO_READER("CISA Wall Reader", "CISA Wall Reader", "Glass Indoor Design Range (A0RC2)"),
    JACKALOPE("Encode Plus", "Encode Plus", "be499"),
    ENCODE_LEVER("Encode Lever", "Encode Lever", "fe789"),
    E_SIGNO_LOCK_OUTDOOR("CISA eSigno Lock", "CISA eSigno Lock", "eSigno Lock Outdoor"),
    E_SIGNO_READER_OUTDOOR("CISA Wall Reader", "CISA Wall Reader", "Glass Outdoor Design Range"),
    E_SIGNO_READER_PLASTIC("CISA Wall Reader", "CISA Wall Reader", "Plastic Outdoor Design Range"),
    UWE("XE360", "XE360", "XE360I/XE360B/XE360D"),
    ZION("ZION", "ZION", ""),
    GHI_JACKALOPE("Encode Plus (GHI)", "Encode Plus (GHI)", ""),
    GHI_JACKALOPE_LEVER("Encode Plus Lever (GHI)", "Encode Plus Lever (GHI)", ""),
    GHI_WIFI_TRILOCK("Wi-Fi Trilock", "Wi-Fi Trilock", ""),
    INTERFLEX_READER("Interflex mains-powered Device", "Interflex mains-powered Device", "Opendor Reader"),
    INTERFLEX_LOCK("Interflex battery-powered Device", "Interflex battery-powered Device", "Opendor Lock"),
    WIFI_KEYPAD_DEADBOLT("Wi-Fi Keypad Deadbolt", "Wi-Fi Keypad Deadbolt", "be459"),
    E_SIGNO_SMARTLOCKER("CISA SmartLocker", "CISA SmartLocker", "SmartLocker"),
    E_SIGNO_ECYLINDER("CISA eCylinder", "CISA eCylinder", "eCylinder"),
    E_SIGNO_SMARTHANDLE("CISA SmartHandle", "CISA SmartHandle", "SmartHandle"),
    CISA_RESERVED("CISA Undefined", "CISA Undefined", "Undefined"),
    UNKNOWN("Unknown", "Unknown", "");


    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private final String deviceType;

    @NotNull
    private final String model;

    @NotNull
    private final String productName;

    @JvmStatic
    @NotNull
    public static final AlBLEDeviceType fromByteArray(@NotNull byte[] bArr) {
        return INSTANCE.fromByteArray(bArr);
    }

    @JvmStatic
    @Nullable
    public static final AlBLEDeviceType fromString(@NotNull String str) {
        return INSTANCE.fromString(str);
    }

    AlBLEDeviceType(String str, String str2, String str3) {
        this.deviceType = str;
        this.productName = str2;
        this.model = str3;
    }

    @NotNull
    public final String getDeviceType() {
        return this.deviceType;
    }

    @NotNull
    public final String getModel() {
        return this.model;
    }

    @NotNull
    public final String getProductName() {
        return this.productName;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.deviceType;
    }

    @NotNull
    public final String toModel() {
        return this.model;
    }

    @NotNull
    public final String toProductName() {
        return this.productName;
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Lcom/allegion/core/enums/AlBLEDeviceType$Companion;", "", "()V", "fromByteArray", "Lcom/allegion/core/enums/AlBLEDeviceType;", "value", "", "fromString", "", "AlBle_release"}, k = 1, mv = {1, 1, 15})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final AlBLEDeviceType fromByteArray(@NotNull byte[] value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            if (Arrays.equals(value, new byte[]{0, 1}) || Arrays.equals(value, new byte[]{0, Ascii.DLE})) {
                return AlBLEDeviceType.SWORDFISH;
            }
            if (Arrays.equals(value, new byte[]{0, 2}) || Arrays.equals(value, new byte[]{0, 17})) {
                return AlBLEDeviceType.JAGUAR;
            }
            if (Arrays.equals(value, new byte[]{0, 3})) {
                return AlBLEDeviceType.KRILL;
            }
            if (Arrays.equals(value, new byte[]{0, 4})) {
                return AlBLEDeviceType.TRIDENT;
            }
            if (Arrays.equals(value, new byte[]{0, 5})) {
                return AlBLEDeviceType.GATEWAY;
            }
            if (Arrays.equals(value, new byte[]{0, 6})) {
                return AlBLEDeviceType.OEM;
            }
            if (Arrays.equals(value, new byte[]{0, 7}) || Arrays.equals(value, new byte[]{0, Ascii.DC2})) {
                return AlBLEDeviceType.MARLIN;
            }
            if (Arrays.equals(value, new byte[]{0, 8})) {
                return AlBLEDeviceType.LEOPARD;
            }
            if (Arrays.equals(value, new byte[]{0, 9})) {
                return AlBLEDeviceType.DENALI;
            }
            if (Arrays.equals(value, new byte[]{0, 10})) {
                return AlBLEDeviceType.ARGOS;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.VT})) {
                return AlBLEDeviceType.BARRACUDA;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.FF})) {
                return AlBLEDeviceType.WIFI;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.CR})) {
                return AlBLEDeviceType.GHI_TRILOCK;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.SO})) {
                return AlBLEDeviceType.GHI_GATEWAY;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.SI})) {
                return AlBLEDeviceType.TOPAZ;
            }
            if (Arrays.equals(value, new byte[]{0, 19})) {
                return AlBLEDeviceType.CO110;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.DC4})) {
                return AlBLEDeviceType.SWITCHBACK;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.NAK})) {
                return AlBLEDeviceType.E_SIGNO_LOCK;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.SYN})) {
                return AlBLEDeviceType.E_SIGNO_READER;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.ETB})) {
                return AlBLEDeviceType.JACKALOPE;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.CAN})) {
                return AlBLEDeviceType.ENCODE_LEVER;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.EM})) {
                return AlBLEDeviceType.E_SIGNO_LOCK_OUTDOOR;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.SUB})) {
                return AlBLEDeviceType.E_SIGNO_SMARTLOCKER;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.ESC})) {
                return AlBLEDeviceType.E_SIGNO_ECYLINDER;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.FS})) {
                return AlBLEDeviceType.E_SIGNO_SMARTHANDLE;
            }
            if (Arrays.equals(value, new byte[]{0, Ascii.GS}) || Arrays.equals(value, new byte[]{0, Ascii.RS}) || Arrays.equals(value, new byte[]{0, Ascii.US})) {
                return AlBLEDeviceType.CISA_RESERVED;
            }
            return Arrays.equals(value, new byte[]{0, 32}) ? AlBLEDeviceType.E_SIGNO_READER_OUTDOOR : Arrays.equals(value, new byte[]{0, 33}) ? AlBLEDeviceType.E_SIGNO_READER_PLASTIC : Arrays.equals(value, new byte[]{0, 34}) ? AlBLEDeviceType.UWE : Arrays.equals(value, new byte[]{0, 35}) ? AlBLEDeviceType.ZION : Arrays.equals(value, new byte[]{0, 36}) ? AlBLEDeviceType.GHI_JACKALOPE : Arrays.equals(value, new byte[]{0, 37}) ? AlBLEDeviceType.GHI_JACKALOPE_LEVER : Arrays.equals(value, new byte[]{0, 38}) ? AlBLEDeviceType.GHI_WIFI_TRILOCK : Arrays.equals(value, new byte[]{0, 39}) ? AlBLEDeviceType.INTERFLEX_READER : Arrays.equals(value, new byte[]{0, 40}) ? AlBLEDeviceType.INTERFLEX_LOCK : Arrays.equals(value, new byte[]{0, 41}) ? AlBLEDeviceType.WIFI_KEYPAD_DEADBOLT : AlBLEDeviceType.UNKNOWN;
        }

        @JvmStatic
        @Nullable
        public final AlBLEDeviceType fromString(@NotNull String value) {
            Intrinsics.checkParameterIsNotNull(value, "value");
            for (AlBLEDeviceType alBLEDeviceType : AlBLEDeviceType.values()) {
                String deviceType = alBLEDeviceType.getDeviceType();
                if (deviceType == null) {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                if (deviceType.contentEquals(value)) {
                    return alBLEDeviceType;
                }
            }
            return null;
        }
    }
}
