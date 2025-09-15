package org.example;

public class StringCaseChanger implements StringTransformer{
    @Override
    public void execute(StringDrink drink) {
        String str = drink.getText();
        String new_str = "";
        char c;

        for (int i = 0; i < str.length(); i++){
            c = str.charAt(i);
            if (Character.isLowerCase(c)) {new_str += Character.toUpperCase(c);}
            else if (Character.isUpperCase(c)) {new_str += Character.toLowerCase(c);}
        }
        drink.setText(new_str);
    }
}
