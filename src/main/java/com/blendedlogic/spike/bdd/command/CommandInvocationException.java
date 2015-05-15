package com.blendedlogic.spike.bdd.command;

import static java.lang.String.format;

/**
 * Command invocation exception.
 */
public class CommandInvocationException extends RuntimeException {
    private final int totalNumberOfCommandsToExecute;
    private final int numberOfCommandsSuccessfullyExecuted;
    private final Command commandThatThrewException;

    public CommandInvocationException(final Throwable throwable,
                                      final int totalNumberOfCommandsToExecute,
                                      final int numberOfCommandsSuccessfullyExecuted,
                                      final Command commandThatThrewException) {

        super(createMessage(throwable, totalNumberOfCommandsToExecute,
                        numberOfCommandsSuccessfullyExecuted, commandThatThrewException),
                throwable);

        this.totalNumberOfCommandsToExecute = totalNumberOfCommandsToExecute;
        this.numberOfCommandsSuccessfullyExecuted = numberOfCommandsSuccessfullyExecuted;
        this.commandThatThrewException = commandThatThrewException;
    }

    public int getTotalNumberOfCommandsToExecute() {
        return totalNumberOfCommandsToExecute;
    }

    public int getNumberOfCommandsSuccessfullyExecuted() {
        return numberOfCommandsSuccessfullyExecuted;
    }

    public Command getCommandThatThrewException() {
        return commandThatThrewException;
    }

    private static String createMessage(final Throwable throwable,
                                        final int totalNumberOfCommandsToExecute,
                                        final int numberOfCommandsSuccessfullyExecuted,
                                        final Command commandThatThrewException) {

        return format("Command invocation exception - %d out of %d command(s) were successfully invoked, execution "
                        + "stopped due to this command: '%s' which threw the following exception: %s",
                numberOfCommandsSuccessfullyExecuted, totalNumberOfCommandsToExecute,
                commandThatThrewException, throwable);
    }
}
