package statemachine;

import com.github.oxo42.stateless4j.StateMachineConfig;
import com.github.oxo42.stateless4j.delegates.Action;
/**
 * Created by mrpon on 05.10.2016.
 */
public class MyMachine {
    StateMachineConfig<State, Trigger> config = new StateMachineConfig<State, Trigger>();

    public MyMachine(){
        config.configure(State.L1).permit(Trigger.L1passed, State.L2);
        config.configure(State.L2).permit(Trigger.L2passed, State.Milling);
        config.configure(State.Milling).permit(Trigger.Milled, State.L3);
        config.configure(State.L3).permit(Trigger.L3passed, State.Drilling);
        config.configure(State.Drilling).permit(Trigger.Drilled, State.L4);
        config.configure(State.L4).permit(Trigger.L4passed, State.L5);
        config.configure(State.L4).permit(Trigger.L5passed, State.L1);
    }

    public StateMachineConfig<State, Trigger> getConfig() {
        return config;
    }
}
