package day05;

import java.util.Comparator;
import java.util.Objects;

public class Account implements Comparable<Account> {
    private String id;

    public Account(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public int compareTo(Account o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
