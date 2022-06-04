package it.uniba.app.controller;

/**
 * The {@code Controller} interface must be implemented
 * by the Control classes corresponding to each user story.
 * If more than one Control class is used for a single user story,
 * then only the 'main' one needs to implement Controller.
 */

public interface Controller {
    void control(String[] args);
}
