package coil3.svg;

import android.graphics.Canvas;
import coil3.Image;
import com.caverock.androidsvg.RenderOptions;
import com.caverock.androidsvg.SVG;
import com.tagcommander.lib.p193serverside.schemas.TCEventPropertiesNames;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(m1835d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0014\u0010\u001a\u001a\u00020\u001b2\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\b\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, m1836d2 = {"Lcoil3/svg/SvgImage;", "Lcoil3/Image;", "svg", "Lcom/caverock/androidsvg/SVG;", "renderOptions", "Lcom/caverock/androidsvg/RenderOptions;", "width", "", "height", "<init>", "(Lcom/caverock/androidsvg/SVG;Lcom/caverock/androidsvg/RenderOptions;II)V", "getSvg", "()Lcom/caverock/androidsvg/SVG;", "getRenderOptions", "()Lcom/caverock/androidsvg/RenderOptions;", "getWidth", "()I", "getHeight", TCEventPropertiesNames.TCP_SIZE, "", "getSize", "()J", "shareable", "", "getShareable", "()Z", "draw", "", "canvas", "Landroid/graphics/Canvas;", "Lcoil3/Canvas;", "coil-svg_release"}, m1837k = 1, m1838mv = {2, 0, 0}, m1840xi = 48)
public final class SvgImage implements Image {
    private final int height;
    private final RenderOptions renderOptions;
    private final SVG svg;
    private final int width;

    @Override // coil3.Image
    public boolean getShareable() {
        return true;
    }

    @Override // coil3.Image
    public long getSize() {
        return 2048L;
    }

    public SvgImage(@NotNull SVG svg, @Nullable RenderOptions renderOptions, int i, int i2) {
        this.svg = svg;
        this.renderOptions = renderOptions;
        this.width = i;
        this.height = i2;
    }

    @NotNull
    public final SVG getSvg() {
        return this.svg;
    }

    @Nullable
    public final RenderOptions getRenderOptions() {
        return this.renderOptions;
    }

    @Override // coil3.Image
    public int getWidth() {
        return this.width;
    }

    @Override // coil3.Image
    public int getHeight() {
        return this.height;
    }

    @Override // coil3.Image
    public void draw(@NotNull Canvas canvas) {
        this.svg.renderToCanvas(canvas, this.renderOptions);
    }
}
