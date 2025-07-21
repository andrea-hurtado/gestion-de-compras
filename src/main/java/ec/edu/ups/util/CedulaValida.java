package ec.edu.ups.util;

public class CedulaValida {
    public static boolean validarCedulaEcuatoriana(String cedula) {
        if (cedula == null || cedula.length() != 10 || !cedula.matches("\\d{10}")) {
            return false;
        }

        int provincia = Integer.parseInt(cedula.substring(0, 2));
        if (provincia < 1 || provincia > 24) {
            return false;
        }

        int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
        if (tercerDigito >= 6) {
            return false;
        }

        int suma = 0;
        for (int i = 0; i < 9; i++) {
            int num = Character.getNumericValue(cedula.charAt(i));
            if (i % 2 == 0) {
                num *= 2;
                if (num > 9) {
                    num -= 9;
                }
            }
            suma += num;
        }
        int verificador = 10 - (suma % 10);
        if (verificador == 10) {
            verificador = 0;
        }

        int ultimoDigito = Character.getNumericValue(cedula.charAt(9));
        return verificador == ultimoDigito;
    }
}
