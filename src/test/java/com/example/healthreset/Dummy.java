package com.example.healthreset;

import com.example.healthreset.model.*;
import com.example.healthreset.model.dto.UserDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dummy {

    // admin

    Admin expectedAdmin = new Admin(
            "admin1@yahoo.com",
            "admin1",
            "$2a$10$f0WE0MRB8yNTUF8zy4FfTuKUzp18is.BbuuXdr/I06ADlDGNleCXi");
    UserDTO nonExistentUsernameAdminDTO = new UserDTO(
            "admin1@yahoo.com",
            "admin1",
            "$2a$10$f0WE0MRB8yNTUF8zy4FfTuKUzp18is.BbuuXdr/I06ADlDGNleCXi");
    UserDTO incorrectPasswordExistentAdminDTO = new UserDTO(
            "admin1@yahoo.com",
            "admin1",
            "$2a$10$f0WE0MRB8yNTUF8zy4FfTuKUzp18is.BbuuXdr/I06ADlDGNleCXi");
    UserDTO existentAdminDTO = new UserDTO(
            "admin1@yahoo.com",
            "admin1",
            "$2a$10$f0WE0MRB8yNTUF8zy4FfTuKUzp18is.BbuuXdr/I06ADlDGNleCXi");
    Admin newAdmin = new Admin(
            "admin10@yahoo.com",
            "admin10",
            "CVSDEFGEWG43dcsaf");
    Admin newAdminInvalidEmail = new Admin("voila@", "adminVoila", "CVSDEFGEWG43dcsaf");

    // regular user

    RegularUser expectedRegularUser = new RegularUser(
            "Itu Anca",
            "ancaitu12@gmail.com",
            "ancaitu12",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC"
            );

    RegularUser newRegularUser = new RegularUser(
            "Itu Anca",
            "ancaitu12@gmail.com",
            "ancaitu12",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO newRegularUserDTO = new UserDTO(
            "Cristina Cozma",
            "cristinaCozma@gmail.com",
            "cristinaCozma",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO existentRegularUserDTO = new UserDTO(
            "Marius Cozma",
            "mariusCozma@gmail.com",
            "mariusCozma",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO newRegularUserDTOExistentEmail = new UserDTO(
            "Dorina Cantor",
            "ancaitu12@gmail.com",
            "dorinaCantor",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO newRegularUserDTOInvalidEmail = new UserDTO(
            "Rat Larisa",
            "ratlarisa",
            "larisaRat",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO nonExistentUsernameRegularUserDTO = new UserDTO(
            "Dorina Cantor",
            "ancaitu12@gmail.com",
            "dorinaC",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC"
    );

    UserDTO incorrectPasswordExistentRegularUserDTO = new UserDTO(
            "Dorina Cantor",
            "dorinaCantor@yahoo.com",
            "dorinaCantor",
            "i87t6rf5dcvbhnjk"
    );

    // specialist

    Specialist expectedSpecialist = new Specialist(
            "Carmen Bruma",
            "carmenBruma@yahoo.com",
            "carmenBruma",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC"
    );

    RegularUser newSpecialist = new RegularUser(
            "Itu Anca",
            "ancaitu12@gmail.com",
            "ancaitu12",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO newSpecialistDTO = new UserDTO(
            "Cristina Cozma",
            "cristinaCozma@gmail.com",
            "cristinaCozma",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO existentSpecialistDTO = new UserDTO(
            "Carmen Bruma",
            "carmenBruma@yahoo.com",
            "carmenBruma",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO newSpecialistDTOExistentEmail = new UserDTO(
            "Dorina Cantor",
            "carmenBruma@yahoo.com",
            "dorinaCantor",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO newSpecialistDTOInvalidEmail = new UserDTO(
            "Rat Larisa",
            "ratlarisa",
            "larisaRat",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC");

    UserDTO nonExistentUsernameSpecialistDTO = new UserDTO(
            "Dorina Cantor",
            "ancaitu12@gmail.com",
            "dorinaC",
            "$2a$10$EF14wGNJF8tfDO74hXJzjO/HrIxBKABV9aplfE73KvyZ1oOkuX.HC"
    );

    UserDTO incorrectPasswordExistentSpecialistDTO = new UserDTO(
            "Carmen Bruma",
            "carmenBruma@yahoo.com",
            "carmenBruma",
            "dnfvberivcer"
    );

    // meal of the day

    MealOfTheDay mealOfTheDay1 = new MealOfTheDay("Breakfast");
    MealOfTheDay mealOfTheDay2 = new MealOfTheDay("Lunch");
    MealOfTheDay mealOfTheDay3 = new MealOfTheDay("Dinner");

    // type of exercise

    TypeOfExercise typeOfExercise1 = new TypeOfExercise("Cardio");
    TypeOfExercise typeOfExercise2 = new TypeOfExercise("Strength");
    TypeOfExercise typeOfExercise3 = new TypeOfExercise("Stretching");

    // physical exercise

    PhysicalExercise physicalExercise1 = new PhysicalExercise("sit-ups", 10, typeOfExercise1);
    PhysicalExercise physicalExercise2 = new PhysicalExercise("running", 5, typeOfExercise2);
    PhysicalExercise physicalExercise3 = new PhysicalExercise("plank", 7, typeOfExercise3);

    // tracked exercise

    TrackedExercise trackedExercise1 = new TrackedExercise(
            "sit-ups",
            10,
            typeOfExercise1,
            30);
    TrackedExercise trackedExercise2 = new TrackedExercise(
            "running",
            5,
            typeOfExercise2,
            60);
    TrackedExercise trackedExercise3 = new TrackedExercise(
            "plank",
            7,
            typeOfExercise3,
            10);



}
