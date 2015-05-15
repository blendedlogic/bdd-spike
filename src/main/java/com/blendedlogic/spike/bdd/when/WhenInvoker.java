package com.blendedlogic.spike.bdd.when;

import com.blendedlogic.spike.bdd.command.CommandInvoker;

/**
 * When invoker.
 */
public class WhenInvoker {
    public static int when(final When... whens) {
        return CommandInvoker.invoke("when", whens);
    }
}
