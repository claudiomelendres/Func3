package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        Arrays.asList(String.join(" ", Files.readAllLines(Paths.get(args[0])))
                .split(" ")).parallelStream().sorted().filter(s -> !s.equals(""))
                .collect(Collectors.toConcurrentMap(w -> w, w -> 1, Integer::sum))
                .forEach((s,t)->{
                    System.out.println(s+'='+t);
                });
    }
}
