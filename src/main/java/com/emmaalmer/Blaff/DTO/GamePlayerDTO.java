package com.emmaalmer.Blaff.DTO;

public record GamePlayerDTO(
        String name,
        String role,
        String word
){
    public String getName() { return name; }
    public String getRole() { return role; }
    public String getWord() { return word; }
}
