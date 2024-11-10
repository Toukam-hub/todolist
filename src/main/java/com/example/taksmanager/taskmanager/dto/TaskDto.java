package com.example.taksmanager.taskmanager.dto;

import com.example.taksmanager.taskmanager.utils.StatutTache;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;

    private String title;
    private String description;
    private StatutTache statut;
    private Period periode;
    private LocalDateTime startdate;
    private Duration duration;
}
