package org.firstinspires.ftc.teamcode.excutil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class EncodedPath  {

    private List<Predicate<EncodedPath>[]> actions = new ArrayList<>();
    private Predicate<EncodedPath>[] currentlyRunning = new Predicate[0];

    public EncodedPath until(Predicate<EncodedPath> p) {
        actions.add(new Predicate[] {p});
        return this;
    }

    public EncodedPath until(Predicate<EncodedPath>... ps) {
        actions.add(ps);
        return this;
    }

    private boolean playing = false;

    public int tickNumber = 0;

    public boolean firstTick() {
        return tickNumber == 0;
    }
    int indexIntoActions = 0;

    public void tick() {
        if (!playing) return;

        boolean next = true;
        for (Predicate p : currentlyRunning) {
            next = next && p.test(this);
        }

        if (next) {
            currentlyRunning = actions.get(indexIntoActions);
            indexIntoActions++;
            tickNumber = 0;
        } else {
            tickNumber++;
        }

        if (indexIntoActions == actions.size()) {
            stop();
        }
    }

    public void play() {
        currentlyRunning = new Predicate[0];
        indexIntoActions = 0;
        playing = true;
    }

    public void stop() {
        playing = false;
    }

}
