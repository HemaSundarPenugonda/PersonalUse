package com.hs.testDataBeans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersDataBean {
    private User admin;
    private User editor;
    private User superuser;
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private User user5;
    private User user6;
    private User user7;
    private User user8;
    private User user9;
    private User user10;
    private User user11;
    private User user12;
    private User user13;
    private User user14;
    private User user15;
    private User user16;
    private User user17;
    private User user18;
    private User user19;

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public User getEditor() {
        return editor;
    }

    public void setEditor(User editor) {
        this.editor = editor;
    }

    public User getSuperuser() {
        return superuser;
    }

    public void setSuperuser(User superuser) {
        this.superuser = superuser;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    public User getUser3() {
        return user3;
    }

    public void setUser3(User user3) {
        this.user3 = user3;
    }

    public User getUser4() {
        return user4;
    }

    public void setUser4(User user4) {
        this.user4 = user4;
    }

    public User getUser5() {
        return user5;
    }

    public void setUser5(User user5) {
        this.user5 = user5;
    }

    public User getUser6() {
        return user6;
    }

    public void setUser6(User user6) {
        this.user6 = user6;
    }

    public User getUser7() {
        return user7;
    }

    public void setUser7(User user7) {
        this.user7 = user7;
    }

    public User getUser8() {
        return user8;
    }

    public void setUser8(User user8) {
        this.user8 = user8;
    }

    public User getUser9() {
        return user9;
    }

    public void setUser9(User user9) {
        this.user9 = user9;
    }

    public User getUser10() {
        return user10;
    }

    public void setUser10(User user10) {
        this.user10 = user10;
    }

    public User getUser11() {
        return user11;
    }

    public void setUser11(User user11) {
        this.user11 = user11;
    }

    public User getUser12() {
        return user12;
    }

    public void setUser12(User user12) {
        this.user12 = user12;
    }

    public User getUser13() {
        return user13;
    }

    public void setUser13(User user13) {
        this.user13 = user13;
    }

    public User getUser14() {
        return user14;
    }

    public void setUser14(User user14) {
        this.user14 = user14;
    }

    public User getUser15() {
        return user15;
    }

    public void setUser15(User user15) {
        this.user15 = user15;
    }

    public User getUser16() {
        return user16;
    }

    public void setUser16(User user16) {
        this.user16 = user16;
    }

    public User getUser17() {
        return user17;
    }

    public void setUser17(User user17) {
        this.user17 = user17;
    }

    public User getUser18() {
        return user18;
    }

    public void setUser18(User user18) {
        this.user18 = user18;
    }

    public User getUser19() {
        return user19;
    }

    public void setUser19(User user19) {
        this.user19 = user19;
    }

    public class User {
        private String userName;
        private String passWord;
        private String thaiID;
        private String description;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public String getThaiID() {
            return thaiID;
        }

        public void setThaiID(String thaiID) {
            this.thaiID = thaiID;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "name: " + userName + "\tpwd: " + passWord;
        }
    }

}



