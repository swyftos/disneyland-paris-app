package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* loaded from: classes3.dex */
public class zzfw extends IOException {
    private zzgw zza;

    public zzfw(String str) {
        super(str);
        this.zza = null;
    }

    static zzfw zza() {
        return new zzfw("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzfw zzb() {
        return new zzfw("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzfw zzc() {
        return new zzfw("CodedInputStream encountered a malformed varint.");
    }

    static zzfw zzd() {
        return new zzfw("Protocol message contained an invalid tag (zero).");
    }

    static zzfw zze() {
        return new zzfw("Protocol message end-group tag did not match expected tag.");
    }

    static zzfz zzf() {
        return new zzfz("Protocol message tag had invalid wire type.");
    }

    static zzfw zzg() {
        return new zzfw("Failed to parse the message.");
    }

    static zzfw zzh() {
        return new zzfw("Protocol message had invalid UTF-8.");
    }
}
