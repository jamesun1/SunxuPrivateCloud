package com.physical.model;

import java.io.Serializable;

import javax.persistence.Id;

public class Dictionary implements Serializable {
	@Id
    private String dictionaryid;

    private String classificationid;

    private String name;

    private String status;

    private static final long serialVersionUID = 1L;

    public Dictionary(String dictionaryid, String classificationid, String name, String status) {
        this.dictionaryid = dictionaryid;
        this.classificationid = classificationid;
        this.name = name;
        this.status = status;
    }

    public Dictionary() {
        super();
    }

    public String getDictionaryid() {
        return dictionaryid;
    }

    public void setDictionaryid(String dictionaryid) {
        this.dictionaryid = dictionaryid == null ? null : dictionaryid.trim();
    }

    public String getClassificationid() {
        return classificationid;
    }

    public void setClassificationid(String classificationid) {
        this.classificationid = classificationid == null ? null : classificationid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
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
        Dictionary other = (Dictionary) that;
        return (this.getDictionaryid() == null ? other.getDictionaryid() == null : this.getDictionaryid().equals(other.getDictionaryid()))
            && (this.getClassificationid() == null ? other.getClassificationid() == null : this.getClassificationid().equals(other.getClassificationid()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictionaryid() == null) ? 0 : getDictionaryid().hashCode());
        result = prime * result + ((getClassificationid() == null) ? 0 : getClassificationid().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictionaryid=").append(dictionaryid);
        sb.append(", classificationid=").append(classificationid);
        sb.append(", name=").append(name);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}