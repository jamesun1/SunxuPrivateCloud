package com.physical.model;

import java.io.Serializable;

import javax.persistence.Id;


public class Userinfo implements Serializable {
	@Id
    private String userid;

    private String user;

    private String password;
    
    private String role;
    
    private String usermobile;

    private static final long serialVersionUID = 1L;

    public Userinfo(String userid, String user, String password) {
        this.userid = userid;
        this.user = user;
        this.password = password;
    }
    
    public String getUsermobile() {
		return usermobile;
	}


	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}


	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public Userinfo() {
        super();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user == null ? null : user.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Userinfo other = (Userinfo) that;
        return (this.getUserid() == null ? other.getUserid() == null : this.getUserid().equals(other.getUserid()))
            && (this.getUser() == null ? other.getUser() == null : this.getUser().equals(other.getUser()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserid() == null) ? 0 : getUserid().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userid=").append(userid);
        sb.append(", user=").append(user);
        sb.append(", password=").append(password);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}