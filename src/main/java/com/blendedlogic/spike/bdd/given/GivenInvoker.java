package com.blendedlogic.spike.bdd.given;

import com.blendedlogic.spike.bdd.command.CommandInvoker;

/**
 * Given invoker.
 */
public class GivenInvoker {
    public static int given(final Given... givens) {
        return CommandInvoker.invoke("given", givens);
    }
}
