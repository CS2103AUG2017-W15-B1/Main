package seedu.address.logic.autocomplete;

import java.util.LinkedList;
import java.util.List;

import seedu.address.logic.parser.AutoCompleteCommandParser;

/**
 * Stores the possible autocomplete options.
 */
public class AutoCompletePossibilities {
    private List<String> possibilities;
    private final AutoCompleteCommandParser commandParser;

    /** Default constructor */
    public AutoCompletePossibilities() {
        possibilities = new LinkedList<String>();
        commandParser = new AutoCompleteCommandParser();
    }

    /** Generates a list of possible autocomplete options based on an incomplete user input */
    public void updatePossibilities(String stub) {
        possibilities = commandParser.parseForCommands(stub);
    }

    public List<String> getPossibilities() {
        return possibilities;
    }
}