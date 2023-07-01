package com.sam.automatons;

public class Transition {

  private final char symbol;
  private final String to;
  
  public Transition(final char symbol, final String to) {
    this.symbol = symbol;
    this.to = to;
  }

  
  /**
   * I really don't know what else to call this, man
   * 
   * @returns true if this.symbol matches the given symbol.
   */
  public boolean yesForSymbol(final char symbol) {
    return this.symbol == symbol;
  }

  public char getSymbol() {
    return symbol;
  }

  public String getTo() {
    return to;
  }

  public String toString() {
    return String.format("Transition@%d{symbol=%c,to=%d}",hashCode(),symbol,to);
  }
}