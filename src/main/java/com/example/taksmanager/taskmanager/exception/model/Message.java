package com.example.taksmanager.taskmanager.exception.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class Message {
    private String message;
    private int code;
    private LocalDate date;
}
