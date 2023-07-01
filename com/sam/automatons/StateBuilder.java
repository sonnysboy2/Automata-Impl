package com.sam.automatons;

/*
just an easy way to build states incase you wanted one

Begin with <code> StateBuilder.begin() </code> and returns the state with <code> StateBuilder#end() </code>
 */
public class StateBuilder {

  private State state;

  private StateBuilder() {
  }

  // your MOM can instantiate this class.
  private StateBuilder(String name, boolean accept) {
    this.state = new State(name, accept);
  }

  /**
   * Begin to build
   */
  public static StateBuilder begin(String name) {
    return begin(name, false);
  }

  public static StateBuilder begin(String name, boolean acceptState) {
    return new StateBuilder(name, acceptState);
  }

  public StateBuilder addTransition(final char symbol,  final String stateName) {
    this.state.addTransition(symbol,stateName );
    return this;
  }
  

  public StateBuilder addTransition(Transition trans) {
    this.state.addTransition(trans);
    return this;
  }
/**
  Shorthand for addTransition(symbol, state.stateNum)
*/
  public StateBuilder loopback(final char symbol) {
    addTransition(symbol, this.state.getStateName());
    return this;
  }
  
  /**
   * Declares this state an accept state.
   */
  public StateBuilder isAnAcceptState() {
    this.state.setAcceptFlag(true);
    return this;
  }

  public State end() {
    return state;
  }

}
