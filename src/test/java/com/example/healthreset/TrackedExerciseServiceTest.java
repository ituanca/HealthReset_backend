package com.example.healthreset;

import com.example.healthreset.model.TrackedExercise;
import com.example.healthreset.model.dto.TrackedExerciseDTO;
import com.example.healthreset.repository.TrackedExerciseRepository;
import com.example.healthreset.service.TrackedExerciseService;
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
public class TrackedExerciseServiceTest {

    @InjectMocks
    private TrackedExerciseService trackedExerciseService;

    @Mock
    private TrackedExerciseRepository trackedExerciseRepository;

    Dummy dummy = new Dummy();

    @Test
    public void findAllTest(){

    }

}
