package com.blendedlogic.spike.bdd.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static humanize.Humanize.decamelize;

/**
 * Command invoker.
 */
public class CommandInvoker {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommandInvoker.class);

    public static int invoke(final String description,
                             final Command... commands)
            throws CommandInvocationException {

        LOGGER.debug("There are {} '{}' command(s) to invoke", commands.length, description);

        int successfullyExecutedCount = 0;
        Command commandToBeExecuted = null;

        try {
            for (final Command command : commands) {
                if (command instanceof AndCommand) {
                    final AndCommand andCommand = (AndCommand) command;

                    commandToBeExecuted = andCommand.getWrappedCommand();
                } else {
                    commandToBeExecuted = command;
                }

                final String commandName = commandToBeExecuted.getClass().getSimpleName();
                final String sentence = decamelize(commandName).toLowerCase();

                LOGGER.debug("{}) '{}' will be invoked", successfullyExecutedCount + 1, sentence);

                commandToBeExecuted.execute();
                successfullyExecutedCount++;
            }
        } catch (Exception e) {
            throw new CommandInvocationException(e, commands.length, successfullyExecutedCount, commandToBeExecuted);
        }

        return successfullyExecutedCount;
    }
}
