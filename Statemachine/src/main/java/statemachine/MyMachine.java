package statemachine;

import com.github.oxo42.stateless4j.StateMachine;
import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action;
/**
 * Created by mrpon on 05.10.2016.
 */
public class MyMachine {
    static StateMachineConfig<State, Trigger> config = new StateMachineConfig<State, Trigger>();
    static StateMachine<State, Trigger> stateMachine = null;

    public MyMachine(){
        config.configure(State.q0).permit(Trigger.L1passed, State.q1);
        config.configure(State.q1).permit(Trigger.L2passed, State.q2);
        config.configure(State.q2).permit(Trigger.MillingON, State.q3);
        config.configure(State.q3).permit(Trigger.MillingOFF, State.q4);
        config.configure(State.q4).permit(Trigger.L3passed, State.q5);
        config.configure(State.q5).permit(Trigger.DrillingON, State.q6);
        config.configure(State.q6).permit(Trigger.DrillingOFF, State.q7);
        config.configure(State.q7).permit(Trigger.L4passed, State.q8);
        config.configure(State.q8).permit(Trigger.L5passed, State.q9);
    }

    public StateMachineConfig<State, Trigger> getConfig() {
        return config;
    }

    public static void main(String[] args) {
        stateMachine = new StateMachine<State, Trigger>(State.q0, config);
        new MyMachine();
        stateMachine.fire(Trigger.L1passed);
        System.out.println(State.q1);
        System.out.println(stateMachine.getState());
        System.out.println(stateMachine.getState().equals(State.q1));
    }
}
