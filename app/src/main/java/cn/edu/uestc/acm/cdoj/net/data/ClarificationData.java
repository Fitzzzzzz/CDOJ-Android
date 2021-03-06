package cn.edu.uestc.acm.cdoj.net.data;

import android.graphics.drawable.BitmapDrawable;

/**
 * Created by Grea on 2016/10/27.
 */

public class ClarificationData {
    private int articleId;
    private int clicked;
    private String content;
    private boolean isVisible;
    private String ownerEmail;
    private String ownerName;
    private long time;
    private String title;

    public String jsonString;
    public String contentWithoutLink;
    public String timeString;
    public BitmapDrawable avatar;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public int getClicked() {
        return clicked;
    }

    public void setClicked(int clicked) {
        this.clicked = clicked;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
