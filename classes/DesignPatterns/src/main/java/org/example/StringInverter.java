package org.example;

import java.lang.*;
import java.io.*;
import java.util.*;

public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String inv_str = new StringBuilder(drink.getText()).reverse().toString();
        drink.setText(inv_str);
    }
}
