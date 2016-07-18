package com.example.entity;

import javax.persistence.*;

/**
 * Created by bangae1 on 2016-06-27.
 */
@Entity
@Table(name = "video_kind", schema = "dev", catalog = "")
public class VideosKindEntity {
    private int videoKindSeq;
    private String coverName;
    private String coverPath;
    private String actor;
    private String country;
    private String genre;
    private String title1;
    private String title2;
    private double star;
    private String start_date;
    private boolean flag;

    @Id
    @Column(name = "video_kind_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getVideoKindSeq() {
        return videoKindSeq;
    }

    public void setVideoKindSeq(int videoKindSeq) {
        this.videoKindSeq = videoKindSeq;
    }

    @Basic
    @Column(name = "cover_name")
    public String getCoverName() {
        return coverName;
    }

    public void setCoverName(String coverName) {
        this.coverName = coverName;
    }

    @Basic
    @Column(name = "cover_path")
    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    @Basic
    @Column(name = "actor")
    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Basic
    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "genre")
    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Basic
    @Column(name = "title1")
    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    @Basic
    @Column(name = "title2")
    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    @Basic
    @Column(name = "star")
    public double getStar() {
        return star;
    }

    public void setStar(double star) {
        this.star = star;
    }

    @Basic
    @Column(name ="start_date")
    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    @Basic
    @Column(name ="flag")
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideosKindEntity that = (VideosKindEntity) o;

        if (videoKindSeq != that.videoKindSeq) return false;
        if (coverName != null ? !coverName.equals(that.coverName) : that.coverName != null) return false;
        if (coverPath != null ? !coverPath.equals(that.coverPath) : that.coverPath != null) return false;
        if (title1 != null ? !title1.equals(that.title1) : that.title1 != null) return false;
        if (title2 != null ? !title2.equals(that.title2) : that.title2 != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = videoKindSeq;
        result = 31 * result + (coverName != null ? coverName.hashCode() : 0);
        result = 31 * result + (coverPath != null ? coverPath.hashCode() : 0);
        result = 31 * result + (title1 != null ? title1.hashCode() : 0);
        result = 31 * result + (title2 != null ? title2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "VideosKindEntity{" +
                "videoKindSeq=" + videoKindSeq +
                ", coverName='" + coverName + '\'' +
                ", coverPath='" + coverPath + '\'' +
                ", actor='" + actor + '\'' +
                ", country='" + country + '\'' +
                ", genre='" + genre + '\'' +
                ", title1='" + title1 + '\'' +
                ", title2='" + title2 + '\'' +
                ", star=" + star +
                ", start_date='" + start_date + '\'' +
                ", flag=" + flag +
                '}';
    }
}
