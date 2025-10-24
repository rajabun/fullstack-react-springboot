package com.example.beans;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Printing Hello from Component Vehicle Bean");
    }

    /*
    @PostConstruct ini mirip viewDidLoad di iOS atau onCreate di android,
    dipanggil sekali waktu init pertama kali, setelan bean selesai dibuat,
    dan setelah semua dependencies di-inject.
    kalo gak pake @PostConstruct, waktu bean ini dipanggil/dibuat akan null hasilnya.
     */

    @PostConstruct
    public void initialize() {
        this.name = "Honda";
    }
}
