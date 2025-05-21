package com.pratik.restaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Review {

    @Field(type = FieldType.Keyword) 
    private String id;

    @Field(type = FieldType.Text) // Maps the 'content' field to a text field in Elasticsearch
    private String content;

    @Field(type = FieldType.Integer) // Maps the 'rating' field to an integer type in Elasticsearch
    private Integer rating;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second) // Maps the 'datePosted' field to a date field with format "date_hour_minute_second" in Elasticsearch
    private LocalDateTime datePosted;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second) // Maps the 'lastEdited' field to a date field with format "date_hour_minute_second" in Elasticsearch
    private LocalDateTime lastEdited;

    @Field(type = FieldType.Nested) // Maps the 'photos' field as a nested object in Elasticsearch
    private List<Photo> photos = new ArrayList<>();

    @Field(type = FieldType.Nested) // Maps the 'writtenBy' field as a nested object 
    private User writtenBy;
}