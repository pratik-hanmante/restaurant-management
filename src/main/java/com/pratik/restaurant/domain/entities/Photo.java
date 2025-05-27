package com.pratik.restaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder; 
import lombok.Data;
import lombok.NoArgsConstructor; 
import org.springframework.data.elasticsearch.annotations.DateFormat; // Importing Elasticsearch DateFormat 
import org.springframework.data.elasticsearch.annotations.Field; // Annotation to define mapping for a field in Elasticsearch
import org.springframework.data.elasticsearch.annotations.FieldType; // Enum to specify the type of a field in Elasticsearch

import java.time.LocalDate; // Importing LocalDate for date representation

/**
 * Represents a photo entity with metadata for Elasticsearch.
 */
@Data // Lombok annotation to generate boilerplate code (getters, setters, etc.)
@AllArgsConstructor // Lombok annotation to generate a constructor with all fields
@NoArgsConstructor // Lombok annotation to generate a no-args constructor
@Builder // Lombok annotation to enable the builder pattern
public class Photo {

    @Field(type = FieldType.Keyword) // Maps this field to a keyword field in Elasticsearch for exact matches
    private String url; // The URL of the photo

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second) // Maps this field to a date field in Elasticsearch with a specific format
    private LocalDate uploadDate; // The date when the photo was uploaded
}