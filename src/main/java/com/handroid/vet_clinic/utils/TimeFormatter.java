package com.handroid.vet_clinic.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeFormatter {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy");

    public static LocalDateTime timeNow() {
        return LocalDateTime.parse(LocalDateTime.now().format(FORMATTER));
    }
}
