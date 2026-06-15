package com.example.giftApi.model.common.exception;

public class GiftNotPresentInListException extends RuntimeException {
    public GiftNotPresentInListException(String message) {
        super(message);
    }
}
