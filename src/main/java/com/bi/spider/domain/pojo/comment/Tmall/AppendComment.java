/**
  * Copyright 2018 bejson.com 
  */
package com.bi.spider.domain.pojo.comment.Tmall;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-12-14 13:45:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AppendComment {

    private int commentId;
    private int days;
    private String reply;
    private Date commentTime;
    private List<String> pics;
    private String content;
    public void setCommentId(int commentId) {
         this.commentId = commentId;
     }
     public int getCommentId() {
         return commentId;
     }

    public void setDays(int days) {
         this.days = days;
     }
     public int getDays() {
         return days;
     }

    public void setReply(String reply) {
         this.reply = reply;
     }
     public String getReply() {
         return reply;
     }

    public void setCommentTime(Date commentTime) {
         this.commentTime = commentTime;
     }
     public Date getCommentTime() {
         return commentTime;
     }

    public void setPics(List<String> pics) {
         this.pics = pics;
     }
     public List<String> getPics() {
         return pics;
     }

    public void setContent(String content) {
         this.content = content;
     }
     public String getContent() {
         return content;
     }

}