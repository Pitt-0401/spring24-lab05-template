/*
 * Created on 2024-02-11
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

import java.util.Random;

/*
 * NO NEED TO TOUCH THIS FILE
 */
public class Story {
    private String title;
    private String description;
    private int hilarityScore = 0;

    public Story(String title, String description) {
        this.title = title;
        this.description = description;

        generateHilarityScore();
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public int getHilarityScore() {
        return this.hilarityScore;
    }

    private void generateHilarityScore() {
        Random random = new Random();
        this.hilarityScore = random.nextInt(10);
    }

    @Override
    public String toString() {
        String message = "";
        if (!this.title.equals("")) {
            message = "Title: " + title + "\n";
        } else {
            message = "Story: ";
        }
        if (!this.description.equals("")) {
            message = message.concat(description);
            message = message.concat("\n-- Hilarity: " + hilarityScore);
        } else {
            message = "No story to share.";
        }

        return message;
    }
}
