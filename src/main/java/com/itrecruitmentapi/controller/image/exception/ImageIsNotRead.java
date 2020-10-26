package com.itrecruitmentapi.controller.image.exception;

public class ImageIsNotRead extends  RuntimeException {
    public ImageIsNotRead() {
        super("Could not read the file!");
    }
}
