package com.blendedlogic.spike.bdd.command;

/**
 * And command.
 */
public interface AndCommand extends Command {
    Command getWrappedCommand();
}
