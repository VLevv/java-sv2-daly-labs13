package day05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransfersTest {

    @Test
    void testTransfer(){
        Transfers transfers = new Transfers();
        transfers.readFile();
        System.out.println(transfers.getAccounts());
    }
}