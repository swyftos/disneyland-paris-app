package org.bouncycastle.bcpg;

/* loaded from: classes6.dex */
public class CRC24 {
    private int crc = 11994318;

    public int getValue() {
        return this.crc;
    }

    public void reset() {
        this.crc = 11994318;
    }

    public void update(int i) {
        this.crc = (i << 16) ^ this.crc;
        for (int i2 = 0; i2 < 8; i2++) {
            int i3 = this.crc << 1;
            this.crc = i3;
            if ((16777216 & i3) != 0) {
                this.crc = i3 ^ 25578747;
            }
        }
    }
}
