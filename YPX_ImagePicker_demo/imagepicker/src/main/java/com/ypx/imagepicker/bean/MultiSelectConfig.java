package com.ypx.imagepicker.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 作者：yangpeixing on 2018/9/26 16:27
 * 功能：图片选择器配置器
 * 产权：南京婚尚信息技术
 */
public class MultiSelectConfig implements Serializable {
    private int maxCount = -1;
    private int columnCount = 4;
    private boolean isShowCamera = false;
    private boolean isShowVideo = false;
    private boolean isLoadGif = true;
    private boolean isShowOriginalCheckBox;
    private boolean isCanEditPic;
    private int selectMode;
    private ArrayList<ImageItem> lastImageList = new ArrayList<>();
    private ArrayList<ImageItem> shieldImageList = new ArrayList<>();

    private int cropRatioX = 1;
    private int cropRatioY = 1;

    public boolean isLoadGif() {
        return isLoadGif;
    }

    public void setLoadGif(boolean loadGif) {
        isLoadGif = loadGif;
    }

    public int getCropRatioX() {
        return cropRatioX;
    }

    public void setCropRatio(int x, int y) {
        this.cropRatioX = x;
        this.cropRatioY = y;
    }

    public int getCropRatioY() {
        return cropRatioY;
    }


    public ArrayList<ImageItem> getShieldImageList() {
        return shieldImageList;
    }

    public void setShieldImageList(ArrayList<ImageItem> shieldImageList) {
        this.shieldImageList = shieldImageList;
    }

    public ArrayList<ImageItem> getLastImageList() {
        return lastImageList;
    }

    public void setLastImageList(ArrayList<ImageItem> lastImageList) {
        this.lastImageList = lastImageList;
    }

    public boolean isShowVideo() {
        return isShowVideo;
    }

    public void setShowVideo(boolean showVideo) {
        isShowVideo = showVideo;
    }

    public int getSelectMode() {
        return selectMode;
    }

    public void setSelectMode(int selectMode) {
        this.selectMode = selectMode;
    }

    public int getMaxCount() {
        return maxCount;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public void setColumnCount(int columnCount) {
        this.columnCount = columnCount;
    }

    public boolean isShowCamera() {
        return isShowCamera;
    }

    public void setShowCamera(boolean showCamera) {
        isShowCamera = showCamera;
    }

    public boolean isShowOriginalCheckBox() {
        return isShowOriginalCheckBox;
    }

    public void setShowOriginalCheckBox(boolean showOriginalCheckBox) {
        isShowOriginalCheckBox = showOriginalCheckBox;
    }

    public boolean isCanEditPic() {
        return isCanEditPic;
    }

    public void setCanEditPic(boolean canEditPic) {
        isCanEditPic = canEditPic;
    }

    /**
     * 是否屏蔽某个URL
     */
    public boolean isShieldItem(ImageItem imageItem) {
        if (shieldImageList == null || shieldImageList.size() == 0) {
            return false;
        }
        for (ImageItem item : shieldImageList) {
            if (item.equals(imageItem)) {
                return true;
            }
        }
        return false;
    }
}
