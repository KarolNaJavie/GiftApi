package com.example.giftApi.model.common.exception;

public class GiftLimitException extends RuntimeException {
    public GiftLimitException(String message) {
        super(message);
    }
}
