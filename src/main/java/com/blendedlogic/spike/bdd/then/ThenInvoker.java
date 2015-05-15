package com.blendedlogic.spike.bdd.then;

import com.blendedlogic.spike.bdd.command.CommandInvoker;

/**
 * Then invoker.
 */
public class ThenInvoker {
    public static int then(final Then... thens) {
        return CommandInvoker.invoke("then", thens);
    }
}
