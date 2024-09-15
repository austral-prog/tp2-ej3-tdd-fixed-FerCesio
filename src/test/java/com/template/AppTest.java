package com.template;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AppTest {

    @Test
    void createAccountTest() {
        App app = new App();
        app.createAccount("Fernando",0);
        app.createAccount("Juan", 5);
        Map<String, Integer> shouldReturn = new HashMap<>();
        shouldReturn.put("Fernando", 0);
        shouldReturn.put("Juan", 5);
        assertEquals(shouldReturn, app.accounts);

    }


    @Test
    void testTransfer() {
        App app = new App();
        app.createAccount("mati",10);
        app.createAccount("juan", 20);
        app.transfer("juan","mati",5);
        assertEquals(15, app.accounts.get("mati"));
        assertEquals(15, app.accounts.get("juan"));
    }

    @Test
    void testTransferWithNegativeNumber(){
        App app = new App();
        app.accounts = Map.of("mati", 10, "juan", 20);
        app.transfer("juan","mati",-5);
        assertEquals(20, app.accounts.get("juan"));
    }

    @Test
    void testDeposit(){
        App app = new App();
        app.createAccount("Fernando",20);
        app.createAccount("Milagros",10);
        app.deposit("Fernando",10);
        app.deposit("Milagros",20);
        assertEquals(30,app.accounts.get("Fernando"));
        assertEquals(30,app.accounts.get("Milagros"));
    }

    @Test
    void testDepositWithNegativeNumber(){
        App app = new App();
        app.createAccount("Fernando",20);
        app.createAccount("Milagros",10);
        app.deposit("Fernando",-10);
        app.deposit("Milagros",-20);
        assertEquals(20,app.accounts.get("Fernando"));
        assertEquals(10,app.accounts.get("Milagros"));
    }

    @Test
    void testDepositToNonExistingAccount(){
        App app = new App();
        app.createAccount("Tomi",20);
        app.createAccount("Cuchu",10);
        app.deposit("Mati",10);
        assertNull(app.accounts.get("Mati"));
    }

    @Test
    void testWithdraw() {
        App app = new App();
        app.createAccount("Celina",20);
        app.createAccount("Guadalupe",10);
        app.withdraw("Guadalupe",10);
        app.withdraw("Celina",5);
        assertEquals(0,app.accounts.get("Guadalupe"));
        assertEquals(15,app.accounts.get("Celina"));
    }

    @Test
    void testWithdrawWithNegativeNumber(){
        App app = new App();
        app.createAccount("Celina",5);
        app.withdraw("Celina",-5);
        assertEquals(5,app.accounts.get("Celina"));
    }

    @Test
    void testWithdrawWithInsufficientFunds(){
        App app = new App();
        app.createAccount("Fernando",20);
        app.withdraw("Fernando",30);
        assertEquals(20,app.accounts.get("Fernando"));
    }

    @Test
    void testTransferWithInsufficientFunds(){
        App app = new App();
        app.createAccount("José",50);
        app.createAccount("María",20);
        app.transfer("José","María",60);
        assertEquals(50,app.accounts.get("José"));
        assertEquals(20,app.accounts.get("María"));
    }

}
