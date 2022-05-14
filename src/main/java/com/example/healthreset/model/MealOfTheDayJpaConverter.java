package com.example.healthreset.model;

import com.example.healthreset.model.enumClasses.MealOfTheDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MealOfTheDayJpaConverter implements AttributeConverter<MealOfTheDay, String> {

    @Override
    public String convertToDatabaseColumn(MealOfTheDay mealOfTheDay) {  // JPA uses this method when saving entities in a database
        if(mealOfTheDay == null){
            return null;
        }
        return mealOfTheDay.toString();
    }

    @Override
    public MealOfTheDay convertToEntityAttribute(String s) {  //  It maps between the value stored in a database and the Java type in the corresponding entity attribute.
        if(s == null){
            return null;
        }
        try{
            return MealOfTheDay.valueOf(s);
        } catch (IllegalArgumentException e){
            return null;
        }
    }

}
