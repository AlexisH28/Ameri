package com.c3.Ameri.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.util.Set;

public class UpdatePostRequest {

    @NotBlank(message = "Text is required.")
    @Size(min = 5, max = 500, message = "Text must be between 5 and 500 characters.")
    private String text;

    private String imageUrl;
    private Set<String> tags;

    public UpdatePostRequest() {
    }

    public UpdatePostRequest(String text, String imageUrl, Set<String> tags) {
        this.text = text;
        this.imageUrl = imageUrl;
        this.tags = tags;
    }

    // Getters y Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }
}