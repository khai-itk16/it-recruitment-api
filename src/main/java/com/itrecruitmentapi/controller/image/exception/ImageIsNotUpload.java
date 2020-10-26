package com.itrecruitmentapi.controller.image.exception;

public class ImageIsNotUpload extends  RuntimeException {
    public ImageIsNotUpload() {
        super("Fail to upload images!");
    }
}