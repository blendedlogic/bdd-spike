package com.blendedlogic.spike.bdd.command;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * Command invoker tests.
 */
public class CommandInvokeTest {
    @Test
    public void whenNoCommandsToInvoke() {
        final int count = CommandInvoker.invoke("no commands");

        assertThat(count, is(equalTo(0)));
    }

    @Test
    public void whenCommandsToInvoke() {
        final SimpleCommand command = new SimpleCommand();

        final int executedCount = CommandInvoker.invoke("some command", command);

        assertThat(executedCount, is(equalTo(1)));
        assertThat(command.isExecuted(), is(equalTo(true)));
    }

    @Test
    public void whenCommandsThrowsException() {
        final Command exceptionCommand = new Command() {
            @Override
            public void execute()
                    throws Exception {

                throw new Exception("Some exception");
            }
        };

        try {
            CommandInvoker.invoke("some commands, one that throws an exception",
                    new SimpleCommand(),
                    exceptionCommand,
                    new SimpleCommand()
            );

            fail();
        } catch (CommandInvocationException e) {
            assertThat(e.getTotalNumberOfCommandsToExecute(), is(equalTo(3)));
            assertThat(e.getNumberOfCommandsSuccessfullyExecuted(), is(equalTo(1)));
            assertThat(e.getCommandThatThrewException(), is(equalTo(exceptionCommand)));
        }
    }

    public static class SimpleCommand implements Command {
        private boolean executed = false;

        @Override
        public void execute() throws Exception {
            executed = true;
        }

        public boolean isExecuted() {
            return executed;
        }
    }
}
