package com.namelessmc.java_api.integrations;

import com.google.gson.JsonObject;


public class DetailedDiscordIntegrationData extends DetailedIntegrationData implements IDiscordIntegrationData {

    private final long idLong;

    public DetailedDiscordIntegrationData(JsonObject json) {
        super(json);
        this.idLong = Integer.parseInt(this.getIdentifier());
    }

    @Override
    public long getIdLong() {
        return this.idLong;
    }
}
