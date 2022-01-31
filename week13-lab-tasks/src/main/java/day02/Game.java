package day02;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Game {
    private Map<Player,List<String>> players = new HashMap<>();
    private String solution;

    public Map<Player, List<String>> getPlayers() {
        return players;
    }

    public String getSolution() {
        return solution;
    }

    public void readFile(){
        try(BufferedReader reader = Files.newBufferedReader(Paths.get("src/main/resources/result.txt"))){
            String tmp;
            String tmpKey;
            boolean first=true;
            while (reader.ready()){
                if (first){
                    first=false;
                    solution=reader.readLine();
                }else {
                    tmp = reader.readLine();
                    tmpKey=tmp.substring(0,tmp.indexOf(" "));
                    if(!players.containsKey(new Player(tmpKey))){
                        players.put(new Player(tmpKey),new ArrayList<>());
                    }
                    players.get(new Player(tmpKey)).add(tmp.substring(tmp.indexOf(" ")+1));
                }
            }
            for (Map.Entry<Player, List<String>> entry:players.entrySet()){
                calculatePoints(entry.getKey().getId());
            }
        } catch (IOException e){
            throw new IllegalArgumentException("Can not read file",e);
        }
    }

    private void calculatePoints(String key){
        for(int i = 0;i<solution.length();++i){
            if(players.get(new Player(key)).get(i).equals(solution.substring(i,i+1))){
                players.keySet().stream().filter(player -> player.getId().equals(key))
                        .toList().get(0).addPoints(i+1);
            } else if (!players.get(new Player(key)).get(i).equals("X")) {
                players.keySet().stream().filter(player -> player.getId().equals(key))
                        .toList().get(0).addPoints(-2);
            }
        }
    }

    public Player getWinner() {
        return players.keySet().stream()
                .sorted(Comparator.comparing(Player::getPoints))
                .toList().get(players.size()-1);
    }

    @Override
    public String toString() {
        return "Game{" +
                "players=" + players +
                ", solution='" + solution + '\'' +
                '}';
    }
}
