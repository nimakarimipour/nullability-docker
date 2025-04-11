package com.namelessmc.java_api.modules.websend;

import org.checkerframework.checker.index.qual.Positive;
import org.checkerframework.checker.nullness.qual.NonNull;

public class WebsendCommand {

    @Positive
    private final int id;

    private final String commandLine;

    public WebsendCommand(@Positive final int id, final String commandLine) {
        this.id = id;
        this.commandLine = commandLine;
    }

    @Positive
    public int getId() {
        return id;
    }

    public String getCommandLine() {
        return this.commandLine;
    }
}
