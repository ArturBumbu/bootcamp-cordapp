package java_bootcamp;

import net.corda.core.contracts.CommandData;
import net.corda.core.contracts.Contract;
import net.corda.core.transactions.LedgerTransaction;
import org.jetbrains.annotations.NotNull;

import static net.corda.core.contracts.ContractsDSL.requireThat;

/* Our contract, governing how our state will evolve over time.
 * See src/main/java/examples/ArtContract.java for an example. */
public class TokenContract implements Contract {
    public static String ID = "java_bootcamp.TokenContract";

    @Override
    public void verify(@NotNull LedgerTransaction tx) throws IllegalArgumentException {
//        The transaction has no input states
        if (tx.getInputStates().size() != 0) throw new IllegalArgumentException("The transaction should have no input states");
//        The transaction has one output state
        if (tx.getOutputStates().size() != 1) throw new IllegalArgumentException("The transaction should have one output state");
//        The transaction has one command
        if (tx.getCommands().size() != 1) throw new IllegalArgumentException("The transaction should have one command");
//        The output state is a TokenState
        if (!(tx.getOutputStates().get(0) instanceof TokenState)) throw new IllegalArgumentException("The output state should be a TokenState");
//        The output state has a positive amount
//        The command is an Issue command
//        The command lists the TokenState's issuer as a required signer
    }

    public interface Commands extends CommandData {
        class Issue implements Commands { }
    }
}