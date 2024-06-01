package com.project.notifications.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private String text;
    private String to;
}