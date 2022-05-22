package com.example.healthreset;

import com.example.healthreset.model.MealOfTheDay;
import com.example.healthreset.model.PhysicalExercise;
import com.example.healthreset.model.dto.MealOfTheDayDTO;
import com.example.healthreset.model.dto.PhysicalExerciseDTO;
import com.example.healthreset.repository.PhysicalExerciseRepository;
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
public class PhysicalExerciseServiceTest {

    @InjectMocks
    private PhysicalExerciseService physicalExerciseService;

    @Mock
    private PhysicalExerciseRepository physicalExerciseRepository;

    Dummy dummy = new Dummy();

    @Test
    public void findAllTest(){

        List<PhysicalExercise> expectedList = new ArrayList<>(List.of(dummy.getPhysicalExercise1(), dummy.getPhysicalExercise2(), dummy.getPhysicalExercise3()));

        when(physicalExerciseRepository.findAll()).thenReturn(expectedList);
        List<PhysicalExerciseDTO> list = physicalExerciseService.findAll();

        assertEquals(3, list.size());
        verify(physicalExerciseRepository, times(1)).findAll();
    }



}
