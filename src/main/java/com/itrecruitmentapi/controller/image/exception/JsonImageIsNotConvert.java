package com.itrecruitmentapi.controller.image.exception;

public class JsonImageIsNotConvert extends RuntimeException {
    public JsonImageIsNotConvert() { super("Could not convert json to image object"); }
}
