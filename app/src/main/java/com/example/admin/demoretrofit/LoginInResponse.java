package com.example.admin.demoretrofit;

import android.service.autofill.UserData;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginInResponse implements Serializable {
    @SerializedName("status")
    private String status;
    @SerializedName("msg")
    private String message;
    @SerializedName("userData")
    public UserData userData;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }



    public class UserData implements Serializable {
        @SerializedName("userId")
        private String UserId;

        @SerializedName("name")
        private String UserName;

        @SerializedName("email")
        private String email;

        @SerializedName("phone")
        private String PhoneNo;

        @SerializedName("dob")
        private String DOB;

        @SerializedName("profile")
        private String ProfilePic;

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String userId) {
            UserId = userId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String userName) {
            UserName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhoneNo() {
            return PhoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            PhoneNo = phoneNo;
        }

        public String getDOB() {
            return DOB;
        }

        public void setDOB(String DOB) {
            this.DOB = DOB;
        }

        public String getProfilePic() {
            return ProfilePic;
        }

        public void setProfilePic(String profilePic) {
            ProfilePic = profilePic;
        }
    }
}
