package app.myapplication2.gcu.ac.uk.MartinFriedberg;

import java.io.Serializable;

/**
 * Created by Martin on 15/12/2014.
 */
public class RSSDataItem implements Serializable {

    // *********************************************
    // Declare variables etc.
    // *********************************************

    private String itemTitle;
    private String itemDesc;
    private String itemLink;

    // *********************************************
    // Declare getters and setters etc.
    // *********************************************

    public String getItemTitle()
    {
        return this.itemTitle;
    }

    public void setItemTitle(String sItemTitle)
    {
        this.itemTitle = sItemTitle;
    }

    public String getItemDesc()
    {
        return this.itemDesc;
    }

    public void setItemDesc(String sItemDesc)
    {
        this.itemDesc = sItemDesc;
    }

    public String getItemLink()
    {
        return this.itemLink;
    }

    public void setItemLink(String sItemLink)
    {
        this.itemLink = sItemLink;
    }

    // **************************************************
    // Declare constructor.
    // **************************************************

    public RSSDataItem()
    {
        this.itemTitle = "";
        this.itemDesc = "";
        this.itemLink = "";
    }

    @Override
    public String toString() {
        String starSignRSSHoroscopeData;
        starSignRSSHoroscopeData = "RSSDataItem [itemTitle=" + itemTitle;
        starSignRSSHoroscopeData = ", itemDesc=" + itemDesc;
        starSignRSSHoroscopeData = ", itemLink=" + itemLink +"]";
        return starSignRSSHoroscopeData;
    }

}