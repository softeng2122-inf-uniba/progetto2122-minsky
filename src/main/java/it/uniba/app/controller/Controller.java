package it.uniba.app.controller;

/**
 * L'interfaccia Controller deve essere implementata
 * dalle classi Control relative alle user story.
 * <p>
 * In caso ci siano più classi Control per una singola user story,
 * è sufficiente che solo quella "principale" implementi Controller.
 */

public interface Controller {
    void control(String[] args);
}
