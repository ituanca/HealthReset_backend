package com.example.healthreset;

import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.TypeOfExercise;
import com.example.healthreset.model.dto.MealOfTheDayDTO;
import com.example.healthreset.model.dto.TypeOfExerciseDTO;
import com.example.healthreset.repository.TypeOfExerciseRepository;
import com.example.healthreset.service.TypeOfExerciseService;
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
public class TypeOfExerciseServiceTest {
    @InjectMocks
    private TypeOfExerciseService typeOfExerciseService;

    @Mock
    private TypeOfExerciseRepository typeOfExerciseRepository;

    Dummy dummy = new Dummy();

    @Test
    public void findAllTest(){

        List<TypeOfExercise> expectedList = new ArrayList<>(List.of(dummy.getTypeOfExercise1(), dummy.getTypeOfExercise2(), dummy.getTypeOfExercise3()));

        when(typeOfExerciseRepository.findAll()).thenReturn(expectedList);
        List<TypeOfExerciseDTO> list = typeOfExerciseService.findAll();

        assertEquals(3, list.size());
        verify(typeOfExerciseRepository, times(1)).findAll();
    }
}
