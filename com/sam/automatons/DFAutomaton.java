package com.sam.automatons;

import java.util.*;

public class DFAutomaton extends AMachine {

  public boolean accepts(String tape) {

    this.currentState = this.startState;

    final var symbols = tape.toCharArray(); // i know about String#chars just don't want to use it (iirc this is also
                                            // more efficient)

    for (final char symbol : symbols) {

      final String next = this.currentState.transition(symbol);
      if (next.equals("")) {
        System.err
            .println("Because im nice i didn't make hanging DFAs throw exceptions, but it does NOT accept " + tape);
        return false;
      }
      this.currentState = this.getState(next);
    }
    return this.currentState.isAcceptState();
  }

  public String toString() {
    return String.format("DFAutomaton@%d{startState=%s,currentState=%s,states=%s}", hashCode(), this.startState,
        this.currentState, this.getStates());
  }

}