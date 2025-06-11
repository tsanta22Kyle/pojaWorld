package com.hei.project.endpoint.event.consumer.model;

import com.hei.project.PojaGenerated;
import com.hei.project.endpoint.event.model.PojaEvent;

@PojaGenerated
public record TypedEvent(String typeName, PojaEvent payload) {}
