package me.elvira.sockswarehouseapp.model;

public enum Size {
    SIZE36 (36),
    SIZE37 (37),
    SIZE38 (38),
    SIZE39 (39),
    SIZE40 (40),
    SIZE41 (41),
    SIZE42 (42),
    SIZE43 (43),
    SIZE44 (44),
    SIZE45 (45);

    private final int size;

    Size(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "size=" + size;
    }
}
