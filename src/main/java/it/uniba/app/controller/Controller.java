package it.uniba.app.controller;

/**
 * The {@link Controller} interface must be implemented
 * by the Control classes corresponding to each user story.
 * If more than one Control class is used for a single user story,
 * then only the 'main' one needs to implement Controller.
 */

public interface Controller {
    /**
     * Implementations of this method must contain
     * the 'business logic' associated with the corresponding classes.
     *
     * @param args arguments given to the corresponding command.
     */
    void control(String[] args);
}
