package com.ypx.imagepicker.data;


import com.ypx.imagepicker.bean.ImageItem;
import com.ypx.imagepicker.bean.ImageSet;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：yangpeixing on 2018/9/20 15:43
 * 功能：
 * 产权：南京婚尚信息技术
 */
public enum MultiPickerData {

    instance;

    private ArrayList<ImageItem> selectImgs = new ArrayList<>();
    private ImageSet currentImageSet = new ImageSet();

    public void clear() {
        selectImgs.clear();
        currentImageSet = null;
    }

    public ImageSet getCurrentImageSet() {
        if (currentImageSet == null) {
            currentImageSet = new ImageSet();
        }
        return currentImageSet;
    }

    public void setCurrentImageSet(ImageSet mCurrentImageSet) {
        if (mCurrentImageSet == null) {
            return;
        }
        currentImageSet = mCurrentImageSet;
    }

    public void addImageItem(ImageItem imageItem) {
        if (imageItem == null) {
            return;
        }
        if (selectImgs == null) {
            selectImgs = new ArrayList<>();
        }
        //去重
        for (ImageItem item : selectImgs) {
            if (item.equals(imageItem)) {
                return;
            }
        }
        selectImgs.add(imageItem);
    }

    public void addAllImageItems(ArrayList<ImageItem> imageItem) {
        if (imageItem == null || imageItem.size() == 0) {
            return;
        }
        if (selectImgs == null) {
            selectImgs = new ArrayList<>();
        }
        //去重
        for (ImageItem mItem : imageItem) {
            addImageItem(mItem);
        }
    }

    public void removeImageItem(ImageItem imageItem) {
        if (imageItem != null && selectImgs != null) {
            for(ImageItem imageItem1:selectImgs){
                if(imageItem.equals(imageItem1)){
                    selectImgs.remove(imageItem);
                    return;
                }
            }
        }
    }

    public boolean hasItem(ImageItem imageItem) {
        if (imageItem == null || imageItem.path == null || selectImgs == null) {
            return false;
        }
        for (ImageItem item : selectImgs) {
            if (item.path != null && item.path.equals(imageItem.path)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return selectImgs == null || selectImgs.size() == 0;
    }

    public void setSelectImageList(ArrayList<ImageItem> selectImgs) {
        this.selectImgs = selectImgs;
    }

    public ArrayList<ImageItem> getSelectImageList() {
        if (selectImgs != null) {
            return selectImgs;
        }
        return new ArrayList<>();
    }

    public int getSelectCount() {
        if (selectImgs == null) {
            return 0;
        }
        return selectImgs.size();
    }

    public boolean isOverLimit(int limit) {
        return selectImgs != null && selectImgs.size() > limit;
    }
}
