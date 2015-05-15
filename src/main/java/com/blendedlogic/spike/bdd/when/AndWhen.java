package com.blendedlogic.spike.bdd.when;

import com.blendedlogic.spike.bdd.command.AbstractAndCommand;

/**
 * And when command - can be used to make syntax read a bit nicer.
 * TODO: there could also be AndGiven and AndThen added later..
 */
public class AndWhen extends AbstractAndCommand implements When {
    private AndWhen(final When when) {
        super(when);
    }

    public static When andWhen(final When when) {
        return new AndWhen(when);
    }
}
