package com.rivmt.kbd.hangulkeyboard.ime;

public abstract class IMEMaster {

    public IMEInfoHandler mInfo = new IMEInfoHandler();
    public char mBlankWord = '0';

    /*
        This method check the keycode that controlled by IME
     */
    public abstract boolean checkCode(int i);

    public abstract void createLetter(int i, boolean cont);

    public abstract void deleteOrder();

    public abstract void resetIME();
}
