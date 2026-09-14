package coil3.svg.internal;

import android.graphics.RectF;
import coil3.Image;
import coil3.request.Options;
import coil3.svg.ImageRequests_androidKt;
import coil3.svg.SvgImage;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;

/* JADX INFO: loaded from: classes2.dex */
final class AndroidSvg implements Svg {
    private RenderOptions renderOptions;
    private final SVG svg;

    public AndroidSvg(SVG svg) {
        this.svg = svg;
    }

    @Override // coil3.svg.internal.Svg
    public float[] getViewBox() {
        RectF documentViewBox = this.svg.getDocumentViewBox();
        if (documentViewBox != null) {
            return new float[]{documentViewBox.left, documentViewBox.top, documentViewBox.right, documentViewBox.bottom};
        }
        return null;
    }

    @Override // coil3.svg.internal.Svg
    public float getWidth() {
        return this.svg.getDocumentWidth();
    }

    @Override // coil3.svg.internal.Svg
    public float getHeight() {
        return this.svg.getDocumentHeight();
    }

    @Override // coil3.svg.internal.Svg
    public void viewBox(float[] fArr) {
        SVG svg = this.svg;
        float f = fArr[0];
        float f2 = fArr[1];
        svg.setDocumentViewBox(f, f2, fArr[2] - f, fArr[3] - f2);
    }

    @Override // coil3.svg.internal.Svg
    public void width(String str) throws SVGParseException {
        this.svg.setDocumentWidth(str);
    }

    @Override // coil3.svg.internal.Svg
    public void height(String str) throws SVGParseException {
        this.svg.setDocumentHeight(str);
    }

    @Override // coil3.svg.internal.Svg
    public void options(Options options) {
        String css = ImageRequests_androidKt.getCss(options);
        if (css != null) {
            RenderOptions renderOptions = new RenderOptions();
            renderOptions.css(css);
            this.renderOptions = renderOptions;
        }
    }

    @Override // coil3.svg.internal.Svg
    public Image asImage(int i, int i2) {
        return new SvgImage(this.svg, this.renderOptions, i, i2);
    }
}
