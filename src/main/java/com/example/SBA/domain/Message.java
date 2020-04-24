package com.example.SBA.domain;


import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String text;
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public User getAuthor() {
        return author;
    }

    public String getAuthorName(){
        return author != null? author.getUsername():"none";
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public Message() {
    }

    public Message(String text, String tag, User user){
        this.text = text;
        this.tag = tag;
        this.author = user;
    }
    public Integer getId() {
        return Id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
