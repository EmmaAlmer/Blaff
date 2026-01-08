package com.emmaalmer.Blaff;

public class Player {

    Long id;
    String name;
    Role role;
    String word;

    public Player(Long id, String name, Role role, String word) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
