package com.physical.model;

import java.io.Serializable;

public class Useraccountinfo implements Serializable {
    private String useraccountinfoid;

    private String treeid;

    private String name;

    private String adress;

    private static final long serialVersionUID = 1L;

    public Useraccountinfo(String useraccountinfoid, String treeid, String name, String adress) {
        this.useraccountinfoid = useraccountinfoid;
        this.treeid = treeid;
        this.name = name;
        this.adress = adress;
    }

    public Useraccountinfo() {
        super();
    }

    public String getUseraccountinfoid() {
        return useraccountinfoid;
    }

    public void setUseraccountinfoid(String useraccountinfoid) {
        this.useraccountinfoid = useraccountinfoid == null ? null : useraccountinfoid.trim();
    }

    public String getTreeid() {
        return treeid;
    }

    public void setTreeid(String treeid) {
        this.treeid = treeid == null ? null : treeid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress == null ? null : adress.trim();
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
        Useraccountinfo other = (Useraccountinfo) that;
        return (this.getUseraccountinfoid() == null ? other.getUseraccountinfoid() == null : this.getUseraccountinfoid().equals(other.getUseraccountinfoid()))
            && (this.getTreeid() == null ? other.getTreeid() == null : this.getTreeid().equals(other.getTreeid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getAdress() == null ? other.getAdress() == null : this.getAdress().equals(other.getAdress()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUseraccountinfoid() == null) ? 0 : getUseraccountinfoid().hashCode());
        result = prime * result + ((getTreeid() == null) ? 0 : getTreeid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getAdress() == null) ? 0 : getAdress().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", useraccountinfoid=").append(useraccountinfoid);
        sb.append(", treeid=").append(treeid);
        sb.append(", name=").append(name);
        sb.append(", adress=").append(adress);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}