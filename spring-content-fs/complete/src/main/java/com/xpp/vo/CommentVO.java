package com.xpp.vo;

import com.xpp.entity.CommentDTO;

import java.util.ArrayList;

/**
 * @author pengyuxiang
 * @date 2019/1/12
 */
public class CommentVO {
    private int owner;
    private int pages;
    private boolean needCode;
    private int isAdmin;
    private int results;
    private ArrayList<HotComment> hotComment;
    private ArrayList<Comment> comment;
    private int page;


    public void addComment(CommentDTO commentDTO){
        this.comment.add(new Comment(commentDTO));
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public boolean isNeedCode() {
        return needCode;
    }

    public void setNeedCode(boolean needCode) {
        this.needCode = needCode;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public int getResults() {
        return results;
    }

    public void setResults(int results) {
        this.results = results;
    }

    public ArrayList<HotComment> getHotComment() {
        return hotComment;
    }

    public void setHotComment(ArrayList<HotComment> hotComment) {
        this.hotComment = hotComment;
    }

    public ArrayList<Comment> getComment() {
        return comment;
    }

    public void setComment(ArrayList<Comment> comment) {
        this.comment = comment;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public class HotComment {
        private String face;
        private int mid;
        private String sex;
        private int isgood;
        private int adCheck;
        private String nick;
        private String create_at;
        private int rank;
        private int good;
        private LevelInfo level_info;
        private int lv;
        private String fbid;
        private int reply_count;
        private String msg;
        private int create;
        private String device;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getIsgood() {
            return isgood;
        }

        public void setIsgood(int isgood) {
            this.isgood = isgood;
        }

        public int getAdCheck() {
            return adCheck;
        }

        public void setAdCheck(int adCheck) {
            this.adCheck = adCheck;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getGood() {
            return good;
        }

        public void setGood(int good) {
            this.good = good;
        }

        public LevelInfo getLevel_info() {
            return level_info;
        }

        public void setLevel_info(LevelInfo level_info) {
            this.level_info = level_info;
        }

        public int getLv() {
            return lv;
        }

        public void setLv(int lv) {
            this.lv = lv;
        }

        public String getFbid() {
            return fbid;
        }

        public void setFbid(String fbid) {
            this.fbid = fbid;
        }

        public int getReply_count() {
            return reply_count;
        }

        public void setReply_count(int reply_count) {
            this.reply_count = reply_count;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCreate() {
            return create;
        }

        public void setCreate(int create) {
            this.create = create;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }
    }

    public class Comment {
        private String face;
        private int mid;
        private String sex;
        private int isgood;
        private int adCheck;
        private String nick;
        private String create_at;
        private int rank;
        private int good;
        private LevelInfo level_info;
        private int lv;
        private String fbid;
        private int reply_count;
        private String msg;
        private int create;
        private String device;


        public Comment(CommentDTO commentDTO) {
            this.face = commentDTO.getFace();
            this.sex = commentDTO.getSex();
            this.nick = commentDTO.getNickname();
            this.rank = commentDTO.getRank();
            this.lv = commentDTO.getLv();
            this.msg = commentDTO.getContent();
        }

        public Comment(String face, String sex, String nick, Integer rank, String msg, Integer lv) {
            this.face = face;
            this.sex = sex;
            this.nick = nick;
            this.rank = rank;
            this.lv = lv;
            this.msg = msg;
        }

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public int getIsgood() {
            return isgood;
        }

        public void setIsgood(int isgood) {
            this.isgood = isgood;
        }

        public int getAdCheck() {
            return adCheck;
        }

        public void setAdCheck(int adCheck) {
            this.adCheck = adCheck;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getGood() {
            return good;
        }

        public void setGood(int good) {
            this.good = good;
        }

        public LevelInfo getLevel_info() {
            return level_info;
        }

        public void setLevel_info(LevelInfo level_info) {
            this.level_info = level_info;
        }

        public int getLv() {
            return lv;
        }

        public void setLv(int lv) {
            this.lv = lv;
        }

        public String getFbid() {
            return fbid;
        }

        public void setFbid(String fbid) {
            this.fbid = fbid;
        }

        public int getReply_count() {
            return reply_count;
        }

        public void setReply_count(int reply_count) {
            this.reply_count = reply_count;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public int getCreate() {
            return create;
        }

        public void setCreate(int create) {
            this.create = create;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

    }

    public class LevelInfo {
        private int current_level;

        public int getCurrent_level() {
            return current_level;
        }

        public void setCurrent_level(int current_level) {
            this.current_level = current_level;
        }
    }

}
