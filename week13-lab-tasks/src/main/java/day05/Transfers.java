package day05;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Transfers {
    private Map<Account,Integer> accounts = new TreeMap<>();

    public void readFile(){
        try(Scanner scanner=new Scanner(Paths.get("src/main/resources/transfers.csv"))){
            String[] tmp;
            while(scanner.hasNext()){
                tmp=scanner.nextLine().split(",");
                if(!accounts.containsKey(new Account(tmp[0]))){
                    accounts.put(new Account(tmp[0]),0);
                }
                if(!accounts.containsKey(new Account(tmp[1]))){
                    accounts.put(new Account(tmp[1]),0);
                }
                accounts.put(new Account(tmp[0]),accounts.get(new Account(tmp[0]))-Integer.parseInt(tmp[2]));
                accounts.put(new Account(tmp[1]),accounts.get(new Account(tmp[1]))+Integer.parseInt(tmp[2]));
            }
        }catch (IOException e){
            throw new IllegalArgumentException("Can not read file",e);
        }
    }

    public Map<Account, Integer> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Transfers{" +
                "accounts=" + accounts +
                '}';
    }
}
