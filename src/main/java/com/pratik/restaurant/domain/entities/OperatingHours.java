package com.pratik.restaurant.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperatingHours {

    //these instances will store the opening and closing time for the whole week

    @Field(type = FieldType.Nested)
    private TimeRange monday;

    @Field(type = FieldType.Nested)
    private TimeRange tuesday;

    @Field(type = FieldType.Nested)
    private TimeRange wednesday;

    @Field(type = FieldType.Nested)
    private TimeRange thursday;

    @Field(type = FieldType.Nested)
    private TimeRange friday;

    @Field(type = FieldType.Nested)
    private TimeRange saturday;

    @Field(type = FieldType.Nested)
    private TimeRange sunday;
}
