package com.rixon.virtualmarket.institution.models;

import com.rixon.virtualmarket.position.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InstitutionPositions {
    private List<Position> positions;

    public InstitutionPositions() {
        this.positions = new ArrayList<>();
    }

    public InstitutionPositions(List<Position> positions) {
        this.positions = positions;
    }

    public List<Position> getPositions() {
        return positions;
    }

    public void addPosition(Position... positions) {
        this.positions.addAll(Arrays.asList(positions));
    }
}
