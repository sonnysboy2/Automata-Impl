package com.sam.automatons;

import java.util.*;

public abstract class AMachine {

  /**
   * Holds <stateName, State>.
   * it's a map to make retrieval O(1).
   */
  private final Map<String, State> states;

  protected State startState;
  protected State currentState;

  public AMachine() {
    this.states = Collections.synchronizedMap(new HashMap<String, State>());
    this.startState = this.currentState = null;
  }
  

  /**
   * @returns True if the machine accepts this string.
   */
  public abstract boolean accepts(String string);

  public Map<String, State> getStates() {
    return this.states;
  }

  /**
   * Add a state to the machine.
   */
  public void addState(State state) {
    String name = state.getStateName();
    if (states.containsKey(name))
      throw new RuntimeException("State number " + name + " already inside machine.");
    this.states.put(name, state);
  }

  public void setStartState(State state) {
    if (this.startState != null)
      throw new RuntimeException("Start state should be null if you're setting it");
    if (this.currentState != null)
      throw new RuntimeException("you should not be updating the start state while the machine is running you lunatic");
    if (!this.states.containsValue(state)) addState(state);
    this.startState = state;
  }

  protected State getState(String state) {
    return states.get(state);
  }

}