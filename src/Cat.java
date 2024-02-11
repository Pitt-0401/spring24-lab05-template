/*
 * Created on 2024-02-11
 *
 * Copyright (c) 2024 Nadine von Frankenberg
 */

public class Cat {
    private String name;
    private int age;
    private String fur;

    private Story funnyStory;
    private Owner owner;

    // Constructors
    Cat(String name, String fur, int age) {
        this.name = name;
        this.fur = fur;
        this.age = age;
    }

    Cat(String name, String fur, int age, Owner owner) {
        this.name = name;
        this.fur = fur;
        this.age = age;
        this.owner = owner;
    }

    Cat(String name, String fur, int age, Owner owner, Story funnyStory) {
        this.name = name;
        this.fur = fur;
        this.age = age;
        this.owner = owner;
        this.funnyStory = funnyStory;
    }

    // Getters & Setters
    public String getName() {
        return this.name;
    }

    public String getFur() {
        return this.fur;
    }

    public int getAge() {
        return this.age;
    }

    public Owner getOwner() {
        return owner;
    }

    public Story getFunnyStory() {
        return funnyStory;
    }

    public void setFunnyStory(Story funnyStory) {
        this.funnyStory = funnyStory;
    }

    // Main functionality
    public void adopt(Owner owner) {
        // We will only allow an owner to adopt a cat if the cat does not have an owner
        // Meaning if the owner object is null or the name is an empty string
        if (this.owner == null || this.owner.getName().equals("")) {
            owner.setCat(this);
            this.owner = owner;
        } else {
            System.out.println("This cat already has an owner: " + this.owner.getName());
        }
    }
}
