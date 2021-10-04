package com.leegyungjun.boostcourse_android;

public class CommentItem {

    private String id;
    private String time;
    private String comment;
    private String likeCount;
    private Float rating;

    public CommentItem(String id, String time, String comment, String likeCount, Float rating) {
        this.id = id;
        this.time = time;
        this.comment = comment;
        this.likeCount = likeCount;
        this.rating = rating;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "CommentItem{" +
                "id='" + id + '\'' +
                ", time='" + time + '\'' +
                ", comment='" + comment + '\'' +
                ", likeCount='" + likeCount + '\'' +
                ", rating=" + rating +
                '}';
    }
}
