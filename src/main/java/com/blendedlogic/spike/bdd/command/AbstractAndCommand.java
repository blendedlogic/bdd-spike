package com.blendedlogic.spike.bdd.command;

/**
 * Abstract and command.
 */
public abstract class AbstractAndCommand implements AndCommand {
    private final Command command;

    public AbstractAndCommand(Command command) {
        this.command = command;
    }

    @Override
    public Command getWrappedCommand() {
        return command;
    }

    @Override
    public void execute()
            throws Exception {

        throw new UnsupportedOperationException("The execute method shouldn't be called directly on an And");
    }
}
