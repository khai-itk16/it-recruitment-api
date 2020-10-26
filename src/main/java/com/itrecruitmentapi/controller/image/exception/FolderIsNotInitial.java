package com.itrecruitmentapi.controller.image.exception;

public class FolderIsNotInitial extends  RuntimeException {
    public FolderIsNotInitial() {
        super("Could not initialize folder for upload!");
    }
}
