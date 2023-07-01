import com.sam.automatons.*;
import java.lang.reflect.*;


// my first full OOP project since i got back and first full java project since i got back
class Main {
  public static void main(String[] args) {
    runTests();
  }
  private static void runTests() {
    testShouldAcceptBinaryStringsEndingInZero();
    binaryStringsDivisibleBy3();
  }

// java method names moment
  public static void testShouldAcceptBinaryStringsEndingInZero() {
    Test.describe("First automaton");
    Test.it("Should accept binary strings ending in 0", () ->  {
    DFAutomaton automaton = new DFAutomaton();
    
    State state0 = StateBuilder.begin("s0")
      .addTransition('1', "s1") // 1 -> 1
      .addTransition('0', "s0")
      .isAnAcceptState().end();
    State state1 = StateBuilder
        .begin("s1") // 0 -> 0
        .addTransition('0', "s0")
      .loopback('1').end();
    automaton.setStartState(state0);
    automaton.addState(state1);
    String tape = "101010111001";
    Test.assertNot(automaton.accepts(tape));
    tape += "0";
    Test.assertTrue(automaton.accepts(tape));
    });
  }
  public static void binaryStringsDivisibleBy3() {

    Test.describe("Second automaton");
    DFAutomaton divThree = new DFAutomaton();
    State s0 = StateBuilder
      .begin("s0")
      .loopback('0')
      .isAnAcceptState()
      .addTransition('1', "s1")
      .end();
    divThree.setStartState(s0);
    State s1 = StateBuilder
      .begin("s1")
      .addTransition('1', "s0")
      .addTransition('0', "s2")
      .end();
    State s2 = StateBuilder
      .begin("s2")
      .addTransition('0', "s1")
      .addTransition('1', "s2")
      .end();
    divThree.addState(s1);
    divThree.addState(s2);
    Test.it("Should accept binary strings divisible by 3", () -> {
      Test.assertNot(divThree.accepts("1010"));
      Test.assertTrue(divThree.accepts("1100"));
      Test.it("Random tests", () -> {
        for (int i = 0 ; i < 1000; i++) {

          int rand = (int) ((Math.random() * 3400));
          Test.assertEquals(divThree.accepts(Integer.toBinaryString(rand)), (rand % 3) == 0);
          
        }
      });
    });
  }
}