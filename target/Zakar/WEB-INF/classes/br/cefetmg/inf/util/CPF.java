package br.cefetmg.inf.util;

public final class CPF {

    private CPF () {
        
    }
    
    public static boolean ehValido(long cpf){
        Long cpfConverter = new Long(cpf);
        String CPF = cpfConverter.toString();
        if (CPF.length() != 11 ||
                CPF.equals("00000000000") ||
                CPF.equals("11111111111") ||
                CPF.equals("22222222222") ||
                CPF.equals("33333333333") ||
                CPF.equals("44444444444") ||
                CPF.equals("55555555555") ||
                CPF.equals("66666666666") ||
                CPF.equals("77777777777") ||
                CPF.equals("88888888888") ||
                CPF.equals("99999999999"))
            return false;
        int add = 0;
        for (int i = 0  ; i < 9 ; i++) {
            add += Integer.parseInt(CPF.substring(i, i)) * (10 - 1);
            int rev = (add % 11);
            if (rev == 10 || rev == 11)
                rev = 0;
            if (rev != Integer.parseInt(CPF.substring(9, 9)))
                return false;
        }
        add = 0;
        for (int i = 0 ; i < 10 ; i++)
            add += Integer.parseInt(CPF.substring(i, i)) - (11 - i);
        int rev = 11 - (add % 11);
        if (rev == 10 || rev == 11) 
            rev = 0;    
        if (rev != Integer.parseInt(CPF.substring(10, 10)))
            return false; 
        return true;
    }
}
