/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient;

import meteordevelopment.meteorclient.events.packets.PacketEvent;
import meteordevelopment.meteorclient.utils.PostInit;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;

public class TestUtil {
    @PostInit
    public static void init() {
        MeteorClient.EVENT_BUS.subscribe(TestUtil.class);
    }

    @EventHandler
    public static void onPacketSent(PacketEvent.Sent event) {
        if (event.packet instanceof ClickSlotC2SPacket packet) {
            System.out.println("--------------------------------");
            System.out.println("Action Type: " + packet.getActionType());
            System.out.println("Button: " + packet.getButton());
            System.out.println("Slot: " + packet.getSlot());
            System.out.println("Stack: " + packet.getStack());
            System.out.println();
            System.out.println("Affected stacks:");
            packet.getModifiedStacks().forEach((slot, stack) -> {
                System.out.println("Slot: " + slot + ", Stack: " + stack);
            });
        }
    }
}
