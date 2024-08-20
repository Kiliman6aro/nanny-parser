package ua.pp.hophey.utils;

public class PhoneNumberCountryFormat {

    public static String toUkraine(String phoneNumber){
        String digitsOnly = phoneNumber.replaceAll("\\D", "");
        if(digitsOnly.startsWith("380")){
            digitsOnly = "+"+digitsOnly;
        }

        if(digitsOnly.startsWith("0")){
            digitsOnly = "+38"+digitsOnly;
        }

        if(digitsOnly.startsWith("80")){
            digitsOnly = "+3"+digitsOnly;
        }

        if(digitsOnly.startsWith("+80")){
            digitsOnly = digitsOnly.replaceFirst("\\+80", "+380");
        }

        if(digitsOnly.startsWith("+0")){
            digitsOnly = digitsOnly.replaceFirst("\\+0", "+380");
        }

        return digitsOnly;
    }
}
