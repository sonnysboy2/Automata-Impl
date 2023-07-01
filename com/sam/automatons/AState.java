package com.sam.automatons;

import java.util.List;

public abstract class AState {

  private String stateName; // for the machine to know what state this is.

  private boolean accept;

  public AState(final String stateName) {
    this(stateName, false);
  }

  public AState(final String stateName,
      final boolean acceptState) {
    this.stateName = stateName;
    this.accept = acceptState;
  }

  public String getStateName() {
    return this.stateName;
  }

  /**
   * Transitions of this state object
   */
  public abstract List<? extends Transition> getTransitions();

  public boolean isAcceptState() {
    return this.accept;
  }

  /**
   * You really should not use this you have no reason to you big dummy
   */
  public void setAcceptFlag(boolean flag) {
    this.accept = flag;
  }
}