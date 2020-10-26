package com.itrecruitmentapi.controller.image.exception;

public class ImageIsNotLoad extends  RuntimeException {
    public ImageIsNotLoad(Exception e) {
        super("Could not load the files! Error: " + e.getMessage());
    }
}