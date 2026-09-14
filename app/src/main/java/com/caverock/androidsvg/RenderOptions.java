package com.caverock.androidsvg;

/* JADX INFO: loaded from: classes2.dex */
public class RenderOptions {
    CSSParser.Ruleset css;
    PreserveAspectRatio preserveAspectRatio;
    String targetId;
    SVG.Box viewBox;
    String viewId;
    SVG.Box viewPort;

    public RenderOptions() {
        this.css = null;
        this.preserveAspectRatio = null;
        this.targetId = null;
        this.viewBox = null;
        this.viewId = null;
        this.viewPort = null;
    }

    public static RenderOptions create() {
        return new RenderOptions();
    }

    public RenderOptions(RenderOptions renderOptions) {
        this.css = null;
        this.preserveAspectRatio = null;
        this.targetId = null;
        this.viewBox = null;
        this.viewId = null;
        this.viewPort = null;
        if (renderOptions == null) {
            return;
        }
        this.css = renderOptions.css;
        this.preserveAspectRatio = renderOptions.preserveAspectRatio;
        this.viewBox = renderOptions.viewBox;
        this.viewId = renderOptions.viewId;
        this.viewPort = renderOptions.viewPort;
    }

    public RenderOptions css(String str) {
        this.css = new CSSParser(CSSParser.Source.RenderOptions).parse(str);
        return this;
    }

    public boolean hasCss() {
        CSSParser.Ruleset ruleset = this.css;
        return ruleset != null && ruleset.ruleCount() > 0;
    }

    public RenderOptions preserveAspectRatio(PreserveAspectRatio preserveAspectRatio) {
        this.preserveAspectRatio = preserveAspectRatio;
        return this;
    }

    public boolean hasPreserveAspectRatio() {
        return this.preserveAspectRatio != null;
    }

    public RenderOptions view(String str) {
        this.viewId = str;
        return this;
    }

    public boolean hasView() {
        return this.viewId != null;
    }

    public RenderOptions viewBox(float f, float f2, float f3, float f4) {
        this.viewBox = new SVG.Box(f, f2, f3, f4);
        return this;
    }

    public boolean hasViewBox() {
        return this.viewBox != null;
    }

    public RenderOptions viewPort(float f, float f2, float f3, float f4) {
        this.viewPort = new SVG.Box(f, f2, f3, f4);
        return this;
    }

    public boolean hasViewPort() {
        return this.viewPort != null;
    }

    public RenderOptions target(String str) {
        this.targetId = str;
        return this;
    }

    public boolean hasTarget() {
        return this.targetId != null;
    }
}
