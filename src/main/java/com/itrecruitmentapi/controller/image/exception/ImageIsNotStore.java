package com.itrecruitmentapi.controller.image.exception;

public class ImageIsNotStore extends  RuntimeException {
    public ImageIsNotStore(Exception e) {
        super("Could not store the file. Error: " + e.getMessage());
    }
}