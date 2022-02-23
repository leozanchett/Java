package com.book.dto;

import lombok.Data;

@Data
public class TaskDto {
    private long id;
    private String name;
    private String description;
    private String createdDate;
}
