package org.bouncycastle.bcpg;

/* JADX INFO: loaded from: classes6.dex */
public class InputStreamPacket extends Packet {

    /* JADX INFO: renamed from: in */
    private BCPGInputStream f4104in;

    public InputStreamPacket(BCPGInputStream bCPGInputStream) {
        this.f4104in = bCPGInputStream;
    }

    public BCPGInputStream getInputStream() {
        return this.f4104in;
    }
}
