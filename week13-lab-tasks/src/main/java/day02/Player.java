package day02;

import java.util.Objects;

public class Player {
    private String id;
    private Integer points;

    public Player(String id) {
        this.id = id;
        this.points=0;
    }

    public String getId() {
        return id;
    }

    public Integer getPoints() {
        return points;
    }

    public void addPoints(int points){
        this.points+=points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return id.equals(player.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Player{" +
                "id='" + id + '\'' +
                ", points=" + points +
                '}';
    }
}
