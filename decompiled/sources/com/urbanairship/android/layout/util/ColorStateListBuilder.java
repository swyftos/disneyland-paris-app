package com.urbanairship.android.layout.util;

import android.content.res.ColorStateList;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ColorStateListBuilder {
    private static final int[] EMPTY_STATE_SET = new int[0];
    private final List colors = new ArrayList();
    private final List states = new ArrayList();

    public ColorStateListBuilder add(int i, int... iArr) {
        this.colors.add(Integer.valueOf(i));
        this.states.add(iArr);
        return this;
    }

    public ColorStateListBuilder add(int i) {
        this.colors.add(Integer.valueOf(i));
        this.states.add(EMPTY_STATE_SET);
        return this;
    }

    public ColorStateList build() {
        return new ColorStateList(getStates(), getColors());
    }

    private int[] getColors() {
        int[] iArr = new int[this.colors.size()];
        for (int i = 0; i < this.colors.size(); i++) {
            iArr[i] = ((Integer) this.colors.get(i)).intValue();
        }
        return iArr;
    }

    private int[][] getStates() {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, this.states.size(), 1);
        for (int i = 0; i < this.states.size(); i++) {
            iArr[i] = (int[]) this.states.get(i);
        }
        return iArr;
    }
}
