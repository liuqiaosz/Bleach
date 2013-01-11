/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bleach.server.db.vo;

import commons.module.entity.annotation.PrimaryKey;
import commons.module.entity.annotation.Table;
import commons.module.entity.annotation.TableField;

/**
 * 世界数据
 * @author LiuQiao
 */
@Table(TableName = "T_EposJournal")
public class TableWorld
{
    @PrimaryKey
    private int idx;
    @TableField
    private String title = "";
    @TableField
    private String desc = "";
    @TableField
    private String imageId = "";
    @TableField
    private boolean needUnlock = true;

    /**
     * @return the idx
     */
    public int getIdx()
    {
        return idx;
    }

    /**
     * @param idx the idx to set
     */
    public void setIdx(int idx)
    {
        this.idx = idx;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the desc
     */
    public String getDesc()
    {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    /**
     * @return the imageId
     */
    public String getImageId()
    {
        return imageId;
    }

    /**
     * @param imageId the imageId to set
     */
    public void setImageId(String imageId)
    {
        this.imageId = imageId;
    }

    /**
     * @return the needUnlock
     */
    public boolean isNeedUnlock()
    {
        return needUnlock;
    }

    /**
     * @param needUnlock the needUnlock to set
     */
    public void setNeedUnlock(boolean needUnlock)
    {
        this.needUnlock = needUnlock;
    }
    
    
}
