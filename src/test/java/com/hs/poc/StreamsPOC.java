package com.hs.poc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPOC {
    public static void main(String[] args) throws IOException {
        Stream<String> stream = Files.lines(Paths.get("/Users/hemasundar/Downloads/iservice_testautomation/src/main/resources/pageObjects/Mobile/IOS/Login Page.spec"));

        String[] currentLocator = stream.filter((str) -> !str.startsWith("=="))
                .filter((str) -> !str.startsWith("#"))
                .filter((str) -> !str.trim().equalsIgnoreCase(""))
                .filter((str) -> !str.startsWith("Page Title:"))
                .map(str -> str.replaceAll("[\\s]+", " "))
                .map(str -> str.split(" ", 3))
                .filter(str -> str[0].equalsIgnoreCase("text_accountMissingError"))
                .findFirst()
                .get();

        System.out.println(currentLocator[0] + "\n" + currentLocator[1] + "\n" + currentLocator[2]);

    }
}
