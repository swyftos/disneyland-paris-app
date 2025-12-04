package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.Util;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.shockwave.pdfium.util.SizeF;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
class PagesLoader {
    private int cacheOrder;
    private float pageRelativePartHeight;
    private float pageRelativePartWidth;
    private float partRenderHeight;
    private float partRenderWidth;
    private PDFView pdfView;
    private final int preloadOffset;
    private final RectF thumbnailRect = new RectF(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 1.0f, 1.0f);
    private float xOffset;
    private float yOffset;

    private class Holder {
        int col;
        int row;

        private Holder() {
        }

        public String toString() {
            return "Holder{row=" + this.row + ", col=" + this.col + '}';
        }
    }

    private class RenderRange {
        GridSize gridSize;
        Holder leftTop;
        int page = 0;
        Holder rightBottom;

        RenderRange() {
            this.gridSize = new GridSize();
            this.leftTop = new Holder();
            this.rightBottom = new Holder();
        }

        public String toString() {
            return "RenderRange{page=" + this.page + ", gridSize=" + this.gridSize + ", leftTop=" + this.leftTop + ", rightBottom=" + this.rightBottom + '}';
        }
    }

    private class GridSize {
        int cols;
        int rows;

        private GridSize() {
        }

        public String toString() {
            return "GridSize{rows=" + this.rows + ", cols=" + this.cols + '}';
        }
    }

    PagesLoader(PDFView pDFView) {
        this.pdfView = pDFView;
        this.preloadOffset = Util.getDP(pDFView.getContext(), Constants.PRELOAD_OFFSET);
    }

    private void getPageColsRows(GridSize gridSize, int i) {
        SizeF pageSize = this.pdfView.pdfFile.getPageSize(i);
        float width = 1.0f / pageSize.getWidth();
        float height = (Constants.PART_SIZE * (1.0f / pageSize.getHeight())) / this.pdfView.getZoom();
        float zoom = (Constants.PART_SIZE * width) / this.pdfView.getZoom();
        gridSize.rows = MathUtils.ceil(1.0f / height);
        gridSize.cols = MathUtils.ceil(1.0f / zoom);
    }

    private void calculatePartSize(GridSize gridSize) {
        float f = 1.0f / gridSize.cols;
        this.pageRelativePartWidth = f;
        float f2 = 1.0f / gridSize.rows;
        this.pageRelativePartHeight = f2;
        float f3 = Constants.PART_SIZE;
        this.partRenderWidth = f3 / f;
        this.partRenderHeight = f3 / f2;
    }

    private List getRenderRangeList(float f, float f2, float f3, float f4) {
        float pageOffset;
        float width;
        float f5;
        float height;
        float f6;
        float f7;
        float f8;
        int i;
        boolean z;
        float width2;
        float height2;
        float f9 = -MathUtils.max(f, BitmapDescriptorFactory.HUE_RED);
        float f10 = -MathUtils.max(f2, BitmapDescriptorFactory.HUE_RED);
        float f11 = -MathUtils.max(f3, BitmapDescriptorFactory.HUE_RED);
        float f12 = -MathUtils.max(f4, BitmapDescriptorFactory.HUE_RED);
        float f13 = this.pdfView.isSwipeVertical() ? f10 : f9;
        float f14 = this.pdfView.isSwipeVertical() ? f12 : f11;
        PDFView pDFView = this.pdfView;
        int pageAtOffset = pDFView.pdfFile.getPageAtOffset(f13, pDFView.getZoom());
        PDFView pDFView2 = this.pdfView;
        int pageAtOffset2 = pDFView2.pdfFile.getPageAtOffset(f14, pDFView2.getZoom());
        int i2 = 1;
        int i3 = (pageAtOffset2 - pageAtOffset) + 1;
        LinkedList linkedList = new LinkedList();
        int i4 = pageAtOffset;
        while (i4 <= pageAtOffset2) {
            RenderRange renderRange = new RenderRange();
            renderRange.page = i4;
            if (i4 != pageAtOffset) {
                if (i4 == pageAtOffset2) {
                    PDFView pDFView3 = this.pdfView;
                    pageOffset = pDFView3.pdfFile.getPageOffset(i4, pDFView3.getZoom());
                    if (this.pdfView.isSwipeVertical()) {
                        f6 = pageOffset;
                        pageOffset = f9;
                    } else {
                        f6 = f10;
                    }
                    height = f12;
                    f5 = f6;
                } else {
                    PDFView pDFView4 = this.pdfView;
                    pageOffset = pDFView4.pdfFile.getPageOffset(i4, pDFView4.getZoom());
                    PDFView pDFView5 = this.pdfView;
                    SizeF scaledPageSize = pDFView5.pdfFile.getScaledPageSize(i4, pDFView5.getZoom());
                    if (this.pdfView.isSwipeVertical()) {
                        f5 = pageOffset;
                        height = scaledPageSize.getHeight() + pageOffset;
                        pageOffset = f9;
                    } else {
                        width = scaledPageSize.getWidth() + pageOffset;
                        f5 = f10;
                        height = f12;
                    }
                }
                width = f11;
            } else if (i3 == i2) {
                pageOffset = f9;
                f5 = f10;
                width = f11;
                height = f12;
            } else {
                PDFView pDFView6 = this.pdfView;
                float pageOffset2 = pDFView6.pdfFile.getPageOffset(i4, pDFView6.getZoom());
                PDFView pDFView7 = this.pdfView;
                SizeF scaledPageSize2 = pDFView7.pdfFile.getScaledPageSize(i4, pDFView7.getZoom());
                if (this.pdfView.isSwipeVertical()) {
                    height2 = pageOffset2 + scaledPageSize2.getHeight();
                    width2 = f11;
                } else {
                    width2 = pageOffset2 + scaledPageSize2.getWidth();
                    height2 = f12;
                }
                f5 = f10;
                height = height2;
                width = width2;
                pageOffset = f9;
            }
            getPageColsRows(renderRange.gridSize, renderRange.page);
            PDFView pDFView8 = this.pdfView;
            float f15 = f9;
            SizeF scaledPageSize3 = pDFView8.pdfFile.getScaledPageSize(renderRange.page, pDFView8.getZoom());
            float height3 = scaledPageSize3.getHeight() / renderRange.gridSize.rows;
            float width3 = scaledPageSize3.getWidth() / renderRange.gridSize.cols;
            PDFView pDFView9 = this.pdfView;
            float f16 = f10;
            float secondaryPageOffset = pDFView9.pdfFile.getSecondaryPageOffset(i4, pDFView9.getZoom());
            if (this.pdfView.isSwipeVertical()) {
                Holder holder = renderRange.leftTop;
                f7 = f11;
                PDFView pDFView10 = this.pdfView;
                f8 = f12;
                i = pageAtOffset;
                holder.row = MathUtils.floor(Math.abs(f5 - pDFView10.pdfFile.getPageOffset(renderRange.page, pDFView10.getZoom())) / height3);
                renderRange.leftTop.col = MathUtils.floor(MathUtils.min(pageOffset - secondaryPageOffset, BitmapDescriptorFactory.HUE_RED) / width3);
                Holder holder2 = renderRange.rightBottom;
                PDFView pDFView11 = this.pdfView;
                holder2.row = MathUtils.ceil(Math.abs(height - pDFView11.pdfFile.getPageOffset(renderRange.page, pDFView11.getZoom())) / height3);
                renderRange.rightBottom.col = MathUtils.floor(MathUtils.min(width - secondaryPageOffset, BitmapDescriptorFactory.HUE_RED) / width3);
                z = false;
            } else {
                f7 = f11;
                f8 = f12;
                i = pageAtOffset;
                Holder holder3 = renderRange.leftTop;
                PDFView pDFView12 = this.pdfView;
                holder3.col = MathUtils.floor(Math.abs(pageOffset - pDFView12.pdfFile.getPageOffset(renderRange.page, pDFView12.getZoom())) / width3);
                renderRange.leftTop.row = MathUtils.floor(MathUtils.min(f5 - secondaryPageOffset, BitmapDescriptorFactory.HUE_RED) / height3);
                Holder holder4 = renderRange.rightBottom;
                PDFView pDFView13 = this.pdfView;
                holder4.col = MathUtils.floor(Math.abs(width - pDFView13.pdfFile.getPageOffset(renderRange.page, pDFView13.getZoom())) / width3);
                z = false;
                renderRange.rightBottom.row = MathUtils.floor(MathUtils.min(height - secondaryPageOffset, BitmapDescriptorFactory.HUE_RED) / height3);
            }
            linkedList.add(renderRange);
            i4++;
            f10 = f16;
            f12 = f8;
            f9 = f15;
            pageAtOffset = i;
            i2 = 1;
            f11 = f7;
        }
        return linkedList;
    }

    private void loadVisible() {
        float f = this.preloadOffset;
        float f2 = this.xOffset;
        float f3 = this.yOffset;
        List<RenderRange> renderRangeList = getRenderRangeList((-f2) + f, (-f3) + f, ((-f2) - this.pdfView.getWidth()) - f, ((-f3) - this.pdfView.getHeight()) - f);
        Iterator it = renderRangeList.iterator();
        while (it.hasNext()) {
            loadThumbnail(((RenderRange) it.next()).page);
        }
        int iLoadPage = 0;
        for (RenderRange renderRange : renderRangeList) {
            calculatePartSize(renderRange.gridSize);
            int i = renderRange.page;
            Holder holder = renderRange.leftTop;
            int i2 = holder.row;
            Holder holder2 = renderRange.rightBottom;
            iLoadPage += loadPage(i, i2, holder2.row, holder.col, holder2.col, Constants.Cache.CACHE_SIZE - iLoadPage);
            if (iLoadPage >= Constants.Cache.CACHE_SIZE) {
                return;
            }
        }
    }

    private int loadPage(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i2 <= i3) {
            for (int i8 = i4; i8 <= i5; i8++) {
                if (loadCell(i, i2, i8, this.pageRelativePartWidth, this.pageRelativePartHeight)) {
                    i7++;
                }
                if (i7 >= i6) {
                    return i7;
                }
            }
            i2++;
        }
        return i7;
    }

    private boolean loadCell(int i, int i2, int i3, float f, float f2) {
        float f3 = i3 * f;
        float f4 = i2 * f2;
        float f5 = this.partRenderWidth;
        float f6 = this.partRenderHeight;
        float f7 = f3 + f > 1.0f ? 1.0f - f3 : f;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 * f7;
        float f10 = f6 * f8;
        RectF rectF = new RectF(f3, f4, f7 + f3, f8 + f4);
        if (f9 <= BitmapDescriptorFactory.HUE_RED || f10 <= BitmapDescriptorFactory.HUE_RED) {
            return false;
        }
        if (!this.pdfView.cacheManager.upPartIfContained(i, rectF, this.cacheOrder)) {
            PDFView pDFView = this.pdfView;
            pDFView.renderingHandler.addRenderingTask(i, f9, f10, rectF, false, this.cacheOrder, pDFView.isBestQuality(), this.pdfView.isAnnotationRendering());
        }
        this.cacheOrder++;
        return true;
    }

    private void loadThumbnail(int i) {
        SizeF pageSize = this.pdfView.pdfFile.getPageSize(i);
        float width = pageSize.getWidth() * Constants.THUMBNAIL_RATIO;
        float height = pageSize.getHeight() * Constants.THUMBNAIL_RATIO;
        if (this.pdfView.cacheManager.containsThumbnail(i, this.thumbnailRect)) {
            return;
        }
        PDFView pDFView = this.pdfView;
        pDFView.renderingHandler.addRenderingTask(i, width, height, this.thumbnailRect, true, 0, pDFView.isBestQuality(), this.pdfView.isAnnotationRendering());
    }

    void loadPages() {
        this.cacheOrder = 1;
        this.xOffset = -MathUtils.max(this.pdfView.getCurrentXOffset(), BitmapDescriptorFactory.HUE_RED);
        this.yOffset = -MathUtils.max(this.pdfView.getCurrentYOffset(), BitmapDescriptorFactory.HUE_RED);
        loadVisible();
    }
}
