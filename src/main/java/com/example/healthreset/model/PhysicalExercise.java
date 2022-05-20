package com.example.healthreset.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter
@Setter
@Builder
@Entity
public class PhysicalExercise extends Exercise{
}
