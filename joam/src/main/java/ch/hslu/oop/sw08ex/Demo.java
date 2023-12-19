/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.hslu.oop.sw08ex;

import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

/**
 *
 * @author JoëlAmmann
 */
public class Demo {
    private List<String> arr = new ArrayList<>();

    public Demo() {
    }

    public Optional<List<String>> getArr() {
        if (arr.size() > 0) {
            return Optional.of(arr);
        } else {
            return Optional.empty();
        }
    }

    public void addSomething(){
        this.arr.add("Something");
    }

}
