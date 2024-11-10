package com.example.taksmanager.taskmanager.model;

import com.example.taksmanager.taskmanager.utils.StatutTache;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private StatutTache statut;

    @Transient
    private Period periode;

    @Transient
    private Duration duration;
    @Column(name = "start_date")
    private LocalDateTime startdate;


    @Column(name = "time")
    private String time;




    @PostLoad
    public void initTemps() {
        if (time != null) {
            if (time.startsWith("P")) {
                this.periode = Period.parse(time);
            } else if (time.startsWith("PT")) {
                this.duration = Duration.parse(time);
            }
        }
    }
}