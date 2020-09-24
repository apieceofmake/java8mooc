package com.company;
/**
 * Copyright © 2014, Oracle and/or its affiliates. All rights reserved.
 *
 * JDK 8 MOOC Lesson 3 homework
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class to generate a list of random words
 *
 * @author Simon Ritter (@speakjava)
 */
public class RandomWords {
    private final List<String> sourceWords;
    private static final String WORD_REGEXP = "[- .:,]+";

    /**
     * Constructor
     *
     * @throws IOException If the source words file cannot be read
     */
    public RandomWords() throws IOException {
//        //
//        String filename="words";
//        Path pathToFile = Paths.get(filename);
//        System.out.println(pathToFile.toAbsolutePath());
//        //
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("words"))) {

//          Needed only if we have a plain text file

//            List output = reader.lines()
//                    .flatMap(line -> Stream.of(line.split(WORD_REGEXP)))
//                    .filter(word -> word.length() > 0)
//                    .collect(Collectors.toList());

            sourceWords = reader.lines().collect(Collectors.toList());
            System.out.println("Loaded " + sourceWords.size() + " words");
        }
    }

    /**
     * Create a list of a given size containing random words
     *
     * @param listSize The size of the list to create
     * @return The created list
     */
    public List<String> createList(int listSize) {
        Random rand = new Random();
        List<String> wordList = null; // YOUR CODE HERE

        OptionalInt r = rand.ints().filter(i -> i>0).findAny();

        wordList = rand.ints(listSize, 0, allWords().size())
                .mapToObj(i -> allWords().get(i)).collect(Collectors.toList());
        return wordList;
    }

    /**
     * Return the list of all source words, which cannot be modified
     *
     * @return The unmodifiable list of all source words
     */
    public List<String> allWords() {
        return Collections.unmodifiableList(sourceWords);
    }
}
