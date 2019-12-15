package com.yejh.entity;/**
 * @author yejh
 * @create 2019-11_22 19:40
 */

/**
 * @description: TODO
 **/
public class Publisher {
    private String publisherName;
    private String address;

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherName='" + publisherName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
