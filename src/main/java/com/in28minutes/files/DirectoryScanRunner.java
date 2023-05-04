package com.in28minutes.files;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class DirectoryScanRunner
{
    public static void main( String[] args ) throws IOException {
        Path currentDirectory = Paths.get(".");
        //Files.list(currentDirectory).forEach(System.out::println);

        Predicate<? super Path> predicate = path -> String.valueOf(path).contains(".java");
//        Files.walk(currentDirectory,7).filter(predicate).forEach(System.out::println);

        BiPredicate<Path, BasicFileAttributes> javaMatcher = (path,attributes) -> String.valueOf(path).contains(".java");
        BiPredicate<Path, BasicFileAttributes> directoryMatcher = (path,attributes) -> attributes.isDirectory();

//        Files.find(currentDirectory,7, javaMatcher).forEach(System.out::println);
        Files.find(currentDirectory,7, directoryMatcher).forEach(System.out::println);
    }
}
