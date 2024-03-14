package com.study.library.exception;

public class SavaException extends RuntimeException{

    public SavaException() {
        super("데이터 저장 오류");
    }
}
