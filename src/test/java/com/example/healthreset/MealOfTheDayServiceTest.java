package com.example.healthreset;

import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.dto.MealOfTheDayDTO;
import com.example.healthreset.repository.MealOfTheDayRepository;
import com.example.healthreset.repository.PhysicalExerciseRepository;
import com.example.healthreset.service.MealOfTheDayService;
import com.example.healthreset.service.PhysicalExerciseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MealOfTheDayServiceTest {
    @InjectMocks
    private MealOfTheDayService mealOfTheDayService;

    @Mock
    private MealOfTheDayRepository mealOfTheDayRepository;

    Dummy dummy = new Dummy();

    @Test
    public void findAllTest(){

        List<MealOfTheDay> expectedList = new ArrayList<>(List.of(dummy.getMealOfTheDay1(), dummy.getMealOfTheDay2(), dummy.getMealOfTheDay3()));

        when(mealOfTheDayRepository.findAll()).thenReturn(expectedList);
        List<MealOfTheDayDTO> list = mealOfTheDayService.findAll();

        assertEquals(3, list.size());
        verify(mealOfTheDayRepository, times(1)).findAll();
    }

}
