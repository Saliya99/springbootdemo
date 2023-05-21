package com.ictec.springbootdemo;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

public class Sample {
    public static void main(String[] args) {
        UUID uuid = Generators.timeBasedGenerator().generate();

        System.out.println("UUID: " + uuid.toString());
    }
}
