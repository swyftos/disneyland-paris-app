package com.caverock.androidsvg;

/* JADX INFO: loaded from: classes2.dex */
public class PreserveAspectRatio {
    public static final PreserveAspectRatio BOTTOM;
    public static final PreserveAspectRatio END;
    public static final PreserveAspectRatio FULLSCREEN;
    public static final PreserveAspectRatio FULLSCREEN_START;
    public static final PreserveAspectRatio LETTERBOX;
    public static final PreserveAspectRatio START;
    public static final PreserveAspectRatio TOP;
    private Alignment alignment;
    private Scale scale;
    public static final PreserveAspectRatio UNSCALED = new PreserveAspectRatio(null, null);
    public static final PreserveAspectRatio STRETCH = new PreserveAspectRatio(Alignment.none, null);

    public enum Alignment {
        none,
        xMinYMin,
        xMidYMin,
        xMaxYMin,
        xMinYMid,
        xMidYMid,
        xMaxYMid,
        xMinYMax,
        xMidYMax,
        xMaxYMax
    }

    public enum Scale {
        meet,
        slice
    }

    static {
        Alignment alignment = Alignment.xMidYMid;
        Scale scale = Scale.meet;
        LETTERBOX = new PreserveAspectRatio(alignment, scale);
        Alignment alignment2 = Alignment.xMinYMin;
        START = new PreserveAspectRatio(alignment2, scale);
        END = new PreserveAspectRatio(Alignment.xMaxYMax, scale);
        TOP = new PreserveAspectRatio(Alignment.xMidYMin, scale);
        BOTTOM = new PreserveAspectRatio(Alignment.xMidYMax, scale);
        Scale scale2 = Scale.slice;
        FULLSCREEN = new PreserveAspectRatio(alignment, scale2);
        FULLSCREEN_START = new PreserveAspectRatio(alignment2, scale2);
    }

    PreserveAspectRatio(Alignment alignment, Scale scale) {
        this.alignment = alignment;
        this.scale = scale;
    }

    /* JADX INFO: renamed from: of */
    public static PreserveAspectRatio m739of(String str) {
        try {
            return SVGParser.parsePreserveAspectRatio(str);
        } catch (SVGParseException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Alignment getAlignment() {
        return this.alignment;
    }

    public Scale getScale() {
        return this.scale;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PreserveAspectRatio preserveAspectRatio = (PreserveAspectRatio) obj;
        return this.alignment == preserveAspectRatio.alignment && this.scale == preserveAspectRatio.scale;
    }

    public String toString() {
        return this.alignment + " " + this.scale;
    }
}
