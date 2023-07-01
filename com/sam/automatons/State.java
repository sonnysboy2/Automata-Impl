package com.sam.automatons;

import java.util.*;

public class State extends AState {

  private List<Transition> transitions;

  public State(final String stateName, final boolean acceptState) {
    super(stateName, acceptState);
    this.transitions = Collections.synchronizedList(new ArrayList<>());
  }
  

  /**
   * Add a transition to the next state.
   * 
   * @param state the state-to-transition-to's stateNum;
   */
  public void addTransition(final char symbol, final String stateName) {
    this.transitions.add(new Transition(symbol, stateName));
  }

  /**
   * overload moment
   */
  public void addTransition(final Transition trans /* lol */) {
    this.transitions.add(trans);
  }

  /**
   * If the symbol given is a transition, return this.to, else return -1.
   */
  public String transition(final char symbol) {
    for (final Transition trans : transitions) {
      if (trans.yesForSymbol(symbol)) {
        return trans.getTo();
      }
    }
    return "";
  }

  public List<Transition> getTransitions() {
    return transitions;

  }

  public String toString() {
    return String.format("State@%d{transitions=%s}", this.hashCode(), this.transitions.toString());
  }

}